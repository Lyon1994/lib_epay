package com.lyon_yan.module.wxpay.bean;

import java.util.Map;

import com.lyon_yan.module.wxpay.bean.close_order.CloseOrderResData;
import com.lyon_yan.module.wxpay.bean.create_order_protocol.CreateOrderResData;
import com.lyon_yan.module.wxpay.bean.downloadbill_protocol.DownloadBillResData;
import com.lyon_yan.module.wxpay.bean.pay_protocol.ScanPayResData;
import com.lyon_yan.module.wxpay.bean.pay_query_protocol.PayQueryResData;
import com.lyon_yan.module.wxpay.bean.refund_protocol.RefundResData;
import com.lyon_yan.module.wxpay.bean.refund_query_protocol.RefundQueryResData;
import com.lyon_yan.module.wxpay.bean.reverse_protocol.ReverseResData;
import com.lyon_yan.module.wxpay.bean.short_url.ShortUrlResData;
import com.lyon_yan.module.wxpay.core.XMLFactory;

/**
 * 数据实体工厂
 * @author Lyon
 *
 */
public class ResponseBeanFactory {
	public static CreateOrderResData getCreateOrderResData(String xml) {
		Map<String, Object> map = XMLFactory.getMapFromXML(xml);
		CreateOrderResData createOrderResData = new CreateOrderResData();
		createOrderResData.setReturn_code(getValue(map, "return_code"));
		createOrderResData.setReturn_msg(getValue(map, "return_msg"));
		createOrderResData.setAppid(getValue(map, "appid"));
		createOrderResData.setMch_id(getValue(map, "mch_id"));
		createOrderResData.setSub_mch_id("sub_mch_id");
		createOrderResData.setDevice_info(getValue(map, "device_info"));
		createOrderResData.setNonce_str(getValue(map, "nonce_str"));
		createOrderResData.setSign(getValue(map, "sign"));
		createOrderResData.setResult_code(getValue(map, "result_code"));
		createOrderResData.setErr_code(getValue(map, "err_code"));
		createOrderResData.setErr_code_des(getValue(map, "err_code_des"));
		createOrderResData.setTrade_type(getValue(map, "trade_type"));
		createOrderResData.setPrepay_id(getValue(map, "prepay_id"));
		createOrderResData.setCode_url(getValue(map, "code_url"));
		return createOrderResData;
	}

	public static DownloadBillResData getDownloadBillResData(String xml) {
		Map<String, Object> map = XMLFactory.getMapFromXML(xml);
		DownloadBillResData downloadBillResData = new DownloadBillResData();
		downloadBillResData.setReturn_code(getValue(map, "return_code"));
		downloadBillResData.setReturn_msg(getValue(map, "return_msg"));
		return downloadBillResData;
	}

	public static ScanPayResData getScanPayResData(String xml) {
		Map<String, Object> map = XMLFactory.getMapFromXML(xml);
		ScanPayResData scanPayResData = new ScanPayResData();
		scanPayResData.setReturn_code(getValue(map, "return_code"));
		scanPayResData.setReturn_msg(getValue(map, "return_msg"));
		scanPayResData.setAppid(getValue(map, "appid"));
		scanPayResData.setMch_id(getValue(map, "mch_id"));
		scanPayResData.setSub_mch_id("sub_mch_id");
		scanPayResData.setDevice_info(getValue(map, "device_info"));
		scanPayResData.setNonce_str(getValue(map, "nonce_str"));
		scanPayResData.setSign(getValue(map, "sign"));
		scanPayResData.setResult_code(getValue(map, "result_code"));
		scanPayResData.setErr_code(getValue(map, "err_code"));
		scanPayResData.setErr_code_des(getValue(map, "err_code_des"));

		scanPayResData.setOpenid(getValue(map, "openid"));
		scanPayResData.setIs_subscribe(getValue(map, "is_subscribe"));
		scanPayResData.setTrade_type(getValue(map, "trade_type"));
		scanPayResData.setBank_type(getValue(map, "bank_type"));
		scanPayResData.setFee_type(getValue(map, "fee_type"));
		scanPayResData.setTotal_fee(getValue(map, "total_fee"));
		scanPayResData.setCash_fee_type(getValue(map, "cash_fee_type"));
		scanPayResData.setCash_fee(getValue(map, "cash_fee"));
		scanPayResData.setCoupon_fee(getValue(map, "coupon_fee"));
		scanPayResData.setTransaction_id(getValue(map, "transaction_id"));
		scanPayResData.setOut_trade_no(getValue(map, "out_trade_no"));
		scanPayResData.setAttach(getValue(map, "attach"));
		scanPayResData.setTime_end(getValue(map, "time_end"));
		return scanPayResData;
	}

	public static PayQueryResData getOrderQueryResData(String xml) {
		Map<String, Object> map = XMLFactory.getMapFromXML(xml);
		PayQueryResData orderQueryResData = new PayQueryResData();
		orderQueryResData.setReturn_code(getValue(map, "return_code"));
		orderQueryResData.setReturn_msg(getValue(map, "return_msg"));
		orderQueryResData.setAppid(getValue(map, "appid"));
		orderQueryResData.setMch_id(getValue(map, "mch_id"));
		orderQueryResData.setSub_mch_id("sub_mch_id");
		orderQueryResData.setDevice_info(getValue(map, "device_info"));
		orderQueryResData.setNonce_str(getValue(map, "nonce_str"));
		orderQueryResData.setSign(getValue(map, "sign"));
		orderQueryResData.setResult_code(getValue(map, "result_code"));
		orderQueryResData.setErr_code(getValue(map, "err_code"));
		orderQueryResData.setErr_code_des(getValue(map, "err_code_des"));
		orderQueryResData.setOpenid(getValue(map, "openid"));
		orderQueryResData.setIs_subscribe(getValue(map, "is_subscribe"));
		orderQueryResData.setTrade_type(getValue(map, "trade_type"));
		orderQueryResData.setBank_type(getValue(map, "bank_type"));
		orderQueryResData.setFee_type(getValue(map, "fee_type"));
		orderQueryResData.setTotal_fee(getValue(map, "total_fee"));
		orderQueryResData.setCash_fee_type(getValue(map, "cash_fee_type"));
		orderQueryResData.setCash_fee(getValue(map, "cash_fee"));
		orderQueryResData.setCoupon_fee(getValue(map, "coupon_fee"));
		orderQueryResData.setTransaction_id(getValue(map, "transaction_id"));
		orderQueryResData.setOut_trade_no(getValue(map, "out_trade_no"));
		orderQueryResData.setAttach(getValue(map, "attach"));
		orderQueryResData.setTime_end(getValue(map, "time_end"));
		orderQueryResData.setTrade_type(getValue(map, "trade_type"));
		orderQueryResData.setCoupon_count(getValue(map, "coupon_count"));
		orderQueryResData.setTrade_state(getValue(map, "trade_state"));
		orderQueryResData
				.setTrade_state_desc(getValue(map, "trade_state_desc"));
		return orderQueryResData;
	}

	public static RefundResData getRefundResData(String xml) {
		Map<String, Object> map = XMLFactory.getMapFromXML(xml);
		RefundResData refundResData = new RefundResData();
		refundResData.setReturn_code(getValue(map, "return_code"));
		refundResData.setReturn_msg(getValue(map, "return_msg"));
		refundResData.setAppid(getValue(map, "appid"));
		refundResData.setMch_id(getValue(map, "mch_id"));
		refundResData.setSub_mch_id("sub_mch_id");
		refundResData.setDevice_info(getValue(map, "device_info"));
		refundResData.setNonce_str(getValue(map, "nonce_str"));
		refundResData.setSign(getValue(map, "sign"));
		refundResData.setResult_code(getValue(map, "result_code"));
		refundResData.setErr_code(getValue(map, "err_code"));
		refundResData.setErr_code_des(getValue(map, "err_code_des"));

		refundResData.setTransaction_id(getValue(map, "transaction_id"));
		refundResData.setOut_trade_no(getValue(map, "out_trade_no"));
		refundResData.setOut_refund_no(getValue(map, "out_refund_no"));
		refundResData.setRefund_id(getValue(map, "refund_id"));
		refundResData.setRefund_channel(getValue(map, "refund_channel"));
		refundResData.setRefund_fee(getValue(map, "refund_fee"));
		refundResData.setTotal_fee(getValue(map, "total_fee"));
		refundResData.setFee_type(getValue(map, "fee_type"));
		refundResData.setCash_fee(getValue(map, "cash_fee"));
		refundResData.setCash_refund_fee(getValue(map, "cash_refund_fee"));
		refundResData.setCoupon_refund_fee(getValue(map, "coupon_refund_fee"));
		refundResData.setCoupon_refund_count(getValue(map,
				"coupon_refund_count"));
		refundResData.setCoupon_refund_id(getValue(map, "coupon_refund_id"));
		return refundResData;
	}

	public static RefundQueryResData getRefundQueryResData(String xml) {
		Map<String, Object> map = XMLFactory.getMapFromXML(xml);
		RefundQueryResData refundQueryResData = new RefundQueryResData();
		refundQueryResData.setReturn_code(getValue(map, "return_code"));
		refundQueryResData.setReturn_msg(getValue(map, "return_msg"));
		refundQueryResData.setAppid(getValue(map, "appid"));
		refundQueryResData.setMch_id(getValue(map, "mch_id"));
		refundQueryResData.setSub_mch_id("sub_mch_id");
		refundQueryResData.setDevice_info(getValue(map, "device_info"));
		refundQueryResData.setNonce_str(getValue(map, "nonce_str"));
		refundQueryResData.setSign(getValue(map, "sign"));
		refundQueryResData.setResult_code(getValue(map, "result_code"));
		refundQueryResData.setErr_code(getValue(map, "err_code"));
		refundQueryResData.setErr_code_des(getValue(map, "err_code_des"));

		refundQueryResData.setTransaction_id(getValue(map, "transaction_id"));
		refundQueryResData.setOut_trade_no(getValue(map, "out_trade_no"));
		refundQueryResData.setTotal_fee(getValue(map, "total_fee"));
		refundQueryResData.setFee_type(getValue(map, "fee_type"));
		refundQueryResData.setCash_fee(getValue(map, "cash_fee"));
		refundQueryResData.setCash_fee_type(getValue(map, "cash_fee_type"));
		refundQueryResData.setOut_refund_no(getValue(map, "out_refund_no"));
		refundQueryResData.setRefund_id(getValue(map, "refund_id"));
		refundQueryResData.setRefund_channel(getValue(map, "refund_channel"));
		refundQueryResData.setRefund_fee(getValue(map, "refund_fee"));
		refundQueryResData.setCoupon_refund_fee(getValue(map, "coupon_refund_fee"));
		return refundQueryResData;
	}
	
	public static ReverseResData getReverseResData(String xml) {
		return null;
	}
	
	public static CloseOrderResData getCloseOrderResData(String xml){
		Map<String, Object> map = XMLFactory.getMapFromXML(xml);
		CloseOrderResData closeOrderResData = new CloseOrderResData();
		closeOrderResData.setReturn_code(getValue(map, "return_code"));
		closeOrderResData.setReturn_msg(getValue(map, "return_msg"));
		closeOrderResData.setAppid(getValue(map, "appid"));
		closeOrderResData.setMch_id(getValue(map, "mch_id"));
		closeOrderResData.setSub_mch_id("sub_mch_id");
		closeOrderResData.setNonce_str(getValue(map, "nonce_str"));
		closeOrderResData.setSign(getValue(map, "sign"));
		closeOrderResData.setResult_code(getValue(map, "result_code"));
		closeOrderResData.setErr_code(getValue(map, "err_code"));
		closeOrderResData.setErr_code_des(getValue(map, "err_code_des"));
		return closeOrderResData;
	}
	

	public static ShortUrlResData getShortUrlResData(String xml){
		Map<String, Object> map = XMLFactory.getMapFromXML(xml);
		ShortUrlResData shortUrlResData = new ShortUrlResData();
		shortUrlResData.setReturn_code(getValue(map, "return_code"));
		shortUrlResData.setReturn_msg(getValue(map, "return_msg"));
		shortUrlResData.setAppid(getValue(map, "appid"));
		shortUrlResData.setMch_id(getValue(map, "mch_id"));
		shortUrlResData.setSub_mch_id("sub_mch_id");
		shortUrlResData.setNonce_str(getValue(map, "nonce_str"));
		shortUrlResData.setSign(getValue(map, "sign"));
		shortUrlResData.setResult_code(getValue(map, "result_code"));
		shortUrlResData.setErr_code(getValue(map, "err_code"));
		shortUrlResData.setErr_code_des(getValue(map, "err_code_des"));
		shortUrlResData.setErr_code_des(getValue(map, "short_url"));
		return shortUrlResData;
	}

	private static String getValue(Map<String, Object> map, String key) {
		if (map.containsKey(key)) {
			return map.get(key).toString();
		}
		return "";
	}

}
