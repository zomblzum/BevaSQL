package com.kzts.bsql.sql;

import java.lang.reflect.Field;
import java.util.Objects;


class Entity<E> {
    private Supplier<E> entity;

    Entity(Supplier<E> entity) {
        this.entity = entity;
    }

    E get() {
        return this.entity.get();
    }
    Field[] fields() {
        return get().getClass().getDeclaredFields();
    }

    String annotation(Field field) {
        if (field.isAnnotationPresent(EntityField.class))
            return getEntityFieldAnnotation(field).value();
        else
            return null;
    }

    private EntityField getEntityFieldAnnotation(Field field) {
        return Objects.requireNonNull(field.getAnnotation(EntityField.class));
    }
}
