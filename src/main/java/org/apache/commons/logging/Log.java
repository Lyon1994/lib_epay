package org.apache.commons.logging;

/**
 * Created by yanni on 2016/2/14.
 */
public class Log {
    private String k=null;
    protected Log(String klog){
        k=klog;
    }

    public void error(String s) {
        android.util.Log.e(k,s);
    }
}
