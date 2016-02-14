package org.lyon_yan.app.android.lib.epay.impl;

import org.lyon_yan.app.android.lib.epay.Submit;
import org.lyon_yan.app.android.lib.epay.entity.request.CancelOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.CancelOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.QrCodeCreate;
import org.lyon_yan.app.android.lib.epay.entity.request.QueryOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.QueryOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.RefundOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.RefundOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.ScanQRCodePay;

/**
 * 微信线下支付
 * Created by yanni on 2016/2/14.
 */
public class WXpay extends Submit {
    @Override
    public Object qrCodeCreate(QrCodeCreate qrCodeCreate) {
        return null;
    }

    @Override
    public String scanQRCodePay(ScanQRCodePay scanQRCodePay) {
        return null;
    }

    @Override
    public String refundOrder(RefundOrder refundOrder) {
        return null;
    }

    @Override
    public String refundOrderRetry(RefundOrderRetry refundOrderRetry) {
        return null;
    }

    @Override
    public String cancelOrderRetry(CancelOrderRetry cancelOrderRetry) {
        return null;
    }

    @Override
    public String cancelOrder(CancelOrder cancelOrder) {
        return null;
    }

    @Override
    public String queryOrderRetry(QueryOrderRetry queryOrderRetry) {
        return null;
    }

    @Override
    public String queryOrder(QueryOrder queryOrder) {
        return null;
    }
}
