package com.kzts.bsql.sql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenUnitTest {
    @Test
    void getConnectionAddressString_isCorrect() {
        String connectionStringTest = "jdbc:sqlserver://server;databaseName=db;user=login;password=pwd";
        ConnectionToken connectionToken = new ConnectionToken("server","db","login","pwd");
        assertEquals(connectionToken.getTokenAddress(), connectionStringTest);
    }
}
