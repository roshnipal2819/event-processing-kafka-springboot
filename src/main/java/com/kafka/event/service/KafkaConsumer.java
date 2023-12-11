package com.kafka.event.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Kafka consumer.
 */
@Service
public class KafkaConsumer {

    /**
     * The constant messages.
     */
    public static List<String> messages = new LinkedList<>();

    /**
     * The constant messagesDataMap.
     */
    public static List<Map<String, String>> messagesDataMap = new LinkedList<>();

    /**
     * The constant messagesMap.
     */
    public static Map<String, String> messagesMap = new LinkedHashMap<>();


    /**
     * Listen.
     *
     * @param message
     *         the message
     */
    @KafkaListener(topics = "${kafka.listener.topic.name}", groupId = "${kafka.listener.group.id}")
    public void listen(String message) {
        messages.add(message);
    }


    /**
     * Listen header data.
     *
     * @param key
     *         the key
     * @param payload
     *         the payload
     */
    @KafkaListener(topics = "${kafka.listener.topic.name}", groupId = "${kafka.listener.group.id}")
    public void listenHeaderData(@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key, @Payload final String payload) {
        messagesMap.put(key, payload);
    }

    /**
     * Gets consumer data.
     *
     * @return the consumer data
     */
    public List<String> getConsumerData() {
        return messages;
    }

    /**
     * Gets consumer header data.
     *
     * @return the consumer header data
     */
    public Map<String, String> getConsumerHeaderData() {
        return messagesMap;
    }


}

