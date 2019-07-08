package com.kzts.bsql.sql;

public class BevaSQL {
    private ConnectionManager connectionManager;

    public BevaSQL fromValues(String server, String database, String user, String password) {
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
    public ProcedureExecutor storedProcedure() {
        return new ProcedureExecutor(connectionManager);
    }

    /**
     * Функция sql
     * @return Объект для управления функцией
     */
    public FunctionExecutor tableFunction() {
        return new FunctionExecutor(connectionManager);
    }
}
