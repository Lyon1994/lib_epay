package org.lyon_yan.app.android.lib.epay.entity.response;

import org.lyon_yan.app.android.lib.epay.EpayResponseCode;

/**
 * Created by yanni on 2016/2/14.
 */
public class ResponseRefundOrder extends EpayResponseCode {
    /**
     * 交易号
     */
    private String trade_no;
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 买家用户号
     */
    private String buyer_user_id;
    /**
     * 买家账号
     */
    private String buyer_logon_id;
    /**
     * 本次退款请求是否发生资金变动	(Y/N)
     */
    private String fund_change;
    /**
     * 总退款金额
     */
    private String refund_fee;
    /**
     * 实际退款金额
     */
    private String send_back_fee;
    /**
     * 退款时间
     */
    private String gmt_refund_pay;
    /**
     * 门名名称
     */
    private String store_name;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getBuyer_user_id() {
        return buyer_user_id;
    }

    public void setBuyer_user_id(String buyer_user_id) {
        this.buyer_user_id = buyer_user_id;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getFund_change() {
        return fund_change;
    }

    public void setFund_change(String fund_change) {
        this.fund_change = fund_change;
    }

    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getSend_back_fee() {
        return send_back_fee;
    }

    public void setSend_back_fee(String send_back_fee) {
        this.send_back_fee = send_back_fee;
    }

    public String getGmt_refund_pay() {
        return gmt_refund_pay;
    }

    public void setGmt_refund_pay(String gmt_refund_pay) {
        this.gmt_refund_pay = gmt_refund_pay;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
}
