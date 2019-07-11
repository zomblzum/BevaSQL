package com.kzts.bsql.sql;

import com.kzts.bsql.builders.ProcedureBuilder;
import com.kzts.bsql.parameters.ParameterFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProcedureExecutor<V, E> {
    private ConnectionManager connectionManager;
    private Query query;
    private ParameterFactory<V> parameterFactory;

    ProcedureExecutor(ConnectionManager connectionManager) {
        this.parameterFactory = new ParameterFactory<>();
        this.query = new Query(new ProcedureBuilder());
        this.connectionManager = connectionManager;
    }

    ProcedureExecutor set(String procedure) {
        query.setProcedure(procedure);
        return this;
    }
    public ProcedureExecutor addParameter(String name, V value) {
        query.addParameter(parameterFactory.get(name, value));
        return this;
    }
    public ProcedureExecutor addParameter(V value) {
        query.addParameter(parameterFactory.get(null,value));
        return this;
    }

    public void execute() throws SQLException {
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

    private void connect() throws SQLException {
        connectionManager.connect();
    }
    private void close() throws SQLException {
        connectionManager.close();
    }
}
