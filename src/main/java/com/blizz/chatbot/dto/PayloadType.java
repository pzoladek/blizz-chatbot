package com.blizz.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PayloadType {

    API_KEY("api_key"),
    CHANNEL_NAME("channel"),
    USER_ACCOUNT_NAME("toon_name"),
    USER_FLAG("flag"),
    USER_CHAT_ID("user_id"),
    MESSAGE_TYPE("type"),
    MESSAGE("message");

    private final String value;

    PayloadType(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
