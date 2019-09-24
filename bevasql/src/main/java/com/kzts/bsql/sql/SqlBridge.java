package com.kzts.bsql.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SqlBridge {
    private Connection connection;
    private Statement statement;
    private ConnectionToken connectionInfo;

    private SqlBridge(ConnectionToken connectionInfo) {
        this.connectionInfo = connectionInfo;
    }
    static SqlBridge getFromToken(ConnectionToken connectionInfo) {
        return new SqlBridge(connectionInfo);
    }

    boolean tryConnection() {
        try {
            connect();
            close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    void connect() throws SQLException, ClassNotFoundException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        connection = getWorkConnection();
        statement = connection.createStatement();
    }
    void execute(Query query) throws SQLException {
        executeQuery(query);
    }
    ResultSet get(Query query) throws SQLException {
        return executeQueryWithResultSet(query);
    }
    void close() throws SQLException {
        closeConnectionManager();
    }

    private Connection getWorkConnection() throws SQLException {
        return DriverManager.getConnection( connectionInfo.getMSSQLAddress());
    }
    private ResultSet executeQueryWithResultSet(Query query) throws SQLException {
        return statement.executeQuery(query.getQueryText());
    }
    private void executeQuery (Query query) throws SQLException {
        statement.execute(query.getQueryText());
    }
    private void closeConnectionManager() throws SQLException {
        connection.close();
        statement.close();
    }
}
