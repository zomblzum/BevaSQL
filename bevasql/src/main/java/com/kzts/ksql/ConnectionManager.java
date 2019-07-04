package com.kzts.ksql;

import com.kzts.ksql.log.Log;

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
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connection = getWorkConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void execute(ProcedureQuery procedureQuery) {
        try {
            executeQuery(procedureQuery);
        } catch (Exception e) {
            Log.e(e.getMessage(),e.getCause());
        }
    }
    ResultSet get(ProcedureQuery procedureQuery) {
        try {
            return executeQueryWithResultSet(procedureQuery);
        } catch (SQLException e) {
            Log.e(e.getMessage(),e.getCause());
            return null;
        }
    }
    void close() {
        try {
            closeConnectionManager();
        } catch (SQLException e) {
            Log.e(e.getMessage(),e.getCause());
        }
    }

    private Connection getWorkConnection() throws SQLException {
        return DriverManager.getConnection( connectionInfo.getTokenAddress(),
                                            connectionInfo.getUser(),
                                            connectionInfo.getPassword());
    }
    private ResultSet executeQueryWithResultSet(ProcedureQuery procedureQuery) throws SQLException {
        return statement.executeQuery(procedureQuery.build());
    }
    private void executeQuery (ProcedureQuery procedureQuery) throws SQLException {
        statement.execute(procedureQuery.build());
    }
    private void closeConnectionManager() throws SQLException {
        connection.close();
        statement.close();
    }
}
