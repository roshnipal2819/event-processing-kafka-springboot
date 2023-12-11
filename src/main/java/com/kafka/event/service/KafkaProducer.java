package com.kafka.event.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Kafka producer.
 */
@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Produce.
     *
     * @param topic
     *         the topic
     * @param message
     *         the message
     */
    public void produce(String topic,String message) {
        kafkaTemplate.send(topic, message);
    }

    /**
     * Produce reords.
     *
     * @param topic
     *         the topic
     * @param message
     *         the message
     */
    public void produceReords(String topic,ProducerRecord message) {
        kafkaTemplate.send(message);
    }

}