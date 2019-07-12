package com.kzts.bsql;

import com.kzts.bsql.parameters.Parameter;
import com.kzts.bsql.parameters.ParameterManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterUnitTest {
    private String name = "parameter";
    private String stringValue = "value";
    private Parameter parameter;
    private ParameterManager parameterManager = new ParameterManager();

    @Test
    void parameterFromString_isCorrect() {
        parameter = parameterManager.getParameter(name, stringValue);
        assertEquals(parameter.getName(), name);
        assertEquals(parameter.getValue(), "'" + stringValue + "'");
    }
}
