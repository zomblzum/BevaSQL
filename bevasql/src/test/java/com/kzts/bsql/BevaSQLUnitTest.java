package com.kzts.bsql;

import com.kzts.bsql.sql.BevaSQL;
import com.kzts.bsql.sql.ConnectionToken;
import com.kzts.bsql.sql.EntityField;
import com.kzts.bsql.sql.ProcedureExecutor;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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

    private class OrderLog {
        @EntityField("ndo")
        private int ndo;
        @EntityField("dd")
        private Timestamp date;
        @EntityField("user_name")
        private String user;
    }

    private class Rod {
        @EntityField("Год_счёта")
        private int year;
        @EntityField("Форма")
        private String form;
        @EntityField("Вес")
        private BigDecimal weight;
    }

    @Test
    void storedProcedureGetTry() throws Exception {
        BevaSQL bevaSQL = new BevaSQL(token);

        List<Order> orders = bevaSQL.storedProcedure()
                .setProcedure("stock_shuttle_scan_get_order_items_2014")
                .addParameter(201947773)
                .addParameter("mode",1)
                .get(Order::new);

        for (Order order: orders) {
            System.out.println(order.ndo + "||" + order.binName + "||" + order.stringNum);
        }
    }

    @Test
    void storedProcedureTwoGetTry() throws Exception{
        BevaSQL bevaSQL = new BevaSQL(token);

        List<OrderLog> orders = bevaSQL.storedProcedure()
                .setProcedure("get_move_platej_history")
                .get(OrderLog::new);

        for (OrderLog orderLog: orders) {
            System.out.println(orderLog.ndo + "||" + orderLog.user + "||" + orderLog.date);
        }
    }

    @Test
    void functionGetTry() throws Exception{
        BevaSQL bevaSQL = new BevaSQL(token);

        List<Rod> orders = bevaSQL.tableFunction()
                .setFunction("[pso_sales_rods]")
                .addParameter(2019)
                .get(Rod::new);

        for (Rod orderLog: orders) {
            System.out.println(orderLog.year + "||" + orderLog.form + "||" + orderLog.weight);
        }
    }
}
