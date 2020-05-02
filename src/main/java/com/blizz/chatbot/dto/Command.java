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
    MESSAGE_EVENT("Botapichat.MessageEventRequest"),
    MESSAGE_SENDING("Botapichat.SendMessageRequest"),
    MESSAGE_SENDING_RESPONSE("Botapichat.SendMessageResponse"),
    WHISPER_SENDING("Botapichat.SendWhisperRequest"),
    WHISPER_SENDING_RESPONSE("Botapichat.SendWhisperResponse"),
    EMOTE_SENDING("Botapichat.SendEmoteRequest"),
    EMOTE_SENDING_RESPONSE("Botapichat.SendEmoteResponse"),
    KICK_USER("Botapichat.KickUserRequest"),
    KICK_USER_RESPONSE("Botapichat.KickUserResponse"),
    BAN_USER("Botapichat.BanUserRequest"),
    BAN_USER_RESPONSE("Botapichat.BanUserResponse"),
    UNBAN_USER("Botapichat.UnbanUserRequest"),
    UNBAN_USER_RESPONSE("Botapichat.UnbanUserResponse"),
    SET_MODERATOR("Botapichat.SendSetModeratorRequest"),
    SET_MODERATOR_RESPONSE("Botapichat.SendSetModeratorResponse");

    private final String value;

    Command(final String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}