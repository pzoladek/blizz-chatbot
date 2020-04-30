package com.blizz.chatbot.service;

import com.blizz.chatbot.dto.Command;
import com.blizz.chatbot.dto.Payload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Service
public class BlizzardClientService {

    private final String blizzardApiUrl;
    private final String blizzardApiKey;
    private final WebSocketStompClient webSocketClient;

    public BlizzardClientService(@Value("${blizzard.api.url}") final String blizzardApiUrl,
                                 @Value("${blizzard.api.key}") final String blizzardApiKey,
                                 final WebSocketStompClient webSocketClient) {
        this.blizzardApiUrl = blizzardApiUrl;
        this.blizzardApiKey = blizzardApiKey;
        this.webSocketClient = webSocketClient;
    }

    @PostConstruct
    public void initializeWebsocketConnection() throws Exception {


    }


}