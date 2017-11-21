package com.chm.shop.app.constants;

/**
 * @author chen-hongmin
 * @since 2017/11/8 16:28
 */
public class SystemConstants {

    //换行
    public static final String lineSeparator;

    static {
        String ls = System.getProperty("line.feed"); //$NON-NLS-1$
        if (ls == null) {
            ls = "\n"; //$NON-NLS-1$
        }
        lineSeparator = ls;
    }
}
