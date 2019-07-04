package com.kzts.ksql;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

class KSQLUnitTest {
    private ConnectionToken token = new ConnectionToken("myst","kzts_main","test_vlad", "612000173");

    @Test
    void storedProcedureCommitTry() {
        KSQL ksql = new KSQL(token);
        ksql.storedProcedure()
                .setProcedure("message_insert_new")
                .addParameter("form_name","test123")
                .addParameter("message_text", 123.321)
                .execute();
    }


    @Test
    void storedProcedureGetTry() throws SQLException {
        KSQL ksql = new KSQL(token);
        List orders = ksql.storedProcedure()
                                .setProcedure("stock_shuttle_scan_get_order_items_2014")
                                .addParameter("order_num",201947773)
                                .addParameter("mode",1).get();
        System.out.println(orders.size());
    }
}
