package com.blizz.chatbot.service;

import com.blizz.chatbot.dto.BotCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BotCommandExecutionService {

    public Optional<String> execute(final String command) {
        return BotCommand.of(command)
                .flatMap(this::getExecutionResult);
    }

    private Optional<String> getExecutionResult(final BotCommand command) {
        switch (command) {
            case HELP:
                return Optional.of(getHelpResponse());
            case LOGIN:
            default:
                return Optional.empty();
        }
    }

    private String getHelpResponse() {
        final var text = "Available commands (type #help <command> for more info): " +
                Arrays.stream(BotCommand.values())
                        .map(BotCommand::getValue)
                        .collect(Collectors.joining(", "));
        return text;
    }
}
