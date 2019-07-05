package com.kzts.ksql.sql;

public class BevaSQL {
    private ConnectionManager connectionManager;

    public BevaSQL(ConnectionToken token) {
        this.connectionManager = ConnectionManager.getFromToken(token);
    }

    public ProcedureExecutor storedProcedure() {
        return new ProcedureExecutor(connectionManager);
    }
}
