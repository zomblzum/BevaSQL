package com.kzts.bsql.parameters;

import java.util.Date;

public class ParameterFactory<V> implements ParameterBuilder<V> {

    @Override
    public Parameter getParameter(String name, V value) {
        if(value != null) {
            ParameterBuilder<V> parameterBuilder = getParameterFactory(value.getClass());
            return parameterBuilder.getParameter(name, value);
        } else {
            return new NullParameter(name);
        }

    }

    private ParameterBuilder<V> getParameterFactory(Class<?> parameterClass) {
        if (parameterClass == String.class) {
            return new VarcharParameterBuilder<>();
        }
        if (parameterClass == Date.class) {
            return new DateTimeParameterBuilder<>();
        }

        return new ObjectParameterBuilder<>();
    }
}
