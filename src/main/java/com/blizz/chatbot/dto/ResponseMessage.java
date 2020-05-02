package com.blizz.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseMessage extends RequestMessage {

    @JsonProperty("status")
    private final Status status;

    @JsonCreator
    public ResponseMessage(@JsonProperty("command") final Command command,
                           @JsonProperty("request_id") final Integer requestId,
                           @JsonProperty("payload") final Map<Payload, Object> payload,
                           @JsonProperty("status") final Status status) {
        super(command, requestId, payload);
        this.status = status;
    }
}
