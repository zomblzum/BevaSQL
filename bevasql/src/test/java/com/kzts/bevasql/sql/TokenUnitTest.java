package com.kzts.bevasql.sql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenUnitTest {
    @Test
    void getConnectionAddressString_isCorrect() {
        String connectionStringTest = "jdbc:sqlserver://server;databaseName=db;user=login;password=pwd";
        ConnectionToken connectionToken = new ConnectionToken("server","db","login","pwd");
        assertEquals(connectionToken.getTokenAddress(), connectionStringTest);
    }
}
