package com.lyon_yan.module.wxpay.core;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

/**
 * 
 * @author Lyon
 * 
 */
@SuppressWarnings("deprecation")
public class NetClentProxy {
	private HttpClient httpClient = null;

	public NetClentProxy(boolean isIgoreVerify) {
		if (isIgoreVerify) {
			httpClient = HttpClientFactory.createHttpClient();
		}
	}

	public String sendPost(String uri, String postDataXML) {
		String result = null;
		HttpPost httpPost = new HttpPost(uri);
		try {
				String t = postDataXML.replace("<sub_mch_id></sub_mch_id>", "");
			// 得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
			StringEntity postEntity = new StringEntity(t, "UTF-8");
			httpPost.addHeader("Content-Type", "text/xml");
			httpPost.setEntity(postEntity);
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			httpPost.abort();
		}
		return result;
	}

	public static boolean checkSignValid(String xml) {
		try {
			return Signature.checkIsSignValidFromResponseString(xml);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
