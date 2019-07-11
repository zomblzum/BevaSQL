package com.kzts.bsql.sql;

import com.kzts.bsql.builders.ProcedureBuilderSQL;
import com.kzts.bsql.parameters.ParameterFactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuilderUnitTest {
    @Test
    void build_isCorrect() {
        Query procedureQuery = new Query(new ProcedureBuilderSQL());
        procedureQuery.setProcedure("get_view");
        procedureQuery.addParameter(new ParameterFactory().get("name1","value"));
        procedureQuery.addParameter(new ParameterFactory().get("name2",123));

        String actual = "exec get_view @name1='value',@name2=123";

        assertEquals(new ProcedureBuilderSQL().build(procedureQuery),actual);
    }
}
