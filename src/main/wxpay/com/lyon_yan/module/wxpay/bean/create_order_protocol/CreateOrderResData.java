package com.lyon_yan.module.wxpay.bean.create_order_protocol;

import java.io.Serializable;

/**
 * 被扫支付提交Post数据给到API之后，API会返回XML格式的数据，这个类用来装这些数据
 * @author Lyon
 */
@SuppressWarnings("serial")
public class CreateOrderResData  implements Serializable{
    /**
	 * 
	 */
    private String return_code = "";
    private String return_msg = "";
    private String sub_mch_id ="";
    private String appid = "";
    private String mch_id = "";
    private String nonce_str = "";
    private String sign = "";
    private String result_code = "";
    private String err_code = "";
    private String err_code_des = "";
    private String device_info = "";

    private String trade_type = "";
    private String prepay_id="";
    private String code_url ="";
    
    public String getAppid() {
        return appid;
    }

    public String getCode_url() {
		return code_url;
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

    public String getMch_id() {
        return mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public String getPrepay_id() {
		return prepay_id;
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

    public String getTrade_type() {
        return trade_type;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setCode_url(String code_url) {
		this.code_url = code_url;
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

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }


    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
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

	public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }


}
