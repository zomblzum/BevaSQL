package com.kzts.bsql.sql;

import com.kzts.bsql.parameters.Parameter;
import com.kzts.bsql.parameters.ParameterBuilder;
import com.kzts.bsql.parameters.ParameterFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class QueryWithParameters<V,E> extends Query<E> {
    private List<Parameter> parameters;
    private ParameterBuilder<V> parameterBuilder;

    public QueryWithParameters(SqlBridge sqlBridge, String queryText) {
        super(sqlBridge, queryText);
        this.parameters = new ArrayList<>();
        this.parameterBuilder = new ParameterFactory<>();
    }

    public QueryWithParameters addParameter(V value) {
        return addParameter(null, value);
    }

    public QueryWithParameters addParameter(String name, V value) {
        this.parameters.add(parameterBuilder.getParameter(name, value));
        return this;
    }

    @Override
    public String getQueryText() {
        return super.getQueryText() + getStringOfParameters(parameters);
    }

    abstract String getStringOfParameters(List<Parameter> parameters);
}
