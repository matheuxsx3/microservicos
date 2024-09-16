package br.com.microservices.orchestrated.paymentservice.core.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.microservices.orchestrated.paymentservice.core.dto.Event;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JsonUtils {
    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Event toEvent(String json) {  
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } 
}