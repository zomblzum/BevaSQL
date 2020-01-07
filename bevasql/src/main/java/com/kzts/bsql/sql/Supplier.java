package com.kzts.bsql.sql;

@FunctionalInterface
public interface Supplier<E> {
    E get();
}