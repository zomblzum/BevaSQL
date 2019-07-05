package com.kzts.ksql.sql;

import com.kzts.ksql.util.Supplier;
import com.kzts.ksql.parameters.ParameterFactory;
import com.kzts.ksql.util.ResultSetReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ProcedureExecutor<V, E> {
    private ConnectionManager connectionManager;
    private ProcedureQuery procedureQuery;
    private ParameterFactory parameterFactory;

    ProcedureExecutor(ConnectionManager connectionManager) {
        this.parameterFactory = new ParameterFactory();
        this.procedureQuery = new ProcedureQuery();
        this.connectionManager = connectionManager;
    }

    public ProcedureExecutor setProcedure(String procedure) {
        procedureQuery.setProcedure(procedure);
        return this;
    }
    public ProcedureExecutor addParameter(String name, V value) {
        procedureQuery.addParameter(parameterFactory.get(name, value));
        return this;
    }

    public void execute() {
        connectionManager.connect();
        connectionManager.execute(procedureQuery);
        connectionManager.close();
    }
    public List<E> get(Supplier<E> entity) throws SQLException, IllegalAccessException {
        connectionManager.connect();
        ResultSetReader resultSetReader = new ResultSetReader(entity);
        ResultSet resultSet = connectionManager.get(procedureQuery, entity);
        List<E> data = resultSetReader.toEntityList(resultSet);
        connectionManager.close();
        return data;
    }
}
