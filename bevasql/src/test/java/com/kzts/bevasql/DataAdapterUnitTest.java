package com.kzts.bevasql;

import com.kzts.bevasql.parameters.Parameter;
import com.kzts.bevasql.parameters.ParameterFactory;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataAdapterUnitTest {
    private String n = "name";
    private ParameterFactory parameterFactory = new ParameterFactory();

    @Test
    void getString_isCorrect() {
        Parameter parameter = parameterFactory.get(n,"5");
        assertEquals(parameter.getValue(), "'5'");
        assertEquals(parameter.getName(), n);
    }


    @Test
    void getStringFromInt_isCorrect() {
        Parameter parameter = parameterFactory.get(n,5);
        assertEquals(parameter.getValue(), "5");
        assertEquals(parameter.getName(), n);
    }

    @Test
    void getStringFromDouble_isCorrect() {
        Parameter parameter = parameterFactory.get(n,5.123);
        assertEquals(parameter.getValue(), "5.123");
        assertEquals(parameter.getName(), n);
    }

    @Test
    void getStringFromFloat_isCorrect() {
        Parameter parameter = parameterFactory.get(n,5f);
        assertEquals(parameter.getValue(), "5.0");
        assertEquals(parameter.getName(), n);
    }

    @Test
    void getStringFromObject_isCorrect() {
        Parameter parameter = parameterFactory.get(n,(Object) 5);
        assertEquals(parameter.getValue(), "5");
        assertEquals(parameter.getName(), n);
    }

    @Test
    void getSqlDate_isCorrect() {
        Date now = new Date();
        Parameter parameter = parameterFactory.get(n,now);
        assertEquals(parameter.getValue(), "'"+new java.sql.Date(now.getTime()).toString() + " " +
                String.format("%d:%d:%d",now.getHours(),now.getMinutes(),now.getSeconds())+"'");
        assertEquals(parameter.getName(), n);
    }
}
