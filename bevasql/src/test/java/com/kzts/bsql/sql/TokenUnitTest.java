package com.kzts.bsql.sql;

import com.kzts.bsql.builders.QueryBuilderSQL;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenUnitTest {
    @Test
    void getConnectionAddressString_isCorrect() {
        String connectionStringTest = "jdbc:jtds:sqlserver://server;databaseName=db;user=login;password=pwd;encrypt=true;trustServerCertificate=true;";
        ConnectionToken connectionToken = new ConnectionToken("server","db","login","pwd");
        assertEquals(connectionToken.getMSSQLAddress(), connectionStringTest);
    }
}
