package com.kzts.bevasql.parameters;

class ObjectParameter extends SQLParameter {
    public ObjectParameter(String name, Object value) {
        this.name = name;
        this.value = String.valueOf(value);
    }
}
