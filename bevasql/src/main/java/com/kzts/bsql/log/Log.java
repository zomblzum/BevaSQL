package com.kzts.bsql.log;

public class Log {
    private static int LEVEL = android.util.Log.WARN;
    private static final String TAG = "BevaSQL";

    /**
     * Debug log
     * @param message Сообщение
     */
    public static void d(String message) {
        if (LEVEL <= android.util.Log.DEBUG)
            android.util.Log.d(TAG, message);
    }
    /**
     * Error log
     * @param message Сообщение
     */
    public static void e(String message) {
        if (LEVEL <= android.util.Log.ERROR)
            android.util.Log.e(TAG, message);
    }
    /**
     * Error log
     * @param message Сообщение
     * @param t Throwable
     */
    public static void e(String message, Throwable t) {
        if (LEVEL <= android.util.Log.ERROR)
            android.util.Log.e(TAG, message, t);
    }
    /**
     * Info log
     * @param message Сообщение
     */
    public static void i(String message) {
        if (LEVEL <= android.util.Log.INFO)
            android.util.Log.i(TAG, message);
    }
    /**
     * Verbose log
     * @param message Сообщение
     */
    public static void v(String message) {
        if (LEVEL <= android.util.Log.VERBOSE)
            android.util.Log.v(TAG, message);
    }
}
