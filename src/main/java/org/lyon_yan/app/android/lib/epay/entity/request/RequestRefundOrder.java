package org.lyon_yan.app.android.lib.epay.entity.request;

/**
 * Created by yanni on 2016/2/14.
 */
public class RequestRefundOrder {
    /**
     * 交易号
     */
    private String trade_no;
    /**
     * 退款金额
     */
    private String refund_amount;
    /**
     * 商户退款请求号
     */
    private String out_request_no;
    /**
     * 退款原因
     */
    private String refund_reason;
    /**
     * 商户的门店编号
     */
    private String store_id;
    /**
     * 商户的终端编号
     */
    private String terminal_id;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getOut_request_no() {
        return out_request_no;
    }

    public void setOut_request_no(String out_request_no) {
        this.out_request_no = out_request_no;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public RequestRefundOrder() {
    }

    public RequestRefundOrder(String trade_no, String refund_amount) {
        this.trade_no = trade_no;
        this.refund_amount = refund_amount;
    }
}
