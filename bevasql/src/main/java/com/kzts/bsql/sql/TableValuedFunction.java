package com.kzts.bsql.sql;

import com.kzts.bsql.parameters.Parameter;

import java.util.List;

public class TableValuedFunction<V, E> extends QueryWithParameters<V,E> {
    public TableValuedFunction(SqlBridge sqlBridge, String queryText) {
        super(sqlBridge, "select * from " + queryText);
    }

    String getStringOfParameters(List<Parameter> parameters) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < parameters.size(); i++) {
            stringBuilder.append(parameters.get(i).getValue());
            if (i < parameters.size() - 1)
                stringBuilder.append(",");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
