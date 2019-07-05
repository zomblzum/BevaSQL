package com.kzts.ksql;

import com.kzts.ksql.sql.BevaSQL;
import com.kzts.ksql.sql.ConnectionToken;
import com.kzts.ksql.sql.Entity;
import com.kzts.ksql.sql.EntityField;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BevaSQLUnitTest {
    private ConnectionToken token = new ConnectionToken("myst","kzts_main","test_vlad", "612000173");

    @Entity
    public class Order {
        @EntityField("doc_num")
        String ndo;
        @EntityField("bin_name")
        String binName;
    }

    @Test
    void storedProcedureCommitTry() {
        BevaSQL bevaSQL = new BevaSQL(token);
        bevaSQL.storedProcedure()
                .setProcedure("message_insert_new")
                .addParameter("form_name","test123")
                .addParameter("message_text", 123.321)
                .execute();
    }


    @Test
    void storedProcedureGetTry() throws SQLException, IllegalAccessException {
        BevaSQL bevaSQL = new BevaSQL(token);
        List<Order> orders = bevaSQL.storedProcedure()
                                .setProcedure("stock_shuttle_scan_get_order_items_2014")
                                .addParameter("order_num",201947773)
                                .addParameter("mode",1).get(Order::new);

        for (Order order: orders) {
            System.out.println(order.ndo + "||" + order.binName);
        }
    }
}
