package com.kzts.ksql;

import com.kzts.ksql.parameters.Parameter;
import com.kzts.ksql.parameters.VarcharParameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
class ConnectionUnitTest {
    @Test
    void getConnectionAddressString_isCorrect() {
        String connectionStringTest = "jdbc:sqlserver://server;databaseName=db;user=login;password=pwd";
        ConnectionToken connectionToken = new ConnectionToken("server","db","login","pwd");
        assertEquals(connectionToken.getTokenAddress(), connectionStringTest);
    }

    @Test
    void connect() {
        ProcedureQuery procedureQuery = new ProcedureQuery();
        procedureQuery.setProcedure("message_insert_new");
        procedureQuery.addParameter(new VarcharParameter("form_name","test1"));
        procedureQuery.addParameter(new VarcharParameter("message_text","test1"));
        ConnectionManager connectionManager = ConnectionManager.getFromToken(new ConnectionToken("myst","kzts_main","test_vlad","612000173"));
        connectionManager.connect();
        connectionManager.execute(procedureQuery);
        connectionManager.close();
        assertEquals(1, 1);
    }
}