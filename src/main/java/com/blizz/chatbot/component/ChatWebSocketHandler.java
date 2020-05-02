package com.blizz.chatbot.component;

import com.blizz.chatbot.dto.RequestMessage;
import com.blizz.chatbot.service.MessageMappingService;
import com.blizz.chatbot.service.ResponseProcessingService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;

@Component
@Slf4j
public class ChatWebSocketHandler implements WebSocketHandler {

    private final ResponseProcessingService responseProcessingService;
    private final MessageMappingService messageMappingService;
    private final String blizzardApiKey;

    public ChatWebSocketHandler(final ResponseProcessingService responseProcessingService,
                                final MessageMappingService messageMappingService,
                                @Value("${blizzard.api.key}") final String blizzardApiKey) {
        this.responseProcessingService = responseProcessingService;
        this.messageMappingService = messageMappingService;
        this.blizzardApiKey = blizzardApiKey;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        final var authenticationRequest = messageMappingService.mapToJson(RequestMessage.ofAuthentication(blizzardApiKey));
        sendMessage(session, authenticationRequest);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("HANDLE MESSAGE");
        System.out.println(message.getPayload().toString()); // TODO: RM this.

        final var responseMessage = messageMappingService.mapToResponseMessage(message.getPayload().toString());

        responseProcessingService.process(responseMessage)
                .map(messageMappingService::mapToJson)
                .ifPresent(response -> sendMessage(session, response));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    private void sendMessage(final WebSocketSession session, final String message) {
        log.info("Sending request as a reply to the server...");
        try {
            session.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            throw new IllegalStateException("Couldn't send message to CAPI: " + message);
        }
    }
}
