package com.blizz.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Command {
    AUTHENTICATION("Botapiauth.AuthenticateRequest"),
    AUTHENTICATION_RESPONSE("Botapiauth.AuthenticateResponse"),
    CONNECTION("Botapichat.ConnectRequest"),
    CONNECTION_EVENT("Botapichat.ConnectEventRequest"),
    CONNECTION_RESPONSE("Botapichat.ConnectResponse"),
    USER_UPDATE_EVENT("Botapichat.UserUpdateEventRequest"),
    USER_LEAVE_EVENT("Botapichat.UserLeaveEventRequest"),
    MESSAGE_EVENT("Botapichat.MessageEventRequest");

    private final String value;

    Command(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}