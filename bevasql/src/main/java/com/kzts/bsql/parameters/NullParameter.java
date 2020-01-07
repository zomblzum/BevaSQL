package com.kzts.bsql.parameters;

public class NullParameter implements Parameter {
    String name;

    NullParameter(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return null;
    }
}
