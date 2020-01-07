package com.kzts.bsql.sql;

public class BevaSQL {
    private SqlBridge sqlBridge;

    public static BevaSQL fromValues(String server, String database, String user, String password) {
        ConnectionToken token = new ConnectionToken(server, database, user, password);
        return new BevaSQL(token);
    }

    public BevaSQL(ConnectionToken token) {
        this.sqlBridge = SqlBridge.getFromToken(token);
    }

    /**
     * Хранимая процедура sql
     * @return Объект для заполнения и выполнения процедуры
     */
    public Query query(String queryText) {
        return new Query(sqlBridge, queryText);
    }

    /**
     * Хранимая процедура sql
     * @return Объект для заполнения и выполнения процедуры
     */
    public StoredProcedure storedProcedure(String queryText) {
        return new StoredProcedure(sqlBridge, queryText);
    }

    /**
     * Функция sql
     * @return Объект для управления функцией
     */
    public TableValuedFunction tableFunction(String queryText) {
        return new TableValuedFunction(sqlBridge, queryText);
    }

    /**
     * Проверка возможности присоединится к серверу
     */
    public boolean connectionAvailable() {
        return sqlBridge.tryConnection();
    }
}
