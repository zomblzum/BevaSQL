package com.kzts.bsql.parameters;

import java.sql.Timestamp;
import java.util.Date;

public class DateTimeParameterFactory<V> implements ParameterFactory<V> {
    @Override
    public Parameter getParameter(String name, V value) {
        return new SQLParameter(name, getTimeStamp((Date) value));
    }

    private String getTimeStamp(Date value) {
        return "'" + new Timestamp(value.getTime()) + "'";
    }
}
