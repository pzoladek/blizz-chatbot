package com.blizz.chatbot.dto;

import java.util.Arrays;
import java.util.Optional;

public enum BotCommand {

    HELP("#help"), LOGIN("#login"), REGISTER("#register");

    private final String value;

    BotCommand(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<BotCommand> of(final String command) {
        return Arrays.stream(BotCommand.values())
                .filter(botCommand -> botCommand.getValue().equalsIgnoreCase(command))
                .findFirst();
    }

}
