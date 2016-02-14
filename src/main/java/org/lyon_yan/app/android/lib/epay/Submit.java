package org.lyon_yan.app.android.lib.epay;

import org.lyon_yan.app.android.lib.epay.entity.request.CancelOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.CancelOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.QrCodeCreate;
import org.lyon_yan.app.android.lib.epay.entity.request.QueryOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.QueryOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.RefundOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.RefundOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.ScanQRCodePay;

/**
 * 用于提交测试
 * @author Lyon_Yan
 * <br><b>time</b>: 2016年1月6日 上午10:19:30
 */
public abstract class Submit {
	/**
	 * 支付二维码创建
	 * @author Lyon_Yan
	 * <br><b>time</b>: 2016年1月6日 上午10:26:40
	 * @return
	 */
	public abstract Object qrCodeCreate(QrCodeCreate qrCodeCreate);

	/**
	 * 扫码接口
	 * @return
	 */
	public abstract String scanQRCodePay(ScanQRCodePay scanQRCodePay);

	/**
	 * 退款接口
	 * @return
	 */
	public abstract String refundOrder(RefundOrder refundOrder);

	/**
	 * 退款请求接口
	 * @return
	 */
	public abstract String refundOrderRetry(RefundOrderRetry refundOrderRetry);

	/**
	 * 取消订单请求接口
	 * @return
	 */
	public abstract String cancelOrderRetry(CancelOrderRetry cancelOrderRetry);

	/**
	 * 取消订单接口
	 * @return
	 */
	public abstract String cancelOrder(CancelOrder cancelOrder);

	/**
	 * 查询订单请求接口
	 * @return
	 */
	public abstract String queryOrderRetry(QueryOrderRetry queryOrderRetry);

	/**
	 * 查询订单接口
	 * @return
	 */
	public abstract String queryOrder(QueryOrder queryOrder);
	
}
