package com.kzts.ksql.sql;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}