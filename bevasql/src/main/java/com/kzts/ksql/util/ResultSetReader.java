package com.kzts.ksql.util;

import com.kzts.ksql.sql.EntityField;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetReader<E> {
    private E entity;

    public ResultSetReader(Supplier<E> entity) {
        this.entity = entity.get();
    }

    public List toList(ResultSet resultSet) throws SQLException {
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

    public List<E> toEntityList(ResultSet resultSet) throws SQLException, IllegalAccessException {
        int columnCount = resultSet.getMetaData().getColumnCount();
        List<E> enityList = new ArrayList<>();
        while(resultSet.next()){
            Field[] fields = entity.getClass().getDeclaredFields();
            for (Field field: fields) {
                try {
                    if (resultSet.getString(field.getAnnotation(EntityField.class).value()) != null) {
                        field.setAccessible(true);
                        field.set(entity, resultSet.getString(field.getAnnotation(EntityField.class).value()));
                    }
                    enityList.add(entity);
                } catch (Exception e) {}
            }
        }
        return enityList;
    }
}
