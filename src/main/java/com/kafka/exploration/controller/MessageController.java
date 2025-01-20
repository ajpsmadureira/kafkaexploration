package com.kafka.exploration.controller;

import com.kafka.exploration.service.KafkaService;
import com.kafka.exploration.service.MessageStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final KafkaService kafkaService;

    private final MessageStorage messageStorage;

    @Value(value = "${spring.kafka.topic}")
    private String topic;

    @PostMapping(path = "/message", produces = "text/plain")
    public String sendMessage(@RequestBody String message) {

        kafkaService.sendMessage(message);

        return "Ok";
    }

    @GetMapping(path = "/messages", produces = "application/json")
    public List<String> getMessages() {

        return messageStorage.getMessages();
    }
}
