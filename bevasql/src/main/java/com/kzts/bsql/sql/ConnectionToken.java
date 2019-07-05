package com.kzts.bsql.sql;

public class ConnectionToken {
    private String user;
    private String password;
    private String server;
    private String database;

    public ConnectionToken(String server, String database, String user, String password) {
        this.server = server;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    String getUser() {
        return user;
    }
    String getPassword() {
        return password;
    }
    String getTokenAddress() {
        return "jdbc:sqlserver://" + this.server + ";databaseName=" + this.database
                        + ";user=" + this.user + ";password=" + this.password;
    }
}
