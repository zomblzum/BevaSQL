package com.kzts.bsql;

import com.kzts.bsql.parameters.Parameter;
import com.kzts.bsql.parameters.ParameterFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterUnitTest {
    private String name = "parameter";
    private String stringValue = "value";
    private Parameter parameter;
    private ParameterFactory parameterFactory = new ParameterFactory();

    @Test
    void parameterFromString_isCorrect() {
        parameter = parameterFactory.getParameter(name, stringValue);
        assertEquals(parameter.getName(), name);
        assertEquals(parameter.getValue(), "'" + stringValue + "'");
    }
}
