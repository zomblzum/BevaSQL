package com.kzts.ksql;

import com.kzts.ksql.parameters.Parameter;
import com.kzts.ksql.parameters.SQLParameter;
import com.kzts.ksql.parameters.VarcharParameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterUnitTest {
    private String name = "parameter";
    private String stringValue = "value";

    @Test
    void parameterFromString_isCorrect() {
        Parameter parameter = new VarcharParameter(name, stringValue) ;
        assertEquals(parameter.getName(), name);
        assertEquals(parameter.getValue(), stringValue);
    }
}
