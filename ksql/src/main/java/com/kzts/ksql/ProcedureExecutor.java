package com.kzts.ksql;

import com.kzts.ksql.parameters.ParameterFactory;
import com.kzts.ksql.util.ResultSetReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProcedureExecutor<V> {
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
    public List<Map<String, String>> get() throws SQLException {
        connectionManager.connect();
        ResultSet resultSet = connectionManager.get(procedureQuery);
        List<Map<String, String>> data = new ResultSetReader().toList(resultSet);
        connectionManager.close();
        return data;
    }
}
