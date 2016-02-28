package org.lyon_yan.app.android.lib.epay.entity.request;

/**
 * 二维码支付
 * Created by yanni on 2016/2/14.
 */
public class RequestQrCodeCreate {
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 卖家用户ID
     */
    private String seller_id;
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
    /**
     * 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID。
     */
    private String sys_service_provider_id;

    public String getSys_service_provider_id() {
        return sys_service_provider_id;
    }

    public void setSys_service_provider_id(String sys_service_provider_id) {
        this.sys_service_provider_id = sys_service_provider_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
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
