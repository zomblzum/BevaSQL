package com.kzts.bsql.parameters;

public class SQLParameter implements Parameter {
    private String name;
    private String value;

    public SQLParameter(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
