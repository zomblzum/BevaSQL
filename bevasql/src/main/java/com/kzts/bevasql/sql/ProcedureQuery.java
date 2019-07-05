package com.kzts.bevasql.sql;

import com.kzts.bevasql.builders.Builder;
import com.kzts.bevasql.builders.ProcedureBuilder;
import com.kzts.bevasql.parameters.Parameter;

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
