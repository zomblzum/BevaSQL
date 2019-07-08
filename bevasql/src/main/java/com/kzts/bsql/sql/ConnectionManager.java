package com.kzts.bsql.sql;

import com.kzts.bsql.log.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ConnectionManager {
    private Connection connection;
    private Statement statement;
    private ConnectionToken connectionInfo;

    private ConnectionManager(ConnectionToken connectionInfo) {
        this.connectionInfo = connectionInfo;
    }
    static ConnectionManager getFromToken(ConnectionToken connectionInfo) {
        return new ConnectionManager(connectionInfo);
    }

    void connect() {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            connection = getWorkConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            Log.e(e.getMessage(),e.getCause());
        }
    }
    void execute(Query procedureQuery) {
        try {
            executeQuery(procedureQuery);
        } catch (Exception e) {
            Log.e(e.getMessage(),e.fillInStackTrace());
        }
    }
    ResultSet get(Query procedureQuery, Entity entity) {
        try {
            return executeQueryWithResultSet(procedureQuery, entity);
        } catch (Exception e) {
            Log.e(e.getMessage(),e.fillInStackTrace());
            return null;
        }
    }
    void close() {
        try {
            closeConnectionManager();
        } catch (Exception e) {
            Log.e(e.getMessage(),e.getCause());
        }
    }

    private Connection getWorkConnection() throws SQLException {
        return DriverManager.getConnection( connectionInfo.getTokenAddress());
    }
    private ResultSet executeQueryWithResultSet(Query procedureQuery, Entity entity) throws SQLException {
        return statement.executeQuery(procedureQuery.build());
    }
    private void executeQuery (Query procedureQuery) throws SQLException {
        statement.execute(procedureQuery.build());
    }
    private void closeConnectionManager() throws SQLException {
        connection.close();
        statement.close();
    }
}
