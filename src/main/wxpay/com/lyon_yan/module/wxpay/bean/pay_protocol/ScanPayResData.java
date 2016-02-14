package com.lyon_yan.module.wxpay.bean.pay_protocol;

import java.io.Serializable;

/**
 * 被扫支付提交Post数据给到API之后，API会返回XML格式的数据，这个类用来装这些数据
 * @author Lyon
 */
@SuppressWarnings("serial")
public class ScanPayResData  implements Serializable{
    /**
	 * 
	 */
    private String return_code = "";
    private String return_msg = "";

    private String appid = "";
    private String mch_id = "";
    private String sub_mch_id ="";
    private String nonce_str = "";
    private String sign = "";
    private String result_code = "";
    private String err_code = "";
    private String err_code_des = "";

    private String device_info = "";

    private String openid = "";
    private String is_subscribe = "";
    private String trade_type = "";
    private String bank_type = "";
    private String total_fee = "";
    private String coupon_fee = "";
    private String fee_type = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private String attach = "";
    private String time_end = "";
    private String cash_fee_type="";
    private String cash_fee="";

    public String getAppid() {
        return appid;
    }

    public String getAttach() {
        return attach;
    }

    public String getBank_type() {
        return bank_type;
    }

    public String getCash_fee() {
		return cash_fee;
	}

    public String getCash_fee_type() {
		return cash_fee_type;
	}

    public String getCoupon_fee() {
        return coupon_fee;
    }

    public String getDevice_info() {
        return device_info;
    }

    public String getErr_code() {
        return err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public String getFee_type() {
        return fee_type;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public String getMch_id() {
        return mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public String getOpenid() {
        return openid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public String getResult_code() {
        return result_code;
    }

    public String getReturn_code() {
        return return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public String getSign() {
        return sign;
    }

    public String getSub_mch_id() {
		return sub_mch_id;
	}

    public String getTime_end() {
        return time_end;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

    public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

    public void setCoupon_fee(String coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

	public void setSign(String sign) {
        this.sign = sign;
    }

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

	public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

	public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

	public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

}
