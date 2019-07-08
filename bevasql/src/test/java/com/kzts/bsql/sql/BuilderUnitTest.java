package com.kzts.bsql.sql;

import com.kzts.bsql.builders.ProcedureBuilder;
import com.kzts.bsql.parameters.VarcharParameter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuilderUnitTest {
    @Test
    void build_isCorrect() {
        Query procedureQuery = new Query(new ProcedureBuilder());
        procedureQuery.setProcedure("get_view");
        procedureQuery.addParameter(new VarcharParameter("name1","value"));
        procedureQuery.addParameter(new VarcharParameter("name2","123"));

        String actual = "exec get_view @name1=value,@name2=123";

        assertEquals(new ProcedureBuilder().build(procedureQuery),actual);
    }
}
