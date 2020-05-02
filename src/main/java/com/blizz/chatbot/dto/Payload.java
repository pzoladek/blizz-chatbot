package com.blizz.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Payload {

    API_KEY("api_key"),
    CHANNEL_NAME("channel"),
    USER_ACCOUNT_NAME("toon_name"),
    USER_FLAG("flag"),
    USER_CHAT_ID("user_id"),
    MESSAGE_TYPE("type");


    private final String value;

    Payload(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
