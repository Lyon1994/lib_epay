package org.lyon_yan.app.android.lib.epay.entity.request;

/**
 * 订单查询
 * Created by yanni on 2016/2/14.
 */
public class RequestQueryOrder  {
    /**
     *支付方式订单流水号
     */
    private String trade_no;
    /**
     *商户订单号
     */
    private String out_trade_no;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
}
