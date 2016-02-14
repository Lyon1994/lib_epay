package org.lyon_yan.app.android.lib.epay.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 订单编号的操作类
 *
 * @author Lyon_Yan
 *         <br><b>time</b>: 2016年1月6日 上午10:10:19
 */
public class OrderNo {
    /**
     * 生成订单编号(后三位为随机位)
     *
     * @return
     */
    public static synchronized String getOrderNo() {
        String date = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        /**
         * total_int表示随机位的极限最大值
         */
        int total_int = 1000;
        Random random = new Random();
        /**
         * temp为随机位
         */
        String temp = "" + random.nextInt(total_int);
        /**
         * total_length为随机位的长度
         */
        int total_length = ("" + (total_int - 1)).length();
        if (temp.length() < total_length) {
            int d = total_length - temp.length();
            for (int i = 0; i < d; i++) {
                temp = "0" + temp;
            }
        }
        return date + temp;
    }

    /**
     * 获取订单超时时间
     * @param day
     * @param h
     * @param min
     * @param second
     * @return
     */
    public static String getOrderTimeExpire(int day,int h,int min,int second) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time_expire = sdf.format(System.currentTimeMillis() + (second+(min+(h+day*24)*60)*60)*1000);
        return time_expire;
    }
}
