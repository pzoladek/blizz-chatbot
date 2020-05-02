package com.blizz.chatbot.controller;

import com.blizz.chatbot.dto.RequestMessage;
import com.blizz.chatbot.service.BlizzardClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/capi")
@RequiredArgsConstructor
public class BlizzardCapiController {

    private final BlizzardClientService blizzardClientService;

    @PostMapping
    ResponseEntity<String> sendMessage(@RequestBody final RequestMessage requestMessage) {
        blizzardClientService.sendMessage(requestMessage);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
