package com.kzts.bevasql.builders;

import com.kzts.bevasql.sql.ProcedureQuery;

public interface Builder {
    public String build(ProcedureQuery procedureQuery);
}
