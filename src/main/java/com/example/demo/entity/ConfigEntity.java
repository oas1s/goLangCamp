package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "config")
@IdClass(ConfigId.class)
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class ConfigEntity {

    public ConfigEntity(){
        this.version = 1L;
    }
    @Id
    public String service;
    @Type(type = "json")
    public Map<String,String> data;
    @Id
    public Long version;
}
