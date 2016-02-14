package com.lyon_yan.module.wxpay.bean.refund_query_protocol;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lyon_yan.module.wxpay.config.Configure;
import com.lyon_yan.module.wxpay.core.RandomStringGenerator;
import com.lyon_yan.module.wxpay.core.Signature;

/**
 * @author Lyon
 */
@SuppressWarnings("serial")
public class RefundQueryReqData implements Serializable {
	/**
	 * 
	 */
	// 每个字段具体的意思请查看API文档
	private String appid = "";
	private String mch_id = "";
	private String sub_mch_id = "";
	private String device_info = "";
	private String nonce_str = "";
	private String sign = "";
	private String transaction_id = "";
	private String out_trade_no = "";

	private String out_refund_no = "";

	private String refund_id = "";

	public RefundQueryReqData(String transactionID, String outTradeNo,
			String deviceInfo, String outRefundNo, String refundID,
			String sub_mch_id) {
		setAppid(Configure.getAppid());
		setMch_id(Configure.getMchid());
		setSub_mch_id(Configure.getSubMchid());
		setTransaction_id(transactionID);
		setOut_trade_no(outTradeNo);
		setDevice_info(deviceInfo);
		setOut_refund_no(outRefundNo);
		setRefund_id(refundID);
		setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		String sign = Signature.getSign(toMap());
		setSign(sign);

	}

	public String getAppid() {
		return appid;
	}

	public String getDevice_info() {
		return device_info;
	}

	public String getMch_id() {
		return mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public String getSign() {
		return sign;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if (obj != null && !obj.toString().equals("")) {
					map.put(field.getName(), obj);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
