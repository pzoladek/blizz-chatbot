package com.blizz.chatbot.service;

import com.blizz.chatbot.component.ChatWebSocketHandler;
import com.blizz.chatbot.dto.RequestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketClient;

import java.io.IOException;

@Service
@Slf4j
public class BlizzardClientService {

    private final WebSocketSession webSocketSession;
    private final MessageMappingService messageMappingService;

    public BlizzardClientService(@Value("${blizzard.api.url}") final String blizzardApiUrl,
                                 final WebSocketClient webSocketClient,
                                 final ChatWebSocketHandler chatWebSocketHandler,
                                 final MessageMappingService messageMappingService) throws Exception {
        this.webSocketSession = webSocketClient.doHandshake(chatWebSocketHandler, blizzardApiUrl).get();
        this.messageMappingService = messageMappingService;
    }

    public void sendMessage(final RequestMessage requestMessage) {
        final var jsonMessage = messageMappingService.mapToJson(requestMessage);
        sendMessage(jsonMessage);
    }

    private void sendMessage(final String message) {
        log.info("Sending request from REST controller...");
        try {
            webSocketSession.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            throw new IllegalStateException("Couldn't send message to CAPI: " + message);
        }
    }
}