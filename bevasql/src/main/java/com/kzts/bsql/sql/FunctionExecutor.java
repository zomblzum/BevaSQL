package com.kzts.bsql.sql;

import com.kzts.bsql.builders.FunctionBuilderSQL;
import com.kzts.bsql.parameters.ParameterFactory;
import com.kzts.bsql.parameters.ParameterManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FunctionExecutor<V, E> {
    private ConnectionManager connectionManager;
    private Query query;
    private ParameterFactory<V> parameterManager;

    FunctionExecutor(ConnectionManager connectionManager) {
        this.parameterManager = new ParameterManager<>();
        this.query = new Query(new FunctionBuilderSQL());
        this.connectionManager = connectionManager;
    }

    FunctionExecutor set(String procedure) {
        query.setProcedure(procedure);
        return this;
    }
    public FunctionExecutor addParameter(V value) {
        query.addParameter(parameterManager.getParameter(null,value));
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

    private void connect() throws SQLException, ClassNotFoundException {
        connectionManager.connect();
    }
    private void close() throws SQLException {
        connectionManager.close();
    }
}
