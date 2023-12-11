package com.kafka.event.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Consumer config.
 */
@EnableKafka
@Configuration
public class ConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServers;

    @Value("${spring.kafka.groupId}")
    private String groupId;

    /**
     * Gets consumer.
     *
     * @return the consumer
     */
    @Bean
    public ConsumerFactory<String, String> getConsumer() {
        Map<String, Object> configProp = new HashMap<>();
        configProp.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
        configProp.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configProp.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProp.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        configProp.put("zookeeper.session.timeout.ms", "6000");
        configProp.put("zookeeper.sync.time.ms","2000");
        configProp.put("auto.commit.enable", "false");
        configProp.put("auto.commit.interval.ms", "1000");
        configProp.put("consumer.timeout.ms", "-1");
        configProp.put("max.poll.records", "1");

        return new DefaultKafkaConsumerFactory<>(configProp);
    }

    /**
     * Kafka listener container factory concurrent kafka listener container factory.
     *
     * @return the concurrent kafka listener container factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(getConsumer());
        return factory;
    }

}
