package com.kzts.ksql.builders;

import com.kzts.ksql.ProcedureQuery;

public interface Builder {
    public String build(ProcedureQuery procedureQuery);
}
