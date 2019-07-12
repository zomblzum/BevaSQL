package com.kzts.bsql.parameters;

public class ObjectParameterFactory<V> implements ParameterFactory<V> {
    @Override
    public Parameter getParameter(String name, V value) {
        return new SQLParameter(name, String.valueOf((Object) value));
    }
}
