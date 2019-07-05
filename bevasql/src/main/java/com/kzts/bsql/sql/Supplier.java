package com.kzts.bsql.sql;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}