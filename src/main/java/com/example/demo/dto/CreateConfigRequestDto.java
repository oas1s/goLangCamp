package com.example.demo.dto;

import com.example.demo.mapping.MyPairDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateConfigRequestDto {
    public String service;
    @JsonDeserialize(using = MyPairDeserializer.class)
    public Map<String,String> data;

    @Override
    public String toString() {
        return "CreateConfigRequestDto{" +
                "service='" + service + '\'' +
                ", data=" + data +
                '}';
    }
}
