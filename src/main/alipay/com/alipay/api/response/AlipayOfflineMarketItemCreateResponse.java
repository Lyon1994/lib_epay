package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.offline.market.item.create response.
 * 
 * @author auto create
 * @since 1.0, 2015-12-18 10:53:34
 */
public class AlipayOfflineMarketItemCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 8772758293248761496L;

	/** 
	 * 支付宝商品id
	 */
	@ApiField("item_id")
	private String itemId;

	/** 
	 * 传入的请求id
	 */
	@ApiField("request_id")
	private String requestId;

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemId( ) {
		return this.itemId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestId( ) {
		return this.requestId;
	}

}
