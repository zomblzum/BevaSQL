package com.kzts.bsql.sql;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ResultSetReader<E> {
    private ResultSet resultSet;

    ResultSetReader(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    List<E> toEntityList(Entity<? extends E> entity) throws SQLException, IllegalAccessException {
        List<E> entityList = new ArrayList<>();
        while(resultSet.next()){
            E newEntity = entity.get();
            for (Field field: entity.fields()) {
                String annotation = entity.annotation(field);
                if(isExist(resultSet,annotation)) {
                    field.setAccessible(true);
                    field.set(newEntity, resultSet.getObject(annotation));
                }
            }
            entityList.add(newEntity);
        }
        return entityList;
    }

    private boolean isExist(ResultSet resultSet, String column) throws SQLException {
        if (column == null || column.trim().isEmpty())
            return false;

        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++)
            if (metaData.getColumnName(i).equals(column))
                return true;

        return false;
    }
}
