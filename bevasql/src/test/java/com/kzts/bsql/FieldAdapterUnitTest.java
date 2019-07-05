package com.kzts.bsql;

import androidx.core.util.Supplier;

import com.kzts.bsql.sql.EntityField;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class FieldAdapterUnitTest<E> {
    public class Order {
        @EntityField("ndo")
        int ndo;
        @EntityField("info")
        String info;
    }

    @Test
    void EntityAdapterUnitTest() {
        for (Field f: Order.class.getFields()) {
            EntityField entityField = f.getAnnotation(EntityField.class);
            if(entityField != null)
                System.out.println(entityField.value());
        }
    }

    @Test
    void classTest() {
        /*
        Order.class -> E -> Supplier<E> -> Order


         */
//        Order eee = getInstanceWithValue(Order::new);
        Order order = getInstanceWithValue(Order::new);
    }

    private <E> E getInstanceWithValue(Supplier<E> entity){
        return entity.get();
    }


    private <E> void testSup(Supplier<E> entity) {
        for (Field field:entity.get().getClass().getDeclaredFields())
            System.out.println(field.getName());
    }

}
