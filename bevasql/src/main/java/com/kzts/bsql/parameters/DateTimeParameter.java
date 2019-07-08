package com.kzts.bsql.parameters;

import java.sql.Timestamp;
import java.util.Date;

public class DateTimeParameter extends SQLParameter {
    public DateTimeParameter(String name, Date value) {
        this.name = name;
        this.value = getTimeStamp(value);
    }

    private String getTimeStamp(Date value) {
        return "'" + new Timestamp(value.getTime()) + "'";
    }
}
