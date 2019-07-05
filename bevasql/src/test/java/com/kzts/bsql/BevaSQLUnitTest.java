package com.kzts.bsql;

import com.kzts.bsql.sql.BevaSQL;
import com.kzts.bsql.sql.ConnectionToken;
import com.kzts.bsql.sql.EntityField;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BevaSQLUnitTest {
    private ConnectionToken token = new ConnectionToken("myst","kzts_main","test_vlad", "612000173");

    private class Order {
        @EntityField("doc_num")
        private int ndo;
        @EntityField("bin_name")
        private String binName;
        @EntityField("string_num")
        private int stringNum;
    }

    @Test
    void storedProcedureGetTry() throws Exception {
        BevaSQL bevaSQL = new BevaSQL(token);
        List<Order> orders = bevaSQL.storedProcedure()
                                .setProcedure("stock_shuttle_scan_get_order_items_2014")
                                .addParameter("order_num",201947773)
                                .addParameter("mode",1).get(Order::new);

        for (Order order: orders) {
            System.out.println(order.ndo + "||" + order.binName + "||" + order.stringNum);
        }
    }
}
