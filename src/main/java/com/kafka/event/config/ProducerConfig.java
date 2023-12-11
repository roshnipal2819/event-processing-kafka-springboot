package com.kafka.event.config;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Producer config.
 */
@Configuration
public class ProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServers;

    /**
     * Gets producer.
     *
     * @return the producer
     */
    @Bean
    public ProducerFactory<String, String> getProducer() {
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
        producerProperties.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProperties.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProperties.put(org.apache.kafka.clients.producer.ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, Boolean.TRUE);
        producerProperties.put(org.apache.kafka.clients.producer.ProducerConfig.ACKS_CONFIG, "all");
        producerProperties.put("retries", 1);
        producerProperties.put("batch.size", 16384);
        producerProperties.put("linger.ms", 1);
        producerProperties.put("buffer.memory", 33554432);
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }

    /**
     * Kafka template kafka template.
     *
     * @return the kafka template
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(getProducer());
    }

}