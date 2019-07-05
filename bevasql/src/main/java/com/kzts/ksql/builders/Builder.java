package com.kzts.ksql.builders;

import com.kzts.ksql.sql.ProcedureQuery;

public interface Builder {
    public String build(ProcedureQuery procedureQuery);
}
