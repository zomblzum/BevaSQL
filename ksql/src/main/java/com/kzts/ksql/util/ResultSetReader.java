package com.kzts.ksql.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetReader {
    public List<Map<String, String>> toList(ResultSet resultSet) throws SQLException {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        List<String> columns = new ArrayList<String>(rsmd.getColumnCount());
        for(int i = 1; i <= rsmd.getColumnCount(); i++){
            columns.add(rsmd.getColumnName(i));
        }
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        while(resultSet.next()){
            Map<String, String> row = new HashMap<String, String>(columns.size());
            for(String col : columns) {
                row.put(col, resultSet.getString(col));
            }
            data.add(row);
        }
        return data;
    }
}
