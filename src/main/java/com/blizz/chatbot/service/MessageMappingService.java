package com.blizz.chatbot.service;

import com.blizz.chatbot.dto.ResponseMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageMappingService {

    private final ObjectMapper objectMapper;

    public String mapToJson(final Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Couldn't write object as json: " + object.toString());
        }
    }

    public ResponseMessage mapToResponseMessage(final String message) {
        try {
            return objectMapper.readValue(message, ResponseMessage.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalStateException("Couldn't write json as object: " + message);
        }
    }


}
