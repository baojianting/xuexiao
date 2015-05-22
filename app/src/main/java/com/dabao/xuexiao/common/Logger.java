package com.dabao.xuexiao.common;

import android.util.Log;

/**
 * Created by baojianting on 2015/5/20.
 */
public final class Logger {

    private static Logger mLogger;
    private static final boolean DEBUG = true;

    private Logger() {

    }

    public static Logger getInstance() {
        synchronized (Logger.class) {
            if (null == mLogger) {
                mLogger = new Logger();
            }
            return mLogger;
        }
    }

    public void info(String tag, String info) {
        if (null != mLogger) {
            Log.i(tag, info);
        }
    }

    public void warrning(String tag, String info) {
        if (null != mLogger) {
            Log.w(tag, info);
        }
    }

    public void error(String tag, String info) {
        if (null != mLogger) {
            Log.e(tag, info);
        }
    }

    public void debug(String tag, String info) {
        if (null != mLogger) {
            Log.d(tag, info);
        }
    }

    public void verbose(String tag, String info) {
        if (null != mLogger) {
            Log.v(tag, info);
        }
    }
}
