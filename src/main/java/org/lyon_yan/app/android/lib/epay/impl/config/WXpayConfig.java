package org.lyon_yan.app.android.lib.epay.impl.config;

import com.lyon_yan.module.wxpay.config.Configure;

/**
 * Created by yanni on 2016/2/29.
 */
public class WXpayConfig {
    public static String notify_url;
    /**
     * 初始化微信配置
     * @param value_Appid
     * @param value_Mchid
     * @param value_wkey
     * @param value_sub_mch_id
     */
    public static void init(String value_Appid, String value_Mchid, String value_wkey, String value_sub_mch_id) {
        Configure.setAppID(value_Appid);
        Configure.setMchID(value_Mchid);
        Configure.setKey(value_wkey);
        Configure.setSubMchID(value_sub_mch_id);
    }
}
