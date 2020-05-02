package com.blizz.chatbot.service;

import com.blizz.chatbot.dto.Command;
import com.blizz.chatbot.dto.RequestMessage;
import com.blizz.chatbot.dto.ResponseMessage;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponseProcessingService {

    public Optional<RequestMessage> process(final ResponseMessage responseMessage) {
        switch (responseMessage.getCommand()) {
            case AUTHENTICATION_RESPONSE:
                return Optional.of(RequestMessage.ofConnection());
            default:
                return Optional.empty();
        }
    }

}
