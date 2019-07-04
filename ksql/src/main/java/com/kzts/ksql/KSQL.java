package com.kzts.ksql;

public class KSQL {
    private ConnectionManager connectionManager;

    public KSQL(ConnectionToken token) {
        this.connectionManager = ConnectionManager.getFromToken(token);
    }

    public ProcedureExecutor storedProcedure() {
        return new ProcedureExecutor(connectionManager);
    }
}
