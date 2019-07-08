package com.kzts.bsql.builders;

import com.kzts.bsql.parameters.Parameter;
import com.kzts.bsql.sql.Query;

import java.util.List;

public abstract class QueryBuilder implements Builder {
    private StringBuilder queryText;

    public String build(Query procedureQuery) {
        queryText = new StringBuilder();
        setProcedureName(procedureQuery.getQuery());
        addParameters(procedureQuery.getParameters());
        return queryText.toString();
    }

    @Override
    public void setProcedureName(String procedure) {

    }

    @Override
    public void addParameters(List<Parameter> parameters) {

    }

    void addValue(String value) {
        queryText.append(value);
    }
}
