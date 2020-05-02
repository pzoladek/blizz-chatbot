package com.blizz.chatbot.service;

import com.blizz.chatbot.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiRequestsService {

    private final ObjectMapper objectMapper;
    private final ResponseProcessingService responseProcessingService;
    private final String blizzardApiKey;

    public ApiRequestsService(final ObjectMapper objectMapper,
                              final ResponseProcessingService responseProcessingService,
                              @Value("${blizzard.api.key}") final String blizzardApiKey) {
        this.objectMapper = objectMapper;
        this.responseProcessingService = responseProcessingService;
        this.blizzardApiKey = blizzardApiKey;
    }

    public Optional<String> processMessage(final String message) {
        final var request = responseProcessingService.process(asResponseMessage(message));
        return request.map(this::asJson);
    }

    public String getAuthenticationRequest() {
        final var authenticationRequest = RequestMessage.ofAuthentication(blizzardApiKey);
        return asJson(authenticationRequest);
    }

    private String asJson(final Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Couldn't write object as json: " + object.toString());
        }
    }

    private ResponseMessage asResponseMessage(final String message) {
        try {
            return objectMapper.readValue(message, ResponseMessage.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalStateException("Couldn't write json as object: " + message);
        }
    }


}
