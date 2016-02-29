package org.lyon_yan.app.android.lib.epay;

import org.lyon_yan.app.android.lib.epay.impl.config.AlipayConfig;

/**
 * 支付参数配置
 * Created by yanni on 2016/2/29.
 */
public class EpayConfig {

    /**
     * 支付宝配置
     */
    public static void initAlipayConfig(String PARTNER, String APP_ID) {
        if (PARTNER != null)
            AlipayConfig.PARTNER = PARTNER.trim();
        if (APP_ID != null)
            AlipayConfig.APP_ID = APP_ID.trim();

        /**
         * 支付宝公钥-从支付宝服务窗获取
         */
        AlipayConfig.ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkr"
                + "IvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsra"
                + "prwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUr" + "CmZYI/FCEa3/cNMW0QIDAQAB";
        /**
         * 签名编码-视支付宝服务窗要求
         */
        AlipayConfig.SIGN_CHARSET = "UTF-8";

        /**
         * 字符编码-传递给支付宝的数据编码
         */
        AlipayConfig.CHARSET = "UTF-8";
        /**
         * 签名类型-视支付宝服务窗要求
         */
        AlipayConfig.SIGN_TYPE = "RSA";
        // 开发者请使用openssl生成的密钥替换此处
        // 请看文档：https://fuwu.alipay.com/platform/doc.htm#2-1接入指南
        // TODO !!!! 注：该私钥为测试账号私钥 开发者必须设置自己的私钥 , 否则会存在安全隐患
        AlipayConfig.PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAO+IAG/Hjc9hNTDk"
                + "Fpt94qlYTUeaqad2UhlBaK0oBjXEyiyBhKLxwQF4eJcLFcaLfkzOdvacHPZg/2mI"
                + "OKllt7ghFEX+AaoWuNbPgQYyXNz/aSz+6QxVY+ZhZ5w2WH5ZBHcUesgBRQf84l2P"
                + "VvDj397NE5kkhNBge09nc53jl+zbAgMBAAECgYAjVAnMcsBFr+6qcVmsQVrm4zEy"
                + "uGsBWgAt3WnU8CxKTeYLvmaTqdhvoRcYH/hsOjK8nU8KfGgBJrlFFWRWB7ya0KZB"
                + "0T3a6gFPcEt/VBiGJhn08r4V2Mzk/m92x+dG0go1RylkS28BC0KBky0BqWrNL7iC"
                + "03r8fHedCSX1JksnsQJBAPzcAQYPeAUzJV+UUOBbTyHKdMRk1IfFaY6KdeJznE5P"
                + "JnDKdtLYo6JPRTZpm4OREVy7Gtui86KSRtkNZnK/F08CQQDygZ6NfJmS64O8Onoc"
                + "kGfROPAlP5t3vIbMtRKj0rIEUyDTLzFTM9x7HA0gVzJaND+7hFZYnnyC5mXrtGQj"
                + "3+61AkEAh9OWKS8+BW0H8mO1Xg8uXrRmLOkM0THWFd+Cm3YGzHnv6D6ZvYDpxVJX"
                + "l3b7Np1CelF3h+vse7OfoxBzq8fCOQJAUzohDDXjDwU9JPB80CjPOILuCBqYZLOT"
                + "H9ZVG1xINCvDbDcaGpAF70plRuAmK8cayGRWrftWiCZCfG5gn99OsQJBANwA6ivN"
                + "uXaCj6yFUE8vEXM1J1oX210oofLpq5WPH6pDo/ee5Qpx/dhzS+lh9DXe/z38SrI7" + "4OJCEm9lBZeQKjM=";
        // TODO !!!! 注：该公钥为测试账号公钥 开发者必须设置自己的公钥 ,否则会存在安全隐患
        AlipayConfig.PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcskDEloA6mYF2bmE8/N9J0yCOORWnteM2ObxKlOz3L45jicZoF5LfXH//oYEBNpOn5k90re5whtmSe/dl7mhcKSESarLc/2FZUnH2gu+S9n/bB7EAZMLFLHF+fsJZnhX68Vjxh7olYQ9V86pmNJsQLfklwykgMBffU01RKY+qMwIDAQAB";
        AlipayConfig.ALIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do";
    }
}
