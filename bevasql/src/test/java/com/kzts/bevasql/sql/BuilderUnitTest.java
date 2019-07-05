package com.kzts.bevasql.sql;

import com.kzts.bevasql.builders.ProcedureBuilder;
import com.kzts.bevasql.parameters.VarcharParameter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuilderUnitTest {
    @Test
    void build_isCorrect() {
        ProcedureQuery procedureQuery = new ProcedureQuery();
        procedureQuery.setProcedure("get_view");
        procedureQuery.addParameter(new VarcharParameter("name1","value"));
        procedureQuery.addParameter(new VarcharParameter("name2","123"));

        String actual = "exec get_view @name1=value,@name2=123";

        assertEquals(new ProcedureBuilder().build(procedureQuery),actual);
    }
}