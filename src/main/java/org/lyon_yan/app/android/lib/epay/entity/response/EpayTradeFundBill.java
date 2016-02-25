package org.lyon_yan.app.android.lib.epay.entity.response;

/**
 * Created by yanni on 2016/2/16.
 */
public class EpayTradeFundBill {

    /**
     * 该支付工具类型所使用的金额
     */
    private String amount;

    /**
     * 支付所使用的渠道
     */
    private String fundChannel;

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFundChannel() {
        return this.fundChannel;
    }

    public void setFundChannel(String fundChannel) {
        this.fundChannel = fundChannel;
    }

    public EpayTradeFundBill(String amount, String fundChannel) {
        this.amount = amount;
        this.fundChannel = fundChannel;
    }
}
