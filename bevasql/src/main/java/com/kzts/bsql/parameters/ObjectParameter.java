package com.kzts.bsql.parameters;

class ObjectParameter extends SQLParameter {
    public ObjectParameter(String name, Object value) {
        this.name = name;
        this.value = String.valueOf(value);
    }
}
