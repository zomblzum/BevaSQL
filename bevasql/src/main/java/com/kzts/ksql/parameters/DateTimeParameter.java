package com.kzts.ksql.parameters;

import android.annotation.SuppressLint;

import java.util.Date;

public class DateTimeParameter extends SQLParameter {
    public DateTimeParameter(String name, Date value) {
        this.name = name;
        this.value = getDateTime(value);
    }

    private String getDateTime(Date value) {
        return "'" + getDate(value) + " " + getTime(value) + "'";
    }
    @SuppressLint("DefaultLocale")
    private String getTime(Date value) {
        return String.format("%d:%d:%d",value.getHours(),value.getMinutes(),value.getSeconds());
    }
    private String getDate(Date value) {
        return new java.sql.Date(value.getTime()).toString();
    }
}
