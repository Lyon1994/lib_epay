package org.lyon_yan.app.android.lib.epay.entity.response;

import org.lyon_yan.app.android.lib.epay.EpayResponseCode;

import java.util.List;

/**
 * 订单查询
 * Created by yanni on 2016/2/14.
 */
public class ResponseQueryOrder extends EpayResponseCode {
    /**
     * 交易创建，等待买家付款
     */
    private boolean isWaitBuyerPay;
    /**
     * 交易支付成功
     */
    private boolean isTradeSuccess;
    /**
     * 未付款交易超时关闭，或支付完成后全额退款
     */
    private boolean isTradeColsed;
    /**
     * 交易结束，不可退款
     */
    private boolean isTradeFinished;

    public boolean isWaitBuyerPay() {
        return isWaitBuyerPay;
    }

    public void setIsWaitBuyerPay(boolean isWaitBuyerPay) {
        this.isWaitBuyerPay = isWaitBuyerPay;
    }

    public boolean isTradeSuccess() {
        return isTradeSuccess;
    }

    public void setIsTradeSuccess(boolean isTradeSuccess) {
        this.isTradeSuccess = isTradeSuccess;
    }

    public boolean isTradeColsed() {
        return isTradeColsed;
    }

    public void setIsTradeColsed(boolean isTradeColsed) {
        this.isTradeColsed = isTradeColsed;
    }

    public boolean isTradeFinished() {
        return isTradeFinished;
    }

    public void setIsTradeFinished(boolean isTradeFinished) {
        this.isTradeFinished = isTradeFinished;
    }

    /**
     * 支付方式交易流水号
     */
    private String trade_no;
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 买家支付方式用户号
     */
    private String buyer_user_id;
    /**
     * 买家支付方式账号
     */
    private String buyer_logon_id;
    /**
     * 交易状态
     */
    private String trade_status;
    /**
     * 订单金额
     */
    private String total_amount;
    /**
     * 实收金额
     */
    private String receipt_amount;
    /**
     * 用户在交易中支付的金额
     */
    private String buyer_pay_amount;
    /**
     * 本次交易打款到卖家账户的时 间，格式为 YYYY-MM-dd HH:mm:ss。
     */
    private String send_pay_date;
    /**
     * 商户机具终端编号
     */
    private String terminal_id;
    /**
     * 商户门店编号
     */
    private String store_id;
    /**
     * 门店名称
     */
    private String store_name;
    /**
     * 本次交易使用的资金明细信息列表，包含多个渠道信息子节点
     */
    private List<EpayTradeFundBill> fund_bill_list;

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

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
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

    public String getBuyer_pay_amount() {
        return buyer_pay_amount;
    }

    public void setBuyer_pay_amount(String buyer_pay_amount) {
        this.buyer_pay_amount = buyer_pay_amount;
    }

    public String getSend_pay_date() {
        return send_pay_date;
    }

    public void setSend_pay_date(String send_pay_date) {
        this.send_pay_date = send_pay_date;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public List<EpayTradeFundBill> getFund_bill_list() {
        return fund_bill_list;
    }

    public void setFund_bill_list(List<EpayTradeFundBill> fund_bill_list) {
        this.fund_bill_list = fund_bill_list;
    }

    public String getTrade_no() {

        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }
}
