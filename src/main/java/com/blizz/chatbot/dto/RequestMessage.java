package com.blizz.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestMessage {

    @JsonProperty("command")
    private final Command command;
    @JsonProperty("request_id")
    private final Integer requestId;
    @JsonProperty("payload")
    private final Payload payload;


    @JsonCreator
    public RequestMessage(@JsonProperty("command") final Command command,
                          @JsonProperty("request_id") final Integer requestId,
                          @JsonProperty("payload") final Payload payload) {
        this.command = command;
        this.requestId = requestId;
        this.payload = payload;
    }
}