package com.kzts.ksql.sql;

import com.kzts.ksql.builders.Builder;
import com.kzts.ksql.builders.ProcedureBuilder;
import com.kzts.ksql.parameters.Parameter;

import java.util.ArrayList;
import java.util.List;

public class ProcedureQuery {
    private String procedure;
    private List<Parameter> parameters = new ArrayList<Parameter>();
    private Builder builder;

    ProcedureQuery() {
        this.builder = new ProcedureBuilder();
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
