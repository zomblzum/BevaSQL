package com.kzts.bevasql.sql;

import java.lang.reflect.Field;


public class Entity<E> {
    private Supplier<E> entity;

    Entity(Supplier<E> entity) {
        this.entity = entity;
    }

    public E get() {
        return this.entity.get();
    }
    Field[] fields() {
        return get().getClass().getDeclaredFields();
    }

    String annotation(Field field) {
        if (field.isAnnotationPresent(EntityField.class))
            return field.getAnnotation(EntityField.class).value();
        else
            return null;
    }
}
