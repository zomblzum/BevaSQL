package com.kzts.bsql.builders;

import com.kzts.bsql.parameters.Parameter;

import java.util.List;

public class QueryBuilderSQL extends SQLQueryBuilder {
    @Override
    public void setQuery(String procedure) {
        super.addValue(procedure);
    }

    @Override
    public void addParameters(List<Parameter> parameters) {
        super.addValue("");
    }

}
