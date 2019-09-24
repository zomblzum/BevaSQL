package com.kzts.bsql.sql;

import com.kzts.bsql.parameters.Parameter;

import java.util.List;

public class StoredProcedure<V, E> extends QueryWithParameters<V, E> {
    public StoredProcedure(SqlBridge sqlBridge, String queryText) {
        super(sqlBridge, "exec " + queryText);
    }

    String getStringOfParameters(List<Parameter> parameters) {
        StringBuilder stringOfParameters = new StringBuilder(" ");
        for (int i = 0; i < parameters.size(); i++) {
            if(parameters.get(i).getName() != null) {
                stringOfParameters.append(getModifiedName(parameters.get(i).getName()));
                stringOfParameters.append("=");
            }
            stringOfParameters.append(parameters.get(i).getValue());
            if (i < parameters.size() - 1)
                stringOfParameters.append(",");
        }
        return stringOfParameters.toString();
    }

    private String getModifiedName(String name) {
        if (!name.contains("@"))
            return "@" + name;
        else
            return name;
    }
}
