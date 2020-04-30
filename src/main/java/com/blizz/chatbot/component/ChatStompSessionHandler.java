package com.blizz.chatbot.component;

import org.springframework.messaging.simp.stomp.*;

import java.lang.reflect.Type;

public class ChatStompSessionHandler extends StompSessionHandlerAdapter implements StompSessionHandler {

    @Override
    public Type getPayloadType(StompHeaders headers) {
        System.out.println("getPayloaadTypeTEST");
        return super.getPayloadType(headers);
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        super.handleFrame(headers, payload);
        System.out.println("handleFrameTEST");
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println(session.toString());
        System.out.println("HEADERS:::::::;\n\n" + connectedHeaders.toString());



    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {

        System.out.println("handleExceptionTEST");
        super.handleException(session, command, headers, payload, exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        System.out.println("handleTransproterrorTEST");
        exception.printStackTrace();
        super.handleTransportError(session, exception);
    }
}