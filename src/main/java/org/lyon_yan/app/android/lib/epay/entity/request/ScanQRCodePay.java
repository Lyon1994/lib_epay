package org.lyon_yan.app.android.lib.epay.entity.request;

/**
 * LyonYan<br>
 * Created by yanni on 2016/2/14.<br>
 * 注意：<br>
 * 若机具商接入，terminal_id(机具终端编号)必填，store_id(商户门店编号)和seller_id(卖家支付宝用户ID)为选填内容。<br>
 * 若系统商接入，store_id（商户的门店编号）必填，terminal_id(机具终端编号)和seller_id(卖家支付宝用户ID)为选填内容。<br>
 * 如果传入的store_id（商户的门店编号）与门店录入的store_id不匹配，则不能核销该门店发布的优惠活动。<br>
 */
public class ScanQRCodePay {
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 支付场景
     */
    private String scene;
    /**
     * 卖家用户ID
     */
    private String seller_id;
    /**
     * 支付授权码
     */
    private String auth_code;
    /**
     * 订单总金额
     */
    private String total_amount;
    /**
     * 订单标题
     */
    private String subject;
    /**
     * 订单描述
     */
    private String body;
    /**
     * 商品明细列表
     */
    private String goods_detail;
    /**
     * 商户操作员编号
     */
    private String operator_id;
    /**
     * 商户门店编号
     */
    private String store_id;
    /**
     * 机具终端编号
     */
    private String terminal_id;
    /**
     * 扩展参数
     */
    private String extend_params;
    /**
     * 支付超时时间表达式
     */
    private String timeout_express;
    /**
     * 分账信息
     */
    private String royalty_info;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

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

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getExtend_params() {
        return extend_params;
    }

    public void setExtend_params(String extend_params) {
        this.extend_params = extend_params;
    }

    public String getTimeout_express() {
        return timeout_express;
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }

    public String getRoyalty_info() {
        return royalty_info;
    }

    public void setRoyalty_info(String royalty_info) {
        this.royalty_info = royalty_info;
    }
}
