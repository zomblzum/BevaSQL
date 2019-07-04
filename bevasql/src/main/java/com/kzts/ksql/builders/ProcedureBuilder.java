package com.kzts.ksql.builders;

import com.kzts.ksql.ProcedureQuery;
import com.kzts.ksql.parameters.Parameter;

import java.util.List;

public class ProcedureBuilder implements Builder {
    private StringBuilder queryText;

    @Override
    public String build(ProcedureQuery procedureQuery) {
        queryText = new StringBuilder();
        setProcedureName(procedureQuery.getQuery());
        addParameters(procedureQuery.getParameters());
        return queryText.toString();
    }

    private void setProcedureName(String procedure) {
        addValue("exec " + procedure + " ");
    }

    private void addParameters(List<Parameter> parameters) {
        for (int i = 0; i < parameters.size(); i++) {
            addValue(getModifiedName(parameters.get(i).getName()));
            addValue("=");
            addValue(parameters.get(i).getValue());
            if (i < parameters.size() - 1)
                addValue(",");
        }
    }

    private void addValue(String value) {
        queryText.append(value);
    }

    private String getModifiedName(String name) {
        if (!name.contains("@"))
            return "@" + name;
        else
            return name;
    }
}
