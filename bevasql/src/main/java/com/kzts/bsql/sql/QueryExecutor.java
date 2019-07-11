package com.kzts.bsql.sql;

import com.kzts.bsql.builders.ProcedureBuilderSQL;
import com.kzts.bsql.parameters.ParameterFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QueryExecutor<V, E> {
    private ConnectionManager connectionManager;
    private Query query;
    private ParameterFactory<V> parameterFactory;

    QueryExecutor(ConnectionManager connectionManager) {
        this.parameterFactory = new ParameterFactory<>();
        this.query = new Query(new ProcedureBuilderSQL());
        this.connectionManager = connectionManager;
    }

    QueryExecutor set(String procedure) {
        query.setProcedure(procedure);
        return this;
    }

    public void execute() throws SQLException, ClassNotFoundException {
        connect();
        connectionManager.execute(query);
        close();
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
