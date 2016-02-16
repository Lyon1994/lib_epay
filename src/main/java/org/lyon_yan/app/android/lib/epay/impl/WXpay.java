package org.lyon_yan.app.android.lib.epay.impl;

import org.lyon_yan.app.android.lib.epay.EpayRequestSubmit;
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

/**
 * 微信线下支付
 * Created by yanni on 2016/2/14.
 */
public class WXpay extends EpayRequestSubmit {
    @Override
    public ResponseQrCodeCreate qrCodeCreate(RequestQrCodeCreate requestQrCodeCreate) {
        return null;
    }

    @Override
    public ResponseScanQRCodePay scanQRCodePay(RequestScanQRCodePay requestScanQRCodePay) {
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

    @Override
    public String getMainClassName() {
        return null;
    }
}
