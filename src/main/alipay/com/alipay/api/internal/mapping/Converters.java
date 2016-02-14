package com.alipay.api.internal.mapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * 转换工具类。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class Converters {
    // 是否对JSON返回的数据类型进行校验，默认不校验。给内部测试JSON返回时用的开关。
    //规则：返回的"基本"类型只有String,Long,Boolean,Date,采取严格校验方式，如果类型不匹配，报错
    public static boolean isCheckJsonType = false;

    private static final Set<String> baseFields = new HashSet<String>();

    private static final Set<String> excludeFields = new HashSet<String>();

    /**
     * 被子类覆盖的属性
     */
    private static final Set<String> overideFields = new HashSet<String>();

    static {
        baseFields.add("code");
        baseFields.add("msg");
        baseFields.add("subCode");
        baseFields.add("subMsg");
        baseFields.add("body");
        baseFields.add("params");
        baseFields.add("success");
    }

    static {
        excludeFields.add("errorCode");

    }

    static {

        overideFields.add("code");
        overideFields.add("msg");
    }

    private Converters() {
    }

    /**
     * 使用指定 的读取器去转换字符串为对象。
     *
     * @param <T>    领域泛型
     * @param clazz  领域类型
     * @param reader 读取器
     * @return 领域对象
     */
    public static <T> T convert(Class<T> clazz, Reader reader) {
        /**
         * LyonYan
         */
        reader.getPrimitiveObject(clazz.getName());
        try {
            T t = clazz.newInstance();
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 尝试获取属性
     * <p/>
     * 不会抛出异常，不存在则返回null
     *
     * @param clazz
     * @param itemName
     * @return
     */
    private static Field tryGetFieldWithoutExp(Class<?> clazz, String itemName) {

        try {

            return clazz.getDeclaredField(itemName);

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取属性设置属性
     *
     * @param clazz
     * @param field
     * @return
     */
    private static <T> Method tryGetSetMethod(Class<T> clazz, Field field, String methodName) {

        try {
            return clazz.getDeclaredMethod(methodName, field.getType());
        } catch (Exception e) {

            return null;
        }

    }
}
