package com.lyon_yan.module.wxpay.bean.pay_protocol;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lyon_yan.module.wxpay.config.Configure;
import com.lyon_yan.module.wxpay.core.RandomStringGenerator;
import com.lyon_yan.module.wxpay.core.Signature;

/**
 * @author Lyon
 */
@SuppressWarnings("serial")
public class ScanPayReqData  implements Serializable{

    /**
	 * 
	 */
	//每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
	private String sub_mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String body = "";
    private String attach = "";
    private String out_trade_no = "";
    private int total_fee = 0;
    private String spbill_create_ip = "";
    private String time_start = "";
    private String time_expire = "";
    private String goods_tag = "";
    private String auth_code = "";

    public ScanPayReqData(String authCode,String body,String outTradeNo,int totalFee,String spBillCreateIP){

        setAppid(Configure.getAppid());

        setMch_id(Configure.getMchid());
		setSub_mch_id(Configure.getSubMchid());
        setAuth_code(authCode);
        setBody(body);
        setOut_trade_no(outTradeNo);
        setTotal_fee(totalFee);
        setSpbill_create_ip(spBillCreateIP);
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
        String sign = Signature.getSign(toMap());
        setSign(sign);
    }
    
    public ScanPayReqData(String authCode,String body,String attach,String outTradeNo,int totalFee,String deviceInfo,String spBillCreateIP,String timeStart,String timeExpire,String goodsTag){

        setAppid(Configure.getAppid());

        setMch_id(Configure.getMchid());
        setSub_mch_id(Configure.getSubMchid());
        setAuth_code(authCode);
        setBody(body);
        setAttach(attach);
        setOut_trade_no(outTradeNo);
        setTotal_fee(totalFee);
        setDevice_info(deviceInfo);
        setSpbill_create_ip(spBillCreateIP);
        setTime_start(timeStart);
        setTime_expire(timeExpire);
        setGoods_tag(goodsTag);
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
        String sign = Signature.getSign(toMap());
        setSign(sign);
    }

    public String getAppid() {
        return appid;
    }

    public String getAttach() {
        return attach;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public String getBody() {
        return body;
    }

    public String getDevice_info() {
        return device_info;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public String getMch_id() {
        return mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public String getSign() {
        return sign;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public String getSub_mch_id() {
		return sub_mch_id;
	}

    public String getTime_expire() {
        return time_expire;
    }

    public String getTime_start() {
        return time_start;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

	public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

	public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if (obj != null&&!obj.toString().equals("")) {
					map.put(field.getName(), obj);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

}
