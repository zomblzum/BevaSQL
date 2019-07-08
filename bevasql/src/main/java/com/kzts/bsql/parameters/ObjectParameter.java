package com.kzts.bsql.parameters;

class ObjectParameter extends SQLParameter {
    public ObjectParameter(String name, Object value) {
        this.name = name;
        this.value = getObjectValue(value);
    }

    private String getObjectValue(Object value) {
        return String.valueOf(value);
    }
}
