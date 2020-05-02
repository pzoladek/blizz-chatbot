package com.blizz.chatbot.component;

import com.blizz.chatbot.service.ApiRequestsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChatWebSocketHandler implements WebSocketHandler {

    private final ApiRequestsService apiRequestsService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sendMessage(session, apiRequestsService.getAuthenticationRequest());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("HANDLE MESSAGE");
        System.out.println(message.getPayload().toString()); // TODO: RM this.

        apiRequestsService.processMessage(message.getPayload().toString())
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
