package com.kzts.ksql.log;

public interface Logger {
    void d(String message);

    void e(String message);

    void e(String message, Throwable t);

    void i(String message);

    void v(String message);
}
