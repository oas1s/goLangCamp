package com.example.demo.mapping;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class MyPairDeserializer extends StdDeserializer<Map<String, String>> {

    public MyPairDeserializer() {
        this(null);
    }

    protected MyPairDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    @SneakyThrows
    public Map<String, String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        StringBuilder startString = new StringBuilder();
        startString.append("{");
        for (JsonNode node1 : node) {
            startString.append(node1.toString().substring(1, node1.toString().length() - 1)).append(",");
        }
        startString.deleteCharAt(startString.length()-1);
        startString.append("}");
        String str = startString.toString();
        TypeReference<HashMap<String, String>> typeRef
                = new TypeReference<>() {};
        return new ObjectMapper().readValue(str, typeRef);
    }
}