package com.kzts.bsql.sql;

import com.kzts.bsql.parameters.ParameterFactory;

import java.sql.ResultSet;
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
    public List<E> get(Supplier<E> supplier) throws Exception {
        connectionManager.connect();

        //ToDo вынести в разные методы
        Entity entity = new Entity(supplier);
        ResultSet resultSet = connectionManager.get(procedureQuery, entity);
        ResultSetReader resultSetReader = new ResultSetReader(resultSet);
        List<E> data = resultSetReader.toEntityList(entity);

        connectionManager.close();
        return data;
    }
}
