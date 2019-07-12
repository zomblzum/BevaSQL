package com.kzts.bsql.parameters;

public class VarcharParameterFactory<V> implements ParameterFactory<V> {
    @Override
    public Parameter getParameter(String name, V value) {
        return new SQLParameter(name, "'" + value + "'");
    }
}
