package com.kzts.bsql.builders;

public class QueryBuilder extends SQLQueryBuilder {
    @Override
    public void setQuery(String procedure) {
        super.addValue(procedure);
    }

}
