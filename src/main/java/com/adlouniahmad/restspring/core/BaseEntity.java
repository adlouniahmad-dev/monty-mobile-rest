package com.adlouniahmad.restspring.core;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private final Long id;

    protected BaseEntity() {
        id = null;
    }

    protected Long getId() {
        return id;
    }
}
