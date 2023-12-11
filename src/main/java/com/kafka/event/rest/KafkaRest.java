package com.kafka.event.rest;

import com.kafka.event.service.KafkaConsumer;
import com.kafka.event.service.KafkaProducer;
import com.kafka.event.task.CSVReadTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Kafka controller.
 */
@RestController
public class KafkaRest {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaProducer producer;

    @Autowired
    private CSVReadTask task;

    /**
     * Send.
     *
     * @param data
     *         the data
     * @param topicName
     *         the topic name
     */
    @RequestMapping(value="/send/{topicName}", method= RequestMethod.POST)
    public void send(@RequestBody String data, @RequestParam  String topicName) {
        producer.produce(topicName,data);
    }

    /**
     * Receive list.
     *
     * @return the list
     */
    @RequestMapping(value="/receive", method=RequestMethod.GET)
    public List<String> receive() {
        return consumer.messages;
    }

    /**
     * Execute.
     *
     * @param topicName
     *         the topic name
     */
    @RequestMapping(value="/execute/{topicName}", method=RequestMethod.GET)
    public void execute(@PathVariable  String topicName) {
         task.execute(topicName);
    }
}
