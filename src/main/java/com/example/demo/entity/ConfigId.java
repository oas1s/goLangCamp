package com.example.demo.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
@EqualsAndHashCode
public class ConfigId implements Serializable {
    private String service;
    private Long version;

    public ConfigId(String service, Long version) {
        this.service = service;
        this.version = version;
    }

    public ConfigId() {
    }
}
