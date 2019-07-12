package com.kzts.bsql.parameters;

public interface ParameterFactory<V> {
    Parameter getParameter(String name, V value);
}
