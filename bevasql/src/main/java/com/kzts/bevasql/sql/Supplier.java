package com.kzts.bevasql.sql;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}