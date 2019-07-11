package com.kzts.bsql.sql;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenUnitTest {
    private ConnectionToken token = new ConnectionToken("saturn", "kzts_main", "test_vlad", "612000173");
    private BevaSQL bevaSQL = new BevaSQL(token);

    public class Task {
        @EntityField("doc_num")
        int docNum;
        @EntityField("string_num")
        int stringNum;
        @EntityField("marka")
        String marka;
        @EntityField("forma")
        String forma;
        @EntityField("ves")
        BigDecimal weight;
        @EntityField("kol")
        int quantity;
        @EntityField("bin_name")
        String binName;
        @EntityField("id_bin")
        Integer binId;
        @EntityField("bin_count")
        int binCount;
        @EntityField("bar_code")
        int barCode;
        @EntityField("bin_checked")
        int binChecked;
        @EntityField("unload_confirmed")
        int unloadConfirmed;
        @EntityField("ship_confirmed")
        int shipConfirmed;
        @EntityField("cancel_scan")
        boolean cancelScan;
        @EntityField("status")
        int status;

        void checkBin() {
            if (!isComplete() && isCorrect()) {
                binChecked -= 1;
            }
        }

        boolean isComplete() {
            return (binCount - binChecked) == 0 || status == 3;
        }
        boolean isCorrect() {
            return binChecked >= 0 && binChecked <= binCount;
        }
    }

    // Необходимо заполнить данные для проверки под актуальные
    private int orderId = 201854328;
    private int barCode = 1192536;

    @Test
    void getConnectionAddressString_isCorrect() {
        String connectionStringTest = "jdbc:jtds:sqlserver://server;databaseName=db;user=login;password=pwd;encrypt=true;trustServerCertificate=true;";
        ConnectionToken connectionToken = new ConnectionToken("server","db","login","pwd");
        assertEquals(connectionToken.getMSSQLAddress(), connectionStringTest);
    }

    @Test
    void checkItem() throws Exception {
        List<Task> tasks = bevaSQL.storedProcedure("stock_shuttle_scan_get_order_items_2014")
                .addParameter(orderId)
                .addParameter("mode", 1)
                .get(Task::new);

        for (Task task : tasks) {
            System.out.println(task.docNum + "||" + task.binName + "||" + task.stringNum);
        }
    }
}
