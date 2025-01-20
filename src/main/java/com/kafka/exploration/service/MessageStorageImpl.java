package com.kafka.exploration.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class MessageStorageImpl implements MessageStorage{

    private final Collection<String> inMemoryMessageStorage = Collections.synchronizedCollection(new ArrayList<>());

    @Override
    public void storeMessage(String message) {

        inMemoryMessageStorage.add(message);
    }

    @Override
    public List<String> getMessages() {

        return inMemoryMessageStorage.stream().toList();
    }
}
