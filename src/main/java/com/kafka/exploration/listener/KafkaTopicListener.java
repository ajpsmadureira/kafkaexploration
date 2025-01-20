package com.kafka.exploration.listener;

import com.kafka.exploration.service.MessageStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaTopicListener {

    private final MessageStorage messageStorage;

    @KafkaListener(topics = "#{'${spring.kafka.topic}'}", groupId = "#{'${spring.kafka.group-id}'}")
    public void listen(String data) {

        log.info("Received new Kafka message");

        messageStorage.storeMessage(data);
    }
}
