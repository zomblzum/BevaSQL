package com.kzts.bsql.builders;

import com.kzts.bsql.parameters.Parameter;

import java.util.List;

public class FunctionBuilder extends QueryBuilder {

    @Override
    public void setProcedureName(String procedure) {
        super.addValue("select  * from " + procedure);
    }

    @Override
    public void addParameters(List<Parameter> parameters) {
        super.addValue("(");
        for (int i = 0; i < parameters.size(); i++) {
            super.addValue(parameters.get(i).getValue());
            if (i < parameters.size() - 1)
                super.addValue(",");
        }
        super.addValue(")");
    }
}
