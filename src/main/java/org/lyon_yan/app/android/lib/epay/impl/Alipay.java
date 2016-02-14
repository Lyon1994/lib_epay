package org.lyon_yan.app.android.lib.epay.impl;

import android.util.Log;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.lyon_yan.app.android.lib.epay.Submit;
import org.lyon_yan.app.android.lib.epay.core.OrderNo;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestCancelOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestCancelOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestQrCodeCreate;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestQueryOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestQueryOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestRefundOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestRefundOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestScanQRCodePay;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseCancelOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseCancelOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQrCodeCreate;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQueryOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQueryOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseRefundOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseRefundOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseScanQRCodePay;

import java.text.SimpleDateFormat;

/**
 * 支付宝线下支付
 * Created by yanni on 2016/2/14.
 */
public class Alipay extends Submit {
    private AlipayClient alipayClient = null;

    @Override
    public ResponseQrCodeCreate qrCodeCreate(RequestQrCodeCreate requestQrCodeCreate) {
        return null;
    }

    @Override
    public ResponseScanQRCodePay scanQRCodePay(RequestScanQRCodePay requestScanQRCodePay) {

        if (requestScanQRCodePay.getOut_trade_no() == null)
            requestScanQRCodePay.setOut_trade_no(OrderNo.getOrderNo());
        if (requestScanQRCodePay.getTimeout_express() == null)
            requestScanQRCodePay.setTimeout_express(OrderNo.getOrderTimeExpire(1, 0, 0, 0));
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("out_trade_no", requestScanQRCodePay.getOut_trade_no());
            jsonObject.put("total_amount", requestScanQRCodePay.getTotal_amount());
            jsonObject.put("subject", requestScanQRCodePay.getSubject());
            jsonObject.put("operator_id", requestScanQRCodePay.getOperator_id());
            jsonObject.put("terminal_id", requestScanQRCodePay.getTerminal_id());
            jsonObject.put("time_expire", requestScanQRCodePay.getTimeout_express());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.setBizContent(jsonObject.toString());
        try {
            AlipayTradePayResponse response = getAlipayClient().execute(request);
            ResponseScanQRCodePay responseScanQRCodePay = new ResponseScanQRCodePay();
            responseScanQRCodePay.setOut_trade_no(response.getOutTradeNo());
            responseScanQRCodePay.setIs_success(response.isSuccess());
            responseScanQRCodePay.setBuyer_logon_id(response.getBuyerLogonId());
            responseScanQRCodePay.setBuyer_user_id(response.getBuyerUserId());
            if (response.getGmtPayment() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                responseScanQRCodePay.setGmt_payment(sdf.format(response.getGmtPayment()));
            }
            responseScanQRCodePay.setReceipt_amount(response.getReceiptAmount());
            responseScanQRCodePay.setStore_name(response.getStoreName());
            responseScanQRCodePay.setTotal_amount(response.getTotalAmount());
            responseScanQRCodePay.setTrade_no(response.getTradeNo());
            Log.v("----------", "response:" + response.getBody());
            return responseScanQRCodePay;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseRefundOrder refundOrder(RequestRefundOrder requestRefundOrder) {
        return null;
    }

    @Override
    public ResponseRefundOrderRetry refundOrderRetry(RequestRefundOrderRetry requestRefundOrderRetry) {
        return null;
    }

    @Override
    public ResponseCancelOrderRetry cancelOrderRetry(RequestCancelOrderRetry requestCancelOrderRetry) {
        return null;
    }

    @Override
    public ResponseCancelOrder cancelOrder(RequestCancelOrder requestCancelOrder) {
        return null;
    }

    @Override
    public ResponseQueryOrderRetry queryOrderRetry(RequestQueryOrderRetry requestQueryOrderRetry) {
        return null;
    }

    @Override
    public ResponseQueryOrder queryOrder(RequestQueryOrder requestQueryOrder) {
        return null;
    }


    public static class Config {
        /**
         * 支付宝公钥-从支付宝服务窗获取
         */
        public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkr"
                + "IvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsra"
                + "prwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUr" + "CmZYI/FCEa3/cNMW0QIDAQAB";
//	public static final String ALIPAY_PUBLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
        /**
         * 签名编码-视支付宝服务窗要求
         */
        public static final String SIGN_CHARSET = "UTF-8";

        /**
         * 字符编码-传递给支付宝的数据编码
         */
        public static final String CHARSET = "UTF-8";

        /**
         * 签名类型-视支付宝服务窗要求
         */
        public static final String SIGN_TYPE = "RSA";

        public static final String PARTNER = "2088511269267373";

        /**
         * 服务窗appId
         */
        // TODO !!!! 注：该appId必须设为开发者自己的服务窗id 这里只是个测试id
        public static final String APP_ID = "2014120200018454";// 2014083000009991
        // //2014120200018454

        // 开发者请使用openssl生成的密钥替换此处
        // 请看文档：https://fuwu.alipay.com/platform/doc.htm#2-1接入指南
        // TODO !!!! 注：该私钥为测试账号私钥 开发者必须设置自己的私钥 , 否则会存在安全隐患
        public static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAO+IAG/Hjc9hNTDk"
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
        //	public static final String PRIVATE_KEY="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANyyQMSWgDqZgXZuYTz830nTII45Fae14zY5vEqU7PcvjmOJxmgXkt9cf/+hgQE2k6fmT3St7nCG2ZJ792XuaFwpIRJqstz/YVlScfaC75L2f9sHsQBkwsUscX5+wlmeFfrxWPGHuiVhD1XzqmY0mxAt+SXDKSAwF99TTVEpj6ozAgMBAAECgYEAn2k6E0XKdYlv1AXCwvS8rGyN9W0SUUO2TPLDKPQNfjahmRBpecKdWi1MX29e6WtsmDhpaBRCSJF/Eqnsd3oPcjqgy6hi3blCtEO7OvAqiS2dP4m6iiqaD2Nkjm64xK7TJW7DC0fW868lQeMSN2a/yKUc4xQzI3WPn5bYfUJzmnECQQD4mucc6ZXrAW0jJovT+4YElliYFPpSVw5Hrqi4gWNuqY4MbTfuTjLxNSVGbGE9liu9Ct8S8KTcD5SBZAJ4th8FAkEA40LUBkTkKENAnF0809lWyKtHn//EljMdft2KUPXZUeqJX3Cj/AdD1hxmK4nIIaYSvScJXhWBU8ccHVn0KD251wJAJHkddSlz/EF+UIzkMNqTA/NG1jEltJTfHHcse71H6EFp/Lq9XPIOGUNRz64w6gcxLY/9wFqb5UlH4V/Z2PnnPQJAYdAOj5AxHv8rHOGoX4nopz/I+R1NUFQ5urPBZ20ZFv+6FoDVo5DA6rOYad7Ia2seH5lgl8Trv9Iv0JY51uQSSwJAOWshRD5hqWBwrYMi9Vqy61olFnTfmwjIjwMN9hN1tnrhy3yPLozwu/tcCFTGsGNSWso5JUg3gihnOW9ZYiS4Vw==";
        // TODO !!!! 注：该公钥为测试账号公钥 开发者必须设置自己的公钥 ,否则会存在安全隐患
//	public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDviABvx43PYTUw5BabfeKpWE1H"
//			+ "mqmndlIZQWitKAY1xMosgYSi8cEBeHiXCxXGi35Mznb2nBz2YP9piDipZbe4IRRF"
//			+ "/gGqFrjWz4EGMlzc/2ks/ukMVWPmYWecNlh+WQR3FHrIAUUH/OJdj1bw49/ezROZ" + "JITQYHtPZ3Od45fs2wIDAQAB";
        public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcskDEloA6mYF2bmE8/N9J0yCOORWnteM2ObxKlOz3L45jicZoF5LfXH//oYEBNpOn5k90re5whtmSe/dl7mhcKSESarLc/2FZUnH2gu+S9n/bB7EAZMLFLHF+fsJZnhX68Vjxh7olYQ9V86pmNJsQLfklwykgMBffU01RKY+qMwIDAQAB";
        /**
         * 支付宝网关
         */
        // public static final String ALIPAY_GATEWAY =
        // "http://openapi.alipaydev.com/gateway.do";
        public static final String ALIPAY_GATEWAY = "https://openapi.alipay.com/gateway.do";
    }

    private AlipayClient createAlipayClient() {
        return new DefaultAlipayClient(Config.ALIPAY_GATEWAY, Config.APP_ID, Config.PRIVATE_KEY,
                "json", Config.CHARSET);
    }

    private AlipayClient getAlipayClient() {
        if (alipayClient == null)
            alipayClient = createAlipayClient();
        return alipayClient;
    }

}
