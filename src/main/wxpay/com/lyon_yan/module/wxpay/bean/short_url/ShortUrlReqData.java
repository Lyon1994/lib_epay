package com.lyon_yan.module.wxpay.bean.short_url;

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
public class ShortUrlReqData implements Serializable{
    /**
	 * 
	 */
	//每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
	private String sub_mch_id = "";
    private String long_url  = "";
    private String nonce_str = "";
    private String sign = "";

    public ShortUrlReqData(String long_url){

        //--------------------------------------------------------------------
        //以下是测试数据，请商户按照自己的实际情况填写具体的值进去
        //--------------------------------------------------------------------

        //微信分配的公众号ID（开通公众号之后可以获取到）
        setAppid(Configure.getAppid());

        //微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
        setMch_id(Configure.getMchid());
		setSub_mch_id(Configure.getSubMchid());
        setLong_url(long_url);

        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

        //根据API给的签名规则进行签名
        String sign = Signature.getSign(toMap());
        setSign(sign);//把签名数据设置到Sign这个属性中

    }

    public String getAppid() {
        return appid;
    }

    public String getLong_url() {
		return long_url;
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

    public void setLong_url(String long_url) {
		this.long_url = long_url;
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
				if (obj != null&&!obj.toString().equals("")) {
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
