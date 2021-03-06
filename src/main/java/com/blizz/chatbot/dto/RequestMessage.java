package com.blizz.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestMessage {

    @JsonProperty("command")
    private final Command command;
    @JsonProperty("request_id")
    private final Integer requestId;
    @JsonProperty("payload")
    private final Map<PayloadType, Object> payload;


    @Builder
    @JsonCreator
    public RequestMessage(@JsonProperty("command") final Command command,
                          @JsonProperty("request_id") final Integer requestId,
                          @JsonProperty("payload") final Map<PayloadType, Object> payload) {
        this.command = command;
        this.requestId = requestId;
        this.payload = payload;
    }

    public static RequestMessage ofAuthentication(final String apiKey) {
        return RequestMessage.builder()
                .command(Command.AUTHENTICATION)
                .payload(Map.of(PayloadType.API_KEY, apiKey))
                .build();
    }

    public static RequestMessage ofConnection() {
        return RequestMessage.builder()
                .command(Command.CONNECTION)
                .build();
    }

    public static RequestMessage withMessage(final String message) {
        return RequestMessage.builder()
                .command(Command.MESSAGE_SENDING)
                .payload(Map.of(PayloadType.MESSAGE, message))
                .build();
    }
}