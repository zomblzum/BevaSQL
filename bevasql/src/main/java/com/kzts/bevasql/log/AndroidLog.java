package com.kzts.bevasql.log;

public class AndroidLog implements Logger {
    private static int LEVEL = android.util.Log.WARN;
    private static final String TAG = "BevaSQL";

    @Override
    public void d(String message) {
        if (LEVEL <= android.util.Log.DEBUG)
            android.util.Log.d(TAG, message);
    }

    @Override
    public void e(String message) {
        if (LEVEL <= android.util.Log.ERROR)
            android.util.Log.e(TAG, message);
    }

    @Override
    public void e(String message, Throwable t) {
        if (LEVEL <= android.util.Log.ERROR)
            android.util.Log.e(TAG, message, t);
    }

    @Override
    public void i(String message) {
        if (LEVEL <= android.util.Log.INFO)
            android.util.Log.i(TAG, message);
    }

    @Override
    public void v(String message) {
        if (LEVEL <= android.util.Log.VERBOSE)
            android.util.Log.v(TAG, message);
    }
}