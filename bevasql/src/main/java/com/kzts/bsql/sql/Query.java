package com.kzts.bsql.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Query<E> {
    private String queryText;
    private SqlBridge sqlBridge;

    Query(SqlBridge sqlBridge, String queryText) {
        this.sqlBridge = sqlBridge;
        this.queryText = queryText;
    }

    String getQueryText() {
        return queryText;
    }

    public void execute() throws SQLException, ClassNotFoundException {
        connect();
        sqlBridge.execute(this);
        close();
    }
    public List<E> get(Supplier<E> supplier) throws SQLException, IllegalAccessException, ClassNotFoundException {
        connect();

        ResultSet resultSet = sqlBridge.get(this);
        ResultSetReader<E> resultSetReader = new ResultSetReader<>(resultSet);
        Entity<? extends E> entity = new Entity<>(supplier);
        List<E> data = resultSetReader.toEntityList(entity);

        close();
        return data;
    }
    private void connect() throws SQLException, ClassNotFoundException {
        sqlBridge.connect();
    }
    private void close() throws SQLException {
        sqlBridge.close();
    }
}
