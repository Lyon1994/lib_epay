package org.lyon_yan.app.android.lib.epay.impl;

import com.lyon_yan.module.wxpay.bean.ResponseBeanFactory;
import com.lyon_yan.module.wxpay.bean.create_order_protocol.CreateOrderReqData;
import com.lyon_yan.module.wxpay.bean.create_order_protocol.CreateOrderResData;
import com.lyon_yan.module.wxpay.bean.pay_protocol.ScanPayReqData;
import com.lyon_yan.module.wxpay.bean.pay_protocol.ScanPayResData;
import com.lyon_yan.module.wxpay.bean.pay_query_protocol.PayQueryReqData;
import com.lyon_yan.module.wxpay.bean.pay_query_protocol.PayQueryResData;
import com.lyon_yan.module.wxpay.config.Configure;
import com.lyon_yan.module.wxpay.core.NetClentProxy;
import com.lyon_yan.module.wxpay.core.XMLFactory;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.lyon_yan.app.android.lib.epay.EpayRequestSubmit;
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
import org.lyon_yan.app.android.lib.epay.impl.config.WXpayConfig;
import org.lyon_yan.app.android.lib_lyon_yan_utils.refeclt.ObjectByJsonObjectUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 微信线下支付
 * Created by yanni on 2016/2/14.
 */
public class WXpay extends EpayRequestSubmit {
    @Override
    public ResponseQrCodeCreate qrCodeCreate(RequestQrCodeCreate requestQrCodeCreate) {
        if (requestQrCodeCreate.getOut_trade_no() == null || requestQrCodeCreate.getOut_trade_no().length() == 0) {
            requestQrCodeCreate.setOut_trade_no(OrderNo.getOrderNo());
            if (getTrade_order_no_prefx() != null || !getTrade_order_no_prefx().equals("")) {
                requestQrCodeCreate.setOut_trade_no(getTrade_order_no_prefx() + requestQrCodeCreate.getOut_trade_no());
            }
        }
        if (requestQrCodeCreate.getSubject() == null || requestQrCodeCreate.getSubject().length() == 0)
            requestQrCodeCreate.setSubject(requestQrCodeCreate.getOut_trade_no());
        CreateOrderReqData createOrderReqData = new CreateOrderReqData(
                requestQrCodeCreate.getSubject(), requestQrCodeCreate.getOut_trade_no(), (int) (Float.valueOf(requestQrCodeCreate.getTotal_amount()) * 100),
                "127.0.0.1", WXpayConfig.notify_url, requestQrCodeCreate.getOut_trade_no());
//        createOrderReqData.setDevice_info(requestQrCodeCreate.getTerminal_id());
//        createOrderReqData
//        createOrderReqData.setAttach(new Attach(requestQrCodeCreate.getStore_id(), requestQrCodeCreate.getOperator_id()).toString());
        String xml = XMLFactory.getXMLFromeMap(createOrderReqData);
        String result = new NetClentProxy(true).sendPost(Configure.CREATE_ORDER_API, xml);
        CreateOrderResData createOrderResData = ResponseBeanFactory.getCreateOrderResData(result);
        /**
         * 转化为通用对象
         */
        ResponseQrCodeCreate responseQrCodeCreate = new ResponseQrCodeCreate();
        responseQrCodeCreate.setMain_class_name(getMainClassName());
        responseQrCodeCreate.setOut_trade_no(requestQrCodeCreate.getOut_trade_no());
        responseQrCodeCreate.setQr_code(createOrderResData.getCode_url());
        responseQrCodeCreate.setCode(createOrderResData.getReturn_code());
        responseQrCodeCreate.setSub_code(createOrderResData.getResult_code());
        responseQrCodeCreate.setMsg(createOrderResData.getReturn_code());
        responseQrCodeCreate.setSub_desc(createOrderResData.getReturn_msg());
        check_is_request_ok:
        {
            if (createOrderResData.getReturn_code() != null && "FAIL".equals(createOrderResData.getReturn_code())) {
                responseQrCodeCreate.setIsCodeSuccess(false);
                responseQrCodeCreate.setSub_desc(createOrderResData.getReturn_msg());
                responseQrCodeCreate.setIs_success(false);
            } else {
                responseQrCodeCreate.setIsCodeSuccess(true);
                responseQrCodeCreate.setIs_success(true);
            }
        }
        return responseQrCodeCreate;
    }

    @Override
    public ResponseScanQRCodePay scanQRCodePay(RequestScanQRCodePay requestScanQRCodePay) {
        if (requestScanQRCodePay.getOut_trade_no() == null || requestScanQRCodePay.getOut_trade_no().length() == 0) {
            requestScanQRCodePay.setOut_trade_no(OrderNo.getOrderNo());
            if (getTrade_order_no_prefx() != null && !getTrade_order_no_prefx().equals("")) {
                requestScanQRCodePay.setOut_trade_no(getTrade_order_no_prefx() + requestScanQRCodePay.getOut_trade_no());
            }
        }
//        if (requestScanQRCodePay.getTimeout_express() == null || requestScanQRCodePay.getTimeout_express().length() == 0)
//            requestScanQRCodePay.setTimeout_express(OrderNo.getOrderTimeExpire(1, 0, 0, 0));
        if (requestScanQRCodePay.getSubject() == null || requestScanQRCodePay.getSubject().length() == 0)
            requestScanQRCodePay.setSubject(requestScanQRCodePay.getOut_trade_no());

        ScanPayReqData scanPayReqData = new ScanPayReqData(requestScanQRCodePay.getAuth_code(), "微信线下支付订单", requestScanQRCodePay.getOut_trade_no(), (int) (Float.valueOf(requestScanQRCodePay.getTotal_amount()) * 100), "127.0.0.1");
        scanPayReqData.setAttach(new Attach(requestScanQRCodePay.getStore_id(), requestScanQRCodePay.getOperator_id()).toString());
        ScanPayResData scanPayResData = ResponseBeanFactory.getScanPayResData(new NetClentProxy(true).sendPost(Configure.PAY_API, XMLFactory.getXMLFromeMap(scanPayReqData)));
        /**
         * 对象转化
         */
        ResponseScanQRCodePay responseScanQRCodePay = new ResponseScanQRCodePay();
        responseScanQRCodePay.setMain_class_name(getMainClassName());
        responseScanQRCodePay.setTrade_no(scanPayResData.getTransaction_id());
        responseScanQRCodePay.setOut_trade_no(scanPayResData.getOut_trade_no());
        responseScanQRCodePay.setBuyer_user_id("微信订单，不显示付款账号");
        responseScanQRCodePay.setBuyer_logon_id("微信订单，不显示付款账号");
        responseScanQRCodePay.setTotal_amount(new DecimalFormat("#.00")
                .format(Integer.valueOf(scanPayResData.getTotal_fee() == null || scanPayResData.getTotal_fee().equals("") ? "0" : scanPayResData.getTotal_fee()) / 100f));
        responseScanQRCodePay.setReceipt_amount(responseScanQRCodePay.getTotal_amount());
        responseScanQRCodePay.setGmt_payment(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        Attach attach = Attach.load(responseScanQRCodePay.getAttach());
//        responseQueryOrder.setStore_id(attach.getStore_id());
//        responseQueryOrder.setStore_name(attach.getStoreName());
//        if (response.getFundBillList() != null) {
//            List<EpayTradeFundBill> epayTradeFundBills = new ArrayList<>();
//            for (TradeFundBill tradeFundBill : response.getFundBillList()) {
//                epayTradeFundBills.add(new EpayTradeFundBill(tradeFundBill.getAmount(), tradeFundBill.getFundChannel()));
//            }
//            responseQueryOrder.setFund_bill_list(epayTradeFundBills);
//        }

        responseScanQRCodePay.setIs_success(scanPayResData.getTotal_fee() != null && !responseScanQRCodePay.equals(""));
        responseScanQRCodePay.setIsCodeSuccess(responseScanQRCodePay.is_success());
        responseScanQRCodePay.setCode(scanPayResData.getReturn_code());
        responseScanQRCodePay.setSub_code(scanPayResData.getResult_code());
        responseScanQRCodePay.setMsg(scanPayResData.getReturn_msg());
        responseScanQRCodePay.setSub_desc(scanPayResData.getErr_code_des());
        return responseScanQRCodePay;
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
        PayQueryReqData payQueryReqData = new PayQueryReqData("", requestQueryOrder.getOut_trade_no());
        NetClentProxy netClentProxy = new NetClentProxy(true);
        PayQueryResData payQueryResData = ResponseBeanFactory.getOrderQueryResData(netClentProxy.sendPost(Configure.PAY_QUERY_API, XMLFactory.getXMLFromeMap(payQueryReqData)));
        /**
         * 通用对象转化
         */
        ResponseQueryOrder responseQueryOrder = new ResponseQueryOrder();
        responseQueryOrder.setMain_class_name(getMainClassName());
        responseQueryOrder.setTrade_no(payQueryResData.getTransaction_id());
        responseQueryOrder.setOut_trade_no(payQueryResData.getOut_trade_no());
        responseQueryOrder.setBuyer_user_id("微信订单，不显示付款账号");
        responseQueryOrder.setBuyer_logon_id("微信订单，不显示付款账号");
        responseQueryOrder.setTrade_status(payQueryResData.getTrade_state());
        responseQueryOrder.setTotal_amount((Integer.valueOf((payQueryResData.getTotal_fee() == null || payQueryResData.getTotal_fee().equals("")) ? "0" : payQueryResData.getTotal_fee()) / 100f) + "");
        responseQueryOrder.setReceipt_amount(responseQueryOrder.getTotal_amount());
        responseQueryOrder.setBuyer_pay_amount(responseQueryOrder.getTotal_amount());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            responseQueryOrder.setSend_pay_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sdf.parse(payQueryResData.getTime_end())));
        } catch (ParseException e) {
            responseQueryOrder.setSend_pay_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        responseQueryOrder.setTerminal_id(payQueryResData.getDevice_info());
        if (payQueryResData.getAttach() != null && !payQueryResData.getAttach().equals("")) {
            Attach attach = Attach.load(payQueryResData.getAttach());
            responseQueryOrder.setStore_id(attach.getStore_id());
        }
//        if (response.getFundBillList() != null) {
//            List<EpayTradeFundBill> epayTradeFundBills = new ArrayList<>();
//            for (TradeFundBill tradeFundBill : response.getFundBillList()) {
//                epayTradeFundBills.add(new EpayTradeFundBill(tradeFundBill.getAmount(), tradeFundBill.getFundChannel()));
//            }
//            responseQueryOrder.setFund_bill_list(epayTradeFundBills);
//        }

        responseQueryOrder.setIs_success(payQueryResData.getReturn_code() != null || payQueryResData.getResult_code() != null);
        responseQueryOrder.setIsCodeSuccess(payQueryResData.getReturn_code() != null && payQueryResData.getResult_code() != null && "SUCCESS".equals(payQueryResData.getReturn_code()) && "SUCCESS".equals(payQueryResData.getResult_code()));
        responseQueryOrder.setCode(payQueryResData.getReturn_code());
        responseQueryOrder.setSub_code(payQueryResData.getResult_code());
        responseQueryOrder.setMsg(payQueryResData.getTrade_state_desc());
        responseQueryOrder.setSub_desc(payQueryResData.getTrade_state_desc());
        if ("SUCCESS".equals(payQueryResData.getReturn_code()) && "SUCCESS".equals(payQueryResData.getResult_code())) {
            switch (payQueryResData.getTrade_state()) {
                case "SUCCESS":
                    responseQueryOrder.setIsTradeSuccess(true);
                    break;
                case "REFUND":
                    responseQueryOrder.setIsTradeFinished(true);
                    break;
                case "NOTPAY":
                    responseQueryOrder.setIsCodeSuccess(false);
                    break;
                case "CLOSE":
                    responseQueryOrder.setIsTradeFinished(true);
                    break;
                case "REVOKED":
                    responseQueryOrder.setIsTradeFinished(true);
                    break;
                case "USERPAYING":
                    responseQueryOrder.setIsWaitBuyerPay(true);
                    break;
                case "PAYERROR":
                    break;
                default:

                    break;
            }
        }
        return responseQueryOrder;
    }

    @Override
    public String getMainClassName() {
        return null;
    }

    @Override
    public boolean is_can_refund() {
        return false;
    }

    /**
     * 微信附加数据
     */
    public static class Attach {
        /**
         * 操作员ID
         */
        private String operator_id;
        /**
         * 商户自定义ID
         */
        private String store_id;

        public String getOperator_id() {
            return operator_id;
        }

        public void setOperator_id(String operator_id) {
            this.operator_id = operator_id;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        @Override
        public String toString() {
            try {
                return ObjectByJsonObjectUtils.tojsonObject(this).toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return new JSONObject().toString();
            }
        }

        public static Attach load(String json) {
            Attach attach = new Attach();
            JSONTokener jsonTokener = new JSONTokener(json);
            try {
                JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();
                ObjectByJsonObjectUtils.loadThisObjectByJsonObject(attach, jsonObject);
                return attach;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        public Attach() {
        }

        public Attach(String operator_id, String store_id) {
            this.operator_id = operator_id;
            this.store_id = store_id;
        }
    }
}
