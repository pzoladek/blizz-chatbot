package com.blizz.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Payload {

    @JsonProperty("api_key")
    private final String apiKey;

    @JsonCreator
    public Payload(@JsonProperty("api_key") final String apiKey) {
        this.apiKey = apiKey;
    }

}
