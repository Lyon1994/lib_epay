package org.apache.commons.logging;

/**
 * Created by yanni on 2016/2/14.
 */
public class LogFactory {
    public static Log getLog(String s) {
        return new Log(s);
    }
}
