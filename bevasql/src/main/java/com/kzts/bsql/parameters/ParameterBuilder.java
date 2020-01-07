package com.kzts.bsql.parameters;

public interface ParameterBuilder<V> {
    Parameter getParameter(String name, V value);
}
