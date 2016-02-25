package org.lyon_yan.app.android.lib.epay.entity.response;

import org.lyon_yan.app.android.lib.epay.EpayResponseCode;

/**
 * Created by yanni on 2016/2/14.
 */
public class ResponseQrCodeCreate extends EpayResponseCode {
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 二维码码串
     */
    private String qr_code;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

}
