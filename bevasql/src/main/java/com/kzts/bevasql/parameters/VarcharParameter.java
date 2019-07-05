package com.kzts.bevasql.parameters;

public class VarcharParameter extends SQLParameter {
    public VarcharParameter(String name, String value) {
        this.name = name;
        this.value = "'" + value + "'";
    }
}
