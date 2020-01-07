package com.kzts.bsql.sql;

import com.kzts.bsql.parameters.Parameter;
import com.kzts.bsql.parameters.ParameterFactory;
import com.kzts.bsql.parameters.ParameterManager;

import java.util.ArrayList;
import java.util.List;

public abstract class QueryWithParameters<V,E> extends Query<E> {
    private List<Parameter> parameters;
    private ParameterFactory<V> parameterFactory;

    public QueryWithParameters(SqlBridge sqlBridge, String queryText) {
        super(sqlBridge, queryText);
        this.parameters = new ArrayList<>();
        this.parameterFactory = new ParameterManager<>();
    }

    public QueryWithParameters addParameter(V value) {
        return addParameter(null, value);
    }

    public QueryWithParameters addParameter(String name, V value) {
        this.parameters.add(parameterFactory.getParameter(name, value));
        return this;
    }

    @Override
    public String getQueryText() {
        return super.getQueryText() + getStringOfParameters(parameters);
    }

    abstract String getStringOfParameters(List<Parameter> parameters);
}
