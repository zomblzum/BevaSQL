package com.kzts.bsql;

import com.kzts.bsql.parameters.Parameter;
import com.kzts.bsql.parameters.ParameterFactory;

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
        Parameter parameter = parameterFactory.get(n,(Integer) 5);
        assertEquals(parameter.getValue(), "5");
        assertEquals(parameter.getName(), n);
    }
}
