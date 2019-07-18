package com.kzts.bsql.builders;

import com.kzts.bsql.parameters.Parameter;
import com.kzts.bsql.sql.Query;

import java.util.List;

public abstract class SQLQueryBuilder implements Builder {
    private StringBuilder queryText;

    public String build(Query procedureQuery) {
        queryText = new StringBuilder();
        setQuery(procedureQuery.getQuery());
        addParameters(procedureQuery.getParameters());
        return queryText.toString();
    }

    @Override
    public abstract void setQuery(String procedure);

    @Override
    public abstract void addParameters(List<Parameter> parameters);

    void addValue(String value) {
        queryText.append(value);
    }
}
