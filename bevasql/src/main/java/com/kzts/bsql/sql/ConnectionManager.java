package com.kzts.bsql.sql;

import android.os.StrictMode;

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

    void connect() throws SQLException, ClassNotFoundException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        connection = getWorkConnection();
        statement = connection.createStatement();
    }
    void execute(Query procedureQuery) throws SQLException {
        executeQuery(procedureQuery);
    }
    ResultSet get(Query procedureQuery, Entity entity) throws SQLException {
        return executeQueryWithResultSet(procedureQuery, entity);
    }
    void close() throws SQLException {
        closeConnectionManager();
    }

    private Connection getWorkConnection() throws SQLException {
        return DriverManager.getConnection( connectionInfo.getMSSQLAddress());
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
