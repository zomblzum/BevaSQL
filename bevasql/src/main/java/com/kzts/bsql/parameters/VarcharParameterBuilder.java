package com.kzts.bsql.parameters;

public class VarcharParameterBuilder<V> implements ParameterBuilder<V> {
    @Override
    public Parameter getParameter(String name, V value) {
        return new SQLParameter(name, "'" + value + "'");
    }
}
