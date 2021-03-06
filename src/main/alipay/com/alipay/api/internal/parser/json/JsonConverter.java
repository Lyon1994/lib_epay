package com.alipay.api.internal.parser.json;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.AlipayRequest;
import com.alipay.api.AlipayResponse;
import com.alipay.api.SignItem;
import com.alipay.api.internal.mapping.Converter;
import com.alipay.api.internal.mapping.Converters;
import com.alipay.api.internal.mapping.Reader;
import com.alipay.api.internal.util.StringUtils;
import com.alipay.api.internal.util.json.ExceptionErrorListener;
import com.alipay.api.internal.util.json.JSONReader;
import com.alipay.api.internal.util.json.JSONValidatingReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.lyon_yan.app.android.lib.epay.core.KeyUtils;
import org.lyon_yan.app.android.lib_lyon_yan_utils.refeclt.RefecltUtils;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * JSON格式转换器。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class JsonConverter implements Converter {
    /**
     * 将返回值的结果转化为对象
     *
     * @param rsp   响应字符串
     * @param clazz 领域类型
     * @param <T>
     * @return
     * @throws AlipayApiException
     */
    public <T extends AlipayResponse> T toResponse(String rsp, Class<T> clazz)
            throws AlipayApiException {
        /**
         * LyonYan
         */
        JSONTokener jsonTokener = new JSONTokener(rsp);
        try {
            T t = clazz.newInstance();
            JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();
            if (jsonObject.length() > 0) {
                if (jsonObject.has("sign")) jsonObject.remove("sign");
                jsonObject = jsonObject.getJSONObject(jsonObject.keys().next());
                Class supperClass = clazz.getSuperclass();
                Field[] fields = clazz.getDeclaredFields();
                Field[] supperFields = supperClass.getDeclaredFields();
                for (Field field : supperFields) {
                    field.setAccessible(true);
                    String k = field.getName();
                    if (!jsonObject.has(k))
                        k = KeyUtils.getLowerCaseKey(k);
                    if (jsonObject.has(k))
                        field.set(t, jsonObject.getString(k));
                }
                for (Field field : fields) {
                    field.setAccessible(true);
                    String k = field.getName();
                    if (!jsonObject.has(k))
                        k = KeyUtils.getLowerCaseKey(k);
                    if (jsonObject.has(k)) {
                        if (List.class.isAssignableFrom(field.getType())) {
                            Class returnTypeClass = RefecltUtils.getGenericClassFromType(field);
                            List list = new ArrayList();
                            JSONArray jsonArray = jsonObject.getJSONArray(k);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                Field[] fields1 = returnTypeClass.getDeclaredFields();
                                for (Field field1 : fields1) {
                                    field1.setAccessible(true);
                                    String k1 = field1.getName();
                                    Object o = returnTypeClass.newInstance();
                                    if (!jsonObject.has(k1))
                                        k1 = KeyUtils.getLowerCaseKey(k1);
                                    if (jsonObject1.has(k1))
                                        field1.set(o, jsonObject1.getString(k1));
                                    list.add(o);
                                }
                            }
                            field.set(t, list);
                        }else if(Date.class.isAssignableFrom(field.getType())){
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            field.set(t, sdf.parse(jsonObject.getString(k)));
                        }else
                            field.set(t, jsonObject.getString(k));
                    }
                }
                return t;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**the end*/
        JSONReader reader = new JSONValidatingReader(new ExceptionErrorListener());
        Object rootObj = reader.read(rsp);
        if (rootObj instanceof Map<?, ?>) {
            Map<?, ?> rootJson = (Map<?, ?>) rootObj;
            Collection<?> values = rootJson.values();
            for (Object rspObj : values) {
                if (rspObj instanceof Map<?, ?>) {
                    Map<?, ?> rspJson = (Map<?, ?>) rspObj;
                    return fromJson(rspJson, clazz);
                }
            }
        }
        return null;
    }

    /**
     * 把JSON格式的数据转换为对象。
     *
     * @param <T>   泛型领域对象
     * @param json  JSON格式的数据
     * @param clazz 泛型领域类型
     * @return 领域对象
     */
    public <T> T fromJson(final Map<?, ?> json, Class<T> clazz) throws AlipayApiException {
        return Converters.convert(clazz, new Reader() {
            public boolean hasReturnField(Object name) {
                return json.containsKey(name);
            }

            public Object getPrimitiveObject(Object name) {
                return json.get(name);
            }

            public Object getObject(Object name, Class<?> type) throws AlipayApiException {
                Object tmp = json.get(name);
                if (tmp instanceof Map<?, ?>) {
                    Map<?, ?> map = (Map<?, ?>) tmp;
                    return fromJson(map, type);
                } else {
                    return null;
                }
            }

            public List<?> getListObjects(Object listName, Object itemName, Class<?> subType)
                    throws AlipayApiException {
                List<Object> listObjs = null;

                Object listTmp = json.get(listName);
                if (listTmp instanceof Map<?, ?>) {
                    Map<?, ?> jsonMap = (Map<?, ?>) listTmp;
                    Object itemTmp = jsonMap.get(itemName);
                    if (itemTmp == null && listName != null) {
                        String listNameStr = listName.toString();
                        itemTmp = jsonMap.get(listNameStr.substring(0, listNameStr.length() - 1));
                    }
                    if (itemTmp instanceof List<?>) {
                        listObjs = getListObjectsInner(subType, itemTmp);
                    }
                } else if (listTmp instanceof List<?>) {
                    listObjs = getListObjectsInner(subType, listTmp);
                }

                return listObjs;
            }

            private List<Object> getListObjectsInner(Class<?> subType, Object itemTmp)
                    throws AlipayApiException {
                List<Object> listObjs;
                listObjs = new ArrayList<Object>();
                List<?> tmpList = (List<?>) itemTmp;
                for (Object subTmp : tmpList) {
                    Object obj = null;
                    if (String.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Long.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Integer.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Boolean.class.isAssignableFrom(subType)) {
                        obj = subTmp;
                    } else if (Date.class.isAssignableFrom(subType)) {
                        DateFormat format = new SimpleDateFormat(AlipayConstants.DATE_TIME_FORMAT);
                        try {
                            obj = format.parse(String.valueOf(subTmp));
                        } catch (ParseException e) {
                            throw new AlipayApiException(e);
                        }
                    } else if (subTmp instanceof Map<?, ?>) {// object
                        Map<?, ?> subMap = (Map<?, ?>) subTmp;
                        obj = fromJson(subMap, subType);
                    }

                    if (obj != null) {
                        listObjs.add(obj);
                    }
                }
                return listObjs;
            }

        });
    }

    /**
     * @see com.alipay.api.internal.mapping.Converter#getSignItem(com.alipay.api.AlipayRequest, com.alipay.api.AlipayResponse)
     */
    public SignItem getSignItem(AlipayRequest<?> request, AlipayResponse response)
            throws AlipayApiException {

        String body = response.getBody();

        // 响应为空则直接返回
        if (StringUtils.isEmpty(body)) {

            return null;
        }

        SignItem signItem = new SignItem();

        // 获取签名
        String sign = getSign(body);
        signItem.setSign(sign);

        // 签名源串
        String signSourceData = getSignSourceData(request, body);
        signItem.setSignSourceDate(signSourceData);

        return signItem;
    }

    /**
     * @param request
     * @param body
     * @return
     */
    private String getSignSourceData(AlipayRequest<?> request, String body) {

        // 加签源串起点
        String rootNode = request.getApiMethodName().replace('.', '_')
                + AlipayConstants.RESPONSE_SUFFIX;
        String errorRootNode = AlipayConstants.ERROR_RESPONSE;

        int indexOfRootNode = body.indexOf(rootNode);
        int indexOfErrorRoot = body.indexOf(errorRootNode);

        // 成功或者新版接口
        if (indexOfRootNode > 0) {

            return parseSignSourceData(body, rootNode, indexOfRootNode);

            // 老版本失败接口
        } else if (indexOfErrorRoot > 0) {

            return parseSignSourceData(body, errorRootNode, indexOfErrorRoot);
        } else {
            return null;
        }
    }

    /**
     * 获取签名源串内容
     *
     * @param body
     * @param rootNode
     * @param indexOfRootNode
     * @return
     */
    private String parseSignSourceData(String body, String rootNode, int indexOfRootNode) {

        //  第一个字母+长度+引号和分号
        int signDataStartIndex = indexOfRootNode + rootNode.length() + 2;
        int indexOfSign = body.indexOf("\"" + AlipayConstants.SIGN + "\"");

        if (indexOfSign < 0) {

            return null;
        }

        // 签名前-逗号
        int signDataEndIndex = indexOfSign - 1;

        return body.substring(signDataStartIndex, signDataEndIndex);
    }

    /**
     * 获取签名
     *
     * @param body
     * @return
     */
    private String getSign(String body) {

        JSONReader reader = new JSONValidatingReader(new ExceptionErrorListener());
        Object rootObj = reader.read(body);
        Map<?, ?> rootJson = (Map<?, ?>) rootObj;

        return (String) rootJson.get(AlipayConstants.SIGN);
    }

}
