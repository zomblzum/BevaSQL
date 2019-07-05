package com.kzts.ksql.util;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}