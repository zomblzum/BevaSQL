package com.kzts.bsql.sql;

import com.kzts.bsql.builders.FunctionBuilder;
import com.kzts.bsql.parameters.ParameterFactory;

import java.sql.ResultSet;
import java.util.List;

public class FunctionExecutor<V, E> {
    private ConnectionManager connectionManager;
    private Query query;
    private ParameterFactory<V> parameterFactory;

    FunctionExecutor(ConnectionManager connectionManager) {
        this.parameterFactory = new ParameterFactory<>();
        this.query = new Query(new FunctionBuilder());
        this.connectionManager = connectionManager;
    }

    FunctionExecutor set(String procedure) {
        query.setProcedure(procedure);
        return this;
    }
    public FunctionExecutor addParameter(V value) {
        query.addParameter(parameterFactory.get(null,value));
        return this;
    }

    public List<E> get(Supplier<E> supplier) throws Exception {
        connect();

        //ToDo вынести в разные методы
        Entity<? extends E> entity = new Entity<>(supplier);
        ResultSet resultSet = connectionManager.get(query, entity);
        ResultSetReader<E> resultSetReader = new ResultSetReader<>(resultSet);
        List<E> data = resultSetReader.toEntityList(entity);

        close();
        return data;
    }

    private void connect() {
        connectionManager.connect();
    }
    private void close() {
        connectionManager.close();
    }
}
