package org.lyon_yan.app.android.lib.epay;

import org.lyon_yan.app.android.lib.epay.entity.request.RequestCancelOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestCancelOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestQrCodeCreate;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestQueryOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestQueryOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestRefundOrder;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestRefundOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.request.RequestScanQRCodePay;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseCancelOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseCancelOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQrCodeCreate;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQueryOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseQueryOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseRefundOrder;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseRefundOrderRetry;
import org.lyon_yan.app.android.lib.epay.entity.response.ResponseScanQRCodePay;

/**
 * 用于提交测试
 *
 * @author Lyon_Yan
 *         <br><b>time</b>: 2016年1月6日 上午10:19:30
 */
public abstract class EpayRequestSubmit {
    /**
     * 根据类名获取支付方式类别
     * @param className
     * @return
     */
    public static EpayRequestSubmit loadByClassName(String className) {
        try {
            return EpayRequestSubmit.class.cast(Class.forName(className).newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 支付二维码创建
     *
     * @return
     * @author Lyon_Yan
     * <br><b>time</b>: 2016年1月6日 上午10:26:40
     */
    public abstract ResponseQrCodeCreate qrCodeCreate(RequestQrCodeCreate requestQrCodeCreate);

    /**
     * 扫码接口
     *
     * @return
     */
    public abstract ResponseScanQRCodePay scanQRCodePay(RequestScanQRCodePay requestScanQRCodePay);

    /**
     * 退款接口
     *
     * @return
     */
    public abstract ResponseRefundOrder refundOrder(RequestRefundOrder requestRefundOrder);

    /**
     * 退款请求接口
     *
     * @return
     */
    public abstract ResponseRefundOrderRetry refundOrderRetry(RequestRefundOrderRetry requestRefundOrderRetry);

    /**
     * 取消订单请求接口
     *
     * @return
     */
    public abstract ResponseCancelOrderRetry cancelOrderRetry(RequestCancelOrderRetry requestCancelOrderRetry);

    /**
     * 取消订单接口
     *
     * @return
     */
    public abstract ResponseCancelOrder cancelOrder(RequestCancelOrder requestCancelOrder);

    /**
     * 查询订单请求接口
     *
     * @return
     */
    public abstract ResponseQueryOrderRetry queryOrderRetry(RequestQueryOrderRetry requestQueryOrderRetry);

    /**
     * 查询订单接口
     *
     * @return
     */
    public abstract ResponseQueryOrder queryOrder(RequestQueryOrder requestQueryOrder);
    /**
     * 获取支付方式主类
     *
     * @return
     */
    public abstract String getMainClassName();

}
