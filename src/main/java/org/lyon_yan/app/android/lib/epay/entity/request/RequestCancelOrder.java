package org.lyon_yan.app.android.lib.epay.entity.request;

/**
 * 取消订单接口<br>
 * 应用场景实例：调用支付宝支付接口时未返回明确的返回结果（如系统错误或网络异常），可使用本接口将交易进行撤销。<br>
 * <p/>
 * 如果用户支付失败，支付宝会将此订单关闭；如果用户支付成功，支付宝会将支付的资金退还给用户。<br>
 * <p/>
 * 撤销只支持24小时内的交易，超过24小时要退款可以调用申请退款接口，如果需要明确订单状态可以调用查询订单接口。<br>
 * Created by yanni on 2016/2/14.
 */
public class RequestCancelOrder {
    private String out_trade_no;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
}
