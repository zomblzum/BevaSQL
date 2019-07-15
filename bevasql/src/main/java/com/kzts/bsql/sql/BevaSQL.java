package com.kzts.bsql.sql;

public class BevaSQL {
    private ConnectionManager connectionManager;

    public static BevaSQL fromValues(String server, String database, String user, String password) {
        ConnectionToken token = new ConnectionToken(server, database, user, password);
        return new BevaSQL(token);
    }

    public BevaSQL(ConnectionToken token) {
        this.connectionManager = ConnectionManager.getFromToken(token);
    }

    /**
     * Хранимая процедура sql
     * @return Объект для заполнения и выполнения процедуры
     */
    public ProcedureExecutor storedProcedure(String procedure) {
        return new ProcedureExecutor(connectionManager).set(procedure);
    }

    /**
     * Функция sql
     * @return Объект для управления функцией
     */
    public FunctionExecutor tableFunction(String function) {
        return new FunctionExecutor(connectionManager).set(function);
    }

    /**
     * Обычный запрос
     * @return Объект для управления функцией
     */
    public QueryExecutor query(String query) {
        return new QueryExecutor(connectionManager).set(query);
    }
}
