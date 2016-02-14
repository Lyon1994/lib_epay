package com.lyon_yan.module.wxpay.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * 
 * @author Lyon
 *
 */
public class Out_trade_no {
	private static String out_trade_no = null;

	public static String getOut_trade_no() {
		return out_trade_no;
	}

	public static void autoSetOut_trade_no() {
		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
		Date date = new Date();
		String key = format.format(date);

		Random r = new Random();
		key = key + r.nextInt();
		key = key.substring(0, 15);
		setOut_trade_no(key);
	}

	public static void setOut_trade_no(String out_trade_no) {
		Out_trade_no.out_trade_no = out_trade_no;
	}

}
