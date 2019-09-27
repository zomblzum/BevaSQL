package com.kzts.bsql.parameters;

import java.util.Date;

public class ParameterManager<V> implements ParameterFactory<V> {

    @Override
    public Parameter getParameter(String name, V value) {
        if(value != null) {
            ParameterFactory<V> parameterFactory = getParameterFactory(value.getClass());
            return parameterFactory.getParameter(name, value);
        } else {
            return new NullParameter(name);
        }

    }

    private ParameterFactory<V> getParameterFactory(Class<?> parameterClass) {
        if (parameterClass == String.class) {
            return new VarcharParameterFactory<>();
        }
        if (parameterClass == Date.class) {
            return new DateTimeParameterFactory<>();
        }

        return new ObjectParameterFactory<>();
    }
}
