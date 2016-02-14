package com.lyon_yan.module.wxpay.bean.downloadbill_protocol;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lyon_yan.module.wxpay.config.Configure;
import com.lyon_yan.module.wxpay.core.RandomStringGenerator;
import com.lyon_yan.module.wxpay.core.Signature;

/**
 * 
 * @author Lyon
 * 
 */
@SuppressWarnings("serial")
public class DownloadBillReqData implements Serializable {
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
	private String bill_date = "";
	private String bill_type = "";

	/**
	 * 
	 * @param deviceInfo
	 * @param billDate
	 * @param billType
	 */
	public DownloadBillReqData(String deviceInfo, String billDate,
			String billType) {
		setAppid(Configure.getAppid());

		setMch_id(Configure.getMchid());
		setSub_mch_id(Configure.getSubMchid());
		setDevice_info(deviceInfo);

		setBill_date(billDate);

		setBill_type(billType);

		setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		String sign = Signature.getSign(toMap());
		setSign(sign);

	}

	public String getAppid() {
		return appid;
	}

	public String getBill_date() {
		return bill_date;
	}

	public String getBill_type() {
		return bill_type;
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

	public String getSign() {
		return sign;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
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

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
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
