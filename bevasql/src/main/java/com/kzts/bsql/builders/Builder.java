package com.kzts.bsql.builders;

import com.kzts.bsql.parameters.Parameter;
import com.kzts.bsql.sql.Query;

import java.util.List;

public interface Builder {
    String build(Query procedureQuery);

    void setQuery(String procedure);
    void addParameters(List<Parameter> parameters);
}
