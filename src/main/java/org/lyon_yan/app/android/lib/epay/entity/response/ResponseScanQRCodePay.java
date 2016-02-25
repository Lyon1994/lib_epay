package org.lyon_yan.app.android.lib.epay.entity.response;

import org.lyon_yan.app.android.lib.epay.EpayResponseCode;

/**
 * LyonYan<br>
 * Created by yanni on 2016/2/14.<br>
 */
public class ResponseScanQRCodePay  extends EpayResponseCode {
    /**
     * 支付方式交易流水号
     */
    private String trade_no;
    /**
     * 商家交易流水号
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
     * 交易金额
     */
    private String total_amount;
    /**
     * 实收金额
     */
    private String receipt_amount;
    /**
     * 付款时间
     */
    private String gmt_payment;
    /**
     * 门店名称
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

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getReceipt_amount() {
        return receipt_amount;
    }

    public void setReceipt_amount(String receipt_amount) {
        this.receipt_amount = receipt_amount;
    }

    public String getGmt_payment() {
        return gmt_payment;
    }

    public void setGmt_payment(String gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

}
