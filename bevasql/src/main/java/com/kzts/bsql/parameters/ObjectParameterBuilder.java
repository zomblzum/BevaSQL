package com.kzts.bsql.parameters;

public class ObjectParameterBuilder<V> implements ParameterBuilder<V> {
    @Override
    public Parameter getParameter(String name, V value) {
        return new SQLParameter(name, String.valueOf((Object) value));
    }
}
