package org.lyon_yan.app.android.lib.epay.entity.response;

import org.lyon_yan.app.android.lib.epay.EpayResponseCode;

/**
 * Created by yanni on 2016/2/14.
 */
public class ResponseCancelOrder extends EpayResponseCode {
    /**
     *商户订单号
     */
    private String out_trade_no;
    /**
     *支付方式交易号流水
     */
    private String trade_no;

    public boolean is_refund() {
        return is_refund;
    }

    public void setIs_refund(boolean is_refund) {
        this.is_refund = is_refund;
    }

    /**
     *是否有退款
     */
    private boolean is_refund;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

}
