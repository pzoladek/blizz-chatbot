package com.blizz.chatbot.service;

import com.blizz.chatbot.dto.BotCommand;
import com.blizz.chatbot.dto.PayloadType;
import com.blizz.chatbot.dto.RequestMessage;
import com.blizz.chatbot.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponseProcessingService {

    private final BotCommandExecutionService botCommandExecutionService;

    public Optional<RequestMessage> process(final ResponseMessage responseMessage) {
        switch (responseMessage.getCommand()) {
            case AUTHENTICATION_RESPONSE:
                return Optional.of(RequestMessage.ofConnection());
            case MESSAGE_EVENT:
                return processMessage(responseMessage.getPayload());
            default:
                return Optional.empty();
        }
    }

    private Optional<RequestMessage> processMessage(Map<PayloadType, Object> payload) {
        final var message = (String) payload.get(PayloadType.MESSAGE);
        return botCommandExecutionService.execute(message)
                .map(RequestMessage::withMessage);
    }

}
