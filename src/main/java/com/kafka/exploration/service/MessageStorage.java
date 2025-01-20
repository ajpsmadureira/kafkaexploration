package com.kafka.exploration.service;

import java.util.List;

public interface MessageStorage {

    void storeMessage(String message);

    List<String> getMessages();
}
