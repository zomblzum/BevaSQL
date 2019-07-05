package com.kzts.ksql.sql;

import com.kzts.ksql.builders.ProcedureBuilder;
import com.kzts.ksql.parameters.VarcharParameter;
import com.kzts.ksql.sql.ProcedureQuery;

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
