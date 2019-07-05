package com.kzts.bsql.parameters;

import java.util.Date;

public class ParameterFactory<V> {
    public Parameter get(String name, V value) {
        if (value instanceof String) {return new VarcharParameter(name, (String) value);}
        if (value instanceof Date) {return new DateTimeParameter(name, (Date) value);}
        return new ObjectParameter(name, value);
    }
}
