package com.blizz.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Status {

    @JsonProperty("area")
     private final Integer area;
    @JsonProperty("code")
     private final Integer code;

    @JsonCreator
    public Status(@JsonProperty("area") final Integer area,
                  @JsonProperty("code") final Integer code) {
        this.area = area;
        this.code = code;
    }
}
