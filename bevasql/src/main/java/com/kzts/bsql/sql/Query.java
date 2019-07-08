package com.kzts.bsql.sql;

import com.kzts.bsql.builders.Builder;
import com.kzts.bsql.parameters.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Query {
    private String procedure;
    private List<Parameter> parameters = new ArrayList<>();
    private Builder builder;

    Query(Builder builder) {
        this.builder = builder;
    }

    String build() {
        return builder.build(this);
    }

    public String getQuery() {
        return procedure;
    }
    public List<Parameter> getParameters() {
        return parameters;
    }

    void setProcedure(String procedure) {
        this.procedure = procedure;
    }
    void addParameter(Parameter parameter) {
        this.parameters.add(parameter);
    }
}
