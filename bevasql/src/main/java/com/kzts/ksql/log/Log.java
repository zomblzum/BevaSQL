package com.kzts.ksql.log;

public class Log {
    private static Logger LOG = new AndroidLog();

    public static void d(String message) {
        LOG.d(message);
    }

    public static void e(String message) {
        LOG.e(message);
    }

    public static void e(String message, Throwable t) {
        System.out.println("ERROR: " + message);
    }

    public static void i(String message) {
        LOG.i(message);
    }

    public static void v(String message) {
        LOG.v(message);
    }
}
