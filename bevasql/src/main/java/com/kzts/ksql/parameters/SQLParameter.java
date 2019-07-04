package com.kzts.ksql.parameters;

public abstract class SQLParameter implements Parameter {
    protected String name;
    protected String value;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
