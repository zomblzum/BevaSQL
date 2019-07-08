package com.kzts.bsql.parameters;

public class VarcharParameter extends SQLParameter {
    public VarcharParameter(String name, String value) {
        this.name = name;
        this.value = getVarcharValue(value);
    }

    private String getVarcharValue(String value) {
        return "'" + value + "'";
    }
}
