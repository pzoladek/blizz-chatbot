package com.blizz.chatbot.service;

import com.blizz.chatbot.component.ChatWebSocketHandler;
import com.blizz.chatbot.dto.RequestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;
import org.springframework.web.socket.client.WebSocketClient;

@Service
@Slf4j
public class BlizzardClientService {

    private final WebSocketSession webSocketSession;
    private final ApiRequestsService apiRequestsService;

    public BlizzardClientService(@Value("${blizzard.api.url}") final String blizzardApiUrl,
                                 final WebSocketClient webSocketClient,
                                 final ChatWebSocketHandler chatWebSocketHandler,
                                 final ApiRequestsService apiRequestsService) throws Exception {
        this.webSocketSession = webSocketClient.doHandshake(chatWebSocketHandler, blizzardApiUrl).get();
        this.apiRequestsService = apiRequestsService;
    }

    public String sendMessage(final RequestMessage requestMessage) {
        return null;
    }
}