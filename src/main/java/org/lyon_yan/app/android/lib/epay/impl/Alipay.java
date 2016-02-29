package org.lyon_yan.app.android.lib.epay.impl;

import android.util.Log;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.TradeFundBill;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;

import org.json.JSONException;
import org.json.JSONObject;
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
import org.lyon_yan.app.android.lib.epay.entity.response.EpayTradeFundBill;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseCancelOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseCancelOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQrCodeCreate;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQueryOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQueryOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseRefundOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseRefundOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseScanQRCodePay;
import org.lyon_yan.app.android.lib.epay.impl.config.AlipayConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 支付宝线下支付
 * Created by yanni on 2016/2/14.
 */
public class Alipay extends EpayRequestSubmit {
    private AlipayClient alipayClient = null;

    /**
     * 获取扩展参数<br>
     * 在这里意为传递返佣参数
     *
     * @return
     * @throws JSONException
     */
    private JSONObject getExtend_params(String sys_service_provider_id) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sys_service_provider_id", sys_service_provider_id);
        return jsonObject;
    }

    @Override
    public ResponseQrCodeCreate qrCodeCreate(RequestQrCodeCreate requestQrCodeCreate) {
        if (requestQrCodeCreate.getOut_trade_no() == null || requestQrCodeCreate.getOut_trade_no().length() == 0) {
            requestQrCodeCreate.setOut_trade_no(OrderNo.getOrderNo());
            if (getTrade_order_no_prefx() != null || !getTrade_order_no_prefx().equals("")) {
                requestQrCodeCreate.setOut_trade_no(getTrade_order_no_prefx() + requestQrCodeCreate.getOut_trade_no());
            }
        }
//        if (requestQrCodeCreate.getTimeout_express() == null || requestQrCodeCreate.getTimeout_express().length() == 0)
//            requestQrCodeCreate.setTimeout_express(OrderNo.getOrderTimeExpire(1, 0, 0, 0));
        if (requestQrCodeCreate.getSubject() == null || requestQrCodeCreate.getSubject().length() == 0)
            requestQrCodeCreate.setSubject(requestQrCodeCreate.getOut_trade_no());
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("out_trade_no", requestQrCodeCreate.getOut_trade_no());
            jsonObject.put("total_amount", requestQrCodeCreate.getTotal_amount());
            jsonObject.put("subject", requestQrCodeCreate.getSubject());
            jsonObject.put("operator_id", requestQrCodeCreate.getOperator_id());
            jsonObject.put("terminal_id", requestQrCodeCreate.getTerminal_id());
            if (requestQrCodeCreate.getTimeout_express() != null && !requestQrCodeCreate.equals("")) {
                jsonObject.put("timeout_express", requestQrCodeCreate.getTimeout_express() + "m");
            }
            if (requestQrCodeCreate.getSys_service_provider_id() != null && requestQrCodeCreate.getSys_service_provider_id().length() > 0) {
                jsonObject.put("extend_params", getExtend_params(requestQrCodeCreate.getSys_service_provider_id()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.setBizContent(jsonObject.toString());
        try {
            AlipayTradePrecreateResponse response = getAlipayClient().execute(request);
            ResponseQrCodeCreate responseQrCodeCreate = new ResponseQrCodeCreate();
            responseQrCodeCreate.setMain_class_name(getMainClassName());
            responseQrCodeCreate.setOut_trade_no(response.getOutTradeNo());
            responseQrCodeCreate.setIs_success(response.isSuccess());
            responseQrCodeCreate.setQr_code(response.getQrCode());
            responseQrCodeCreate.setCode(response.getCode());
            responseQrCodeCreate.setSub_code(response.getSubCode());
            responseQrCodeCreate.setMsg(response.getMsg());
            responseQrCodeCreate.setSub_desc(response.getSubMsg());
            if ("10000".equals(response.getCode())) responseQrCodeCreate.setIsCodeSuccess(true);
            return responseQrCodeCreate;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
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
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("out_trade_no", requestScanQRCodePay.getOut_trade_no());
            jsonObject.put("total_amount", requestScanQRCodePay.getTotal_amount());
            jsonObject.put("subject", requestScanQRCodePay.getSubject());
            jsonObject.put("operator_id", requestScanQRCodePay.getOperator_id());
            jsonObject.put("auth_code", requestScanQRCodePay.getAuth_code());
            jsonObject.put("terminal_id", requestScanQRCodePay.getTerminal_id());
            if (requestScanQRCodePay.getTimeout_express() != null && !requestScanQRCodePay.equals("")) {
                jsonObject.put("timeout_express", requestScanQRCodePay.getTimeout_express() + "m");
            }
            jsonObject.put("scene", "bar_code");
            if (requestScanQRCodePay.getSys_service_provider_id() != null && requestScanQRCodePay.getSys_service_provider_id().length() > 0) {
                jsonObject.put("extend_params", getExtend_params(requestScanQRCodePay.getSys_service_provider_id()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.setBizContent(jsonObject.toString());
        Log.d("支付宝扫码支付", "部分请求值：" + request.getTextParams());
        try {
            AlipayTradePayResponse response = getAlipayClient().execute(request);
            ResponseScanQRCodePay responseScanQRCodePay = new ResponseScanQRCodePay();
            responseScanQRCodePay.setMain_class_name(getMainClassName());
            responseScanQRCodePay.setOut_trade_no(response.getOutTradeNo());
            responseScanQRCodePay.setIs_success(response.isSuccess());
            responseScanQRCodePay.setBuyer_logon_id(response.getBuyerLogonId());
            responseScanQRCodePay.setBuyer_user_id(response.getBuyerUserId());
            if (response.getGmtPayment() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                responseScanQRCodePay.setGmt_payment(sdf.format(response.getGmtPayment()));
            }
            Log.d("支付宝扫码支付", "返回值：" + response.getBody());
            responseScanQRCodePay.setReceipt_amount(response.getReceiptAmount());
            responseScanQRCodePay.setStore_name(response.getStoreName());
            responseScanQRCodePay.setTotal_amount(response.getTotalAmount());
            responseScanQRCodePay.setTrade_no(response.getTradeNo());
            responseScanQRCodePay.setCode(response.getCode());
            responseScanQRCodePay.setSub_code(response.getSubCode());
            responseScanQRCodePay.setMsg(response.getMsg());
            responseScanQRCodePay.setSub_desc(response.getSubMsg());
            if ("10000".equals(response.getCode())) responseScanQRCodePay.setIsCodeSuccess(true);
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
        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("out_trade_no", requestCancelOrder.getOut_trade_no());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.setBizContent(jsonObject.toString());
        try {
            AlipayTradeCancelResponse response = getAlipayClient().execute(request);
            ResponseCancelOrder responseCancelOrder = new ResponseCancelOrder();
            responseCancelOrder.setMain_class_name(getMainClassName());
            responseCancelOrder.setOut_trade_no(response.getOutTradeNo());
            responseCancelOrder.setIs_success(response.isSuccess());
            responseCancelOrder.setTrade_no(response.getTradeNo());
            responseCancelOrder.setCode(response.getCode());
            responseCancelOrder.setSub_code(response.getSubCode());
            responseCancelOrder.setMsg(response.getMsg());
            responseCancelOrder.setSub_desc(response.getSubMsg());
            if ("10000".equals(response.getCode())) responseCancelOrder.setIsCodeSuccess(true);
            if ("refund".equals(response.getAction())) responseCancelOrder.setIs_refund(true);
            return responseCancelOrder;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseQueryOrderRetry queryOrderRetry(RequestQueryOrderRetry requestQueryOrderRetry) {
        return null;
    }

    @Override
    public ResponseQueryOrder queryOrder(RequestQueryOrder requestQueryOrder) {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject jsonObject = new JSONObject();
        try {
            if (requestQueryOrder.getOut_trade_no() != null &&requestQueryOrder.getOut_trade_no().length() > 0)
                jsonObject.put("out_trade_no", requestQueryOrder.getOut_trade_no());
            if (requestQueryOrder.getTrade_no() != null &&requestQueryOrder.getTrade_no().length() > 0)
                jsonObject.put("trade_no", requestQueryOrder.getTrade_no());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.setBizContent(jsonObject.toString());
        try {
            AlipayTradeQueryResponse response = getAlipayClient().execute(request);
            Log.e("......", ".......:" + response.getBody());
            ResponseQueryOrder responseQueryOrder = new ResponseQueryOrder();
            responseQueryOrder.setMain_class_name(getMainClassName());
            responseQueryOrder.setTrade_no(response.getTradeNo());
            responseQueryOrder.setOut_trade_no(response.getOutTradeNo());
            responseQueryOrder.setBuyer_user_id(response.getBuyerUserId());
            responseQueryOrder.setBuyer_logon_id(response.getBuyerLogonId());
            responseQueryOrder.setTrade_status(response.getTradeStatus());
            responseQueryOrder.setTotal_amount(response.getTotalAmount());
            responseQueryOrder.setReceipt_amount(response.getReceiptAmount());
            responseQueryOrder.setBuyer_pay_amount(response.getBuyerPayAmount());
            if (response.getSendPayDate() != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                responseQueryOrder.setSend_pay_date(sdf.format(response.getSendPayDate()));
            }
            responseQueryOrder.setTerminal_id(response.getTerminalId());
            responseQueryOrder.setStore_id(response.getStoreId());
            responseQueryOrder.setStore_name(response.getStoreName());
            if (response.getFundBillList() != null) {
                List<EpayTradeFundBill> epayTradeFundBills = new ArrayList<>();
                for (TradeFundBill tradeFundBill : response.getFundBillList()) {
                    epayTradeFundBills.add(new EpayTradeFundBill(tradeFundBill.getAmount(), tradeFundBill.getFundChannel()));
                }
                responseQueryOrder.setFund_bill_list(epayTradeFundBills);
            }
            responseQueryOrder.setIs_success(response.isSuccess());
            responseQueryOrder.setCode(response.getCode());
            responseQueryOrder.setSub_code(response.getSubCode());
            responseQueryOrder.setMsg(response.getMsg());
            responseQueryOrder.setSub_desc(response.getSubMsg());
            if ("10000".equals(response.getCode())) responseQueryOrder.setIsCodeSuccess(true);
            if (response.getTradeStatus() != null)
                switch (response.getTradeStatus()) {
                    case "WAIT_BUYER_PAY":
                        responseQueryOrder.setIsWaitBuyerPay(true);
                        break;
                    case "TRADE_CLOSED":
                        responseQueryOrder.setIsTradeColsed(true);
                        break;
                    case "TRADE_SUCCESS":
                        responseQueryOrder.setIsTradeSuccess(true);
                        break;
                    case "TRADE_FINISHED":
                        responseQueryOrder.setIsTradeFinished(true);
                        break;
                }
            return responseQueryOrder;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getMainClassName() {
        return getClass().getName();
    }

    private AlipayClient createAlipayClient() {
        return new DefaultAlipayClient(AlipayConfig.ALIPAY_GATEWAY, AlipayConfig.APP_ID, AlipayConfig.PRIVATE_KEY,
                "json", AlipayConfig.CHARSET);
    }

    private AlipayClient getAlipayClient() {
        if (alipayClient == null)
            alipayClient = createAlipayClient();
        return alipayClient;
    }

}
