package com.kzts.bsql.builders;

import com.kzts.bsql.sql.ProcedureQuery;

public interface Builder {
    public String build(ProcedureQuery procedureQuery);
}
