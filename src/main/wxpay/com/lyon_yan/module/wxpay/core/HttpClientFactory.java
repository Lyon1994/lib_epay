package com.lyon_yan.module.wxpay.core;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

@SuppressWarnings("deprecation")
public class HttpClientFactory {

	/**
	 * 忽略验证https
	 */
	public static void igoreVerify() throws Exception {

		ignoreVerifyHttpsTrustManager();
		ignoreVerifyHttpsHostName();
	}

	/**
	 * 忽略验证https
	 */
	public static void ignoreVerifyHttpsHostName() {
		HostnameVerifier hv = new HostnameVerifier() {

			@Override
			public boolean verify(String hostname, SSLSession session) {
				// TODO Auto-generated method stub
				System.out.println("Warning: URL Host: " + hostname + " vs. "
						+ session.getPeerHost());
				return true;
			}
		};

		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}

	/**
	 * 忽略验证https
	 */
	public static void ignoreVerifyHttpsTrustManager() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
	

	/**
	 * 忽略验证https
	 */
	public static HttpClient createHttpClient() { 
        HttpParams params = new BasicHttpParams(); 
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1); 
        HttpProtocolParams.setContentCharset(params, 
                HTTP.DEFAULT_CONTENT_CHARSET); 
        HttpProtocolParams.setUseExpectContinue(params, true);
        SchemeRegistry schReg = new SchemeRegistry(); 
        schReg.register(new Scheme("http", PlainSocketFactory 
                .getSocketFactory(), 80)); 
        schReg.register(new Scheme("https", 
                SSLSocketFactory.getSocketFactory(), 443)); 
        ClientConnectionManager conMgr = new ThreadSafeClientConnManager( 
                params, schReg);
        return new DefaultHttpClient(conMgr, params); 
    }
	
}
