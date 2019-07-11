package com.kzts.bsql.builders;

import com.kzts.bsql.parameters.Parameter;

import java.util.List;

public class ProcedureBuilderSQL extends SQLQueryBuilder {

    @Override
    public void setQuery(String procedure) {
        super.addValue("exec " + procedure + " ");
    }

    @Override
    public void addParameters(List<Parameter> parameters) {
        for (int i = 0; i < parameters.size(); i++) {
            if(parameters.get(i).getName() != null) {
                super.addValue(getModifiedName(parameters.get(i).getName()));
                super.addValue("=");
            }
            super.addValue(parameters.get(i).getValue());
            if (i < parameters.size() - 1)
                super.addValue(",");
        }
    }

    private String getModifiedName(String name) {
        if (!name.contains("@"))
            return "@" + name;
        else
            return name;
    }
}
