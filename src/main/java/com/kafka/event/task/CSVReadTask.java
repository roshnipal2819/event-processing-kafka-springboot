package com.kafka.event.task;

import com.kafka.event.service.KafkaConsumer;
import com.kafka.event.service.KafkaProducer;
import com.opencsv.CSVWriter;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Csv read task.
 */
@Service
public class CSVReadTask {

    @Autowired
    private KafkaProducer producer;

    @Autowired
    private KafkaConsumer consumer;

    /**
     * Execute.
     *
     * @param topic
     *         the topic
     */
    public void execute(String topic) {

            try  {
                // Read the files
                 List<String> lines = Files.readAllLines(Paths.get("src/main/resources/employees.csv"));

                 //Produce on kafka
                lines.stream().skip(1).forEach(l -> {
                        ProducerRecord producerRecord = new ProducerRecord<>(topic,l);
                        producerRecord.headers().add("csvFileHeaders",lines.get(0).getBytes());
                        producer.produceReords(topic, producerRecord);
                    }
                );

                 // Read from the kafka
                List<String> consumerData = consumer.getConsumerData();

                System.out.println(consumer.getConsumerHeaderData().toString());
                File file = new File("src/main/resources/employees_new_updated.csv");
                FileWriter outputfile = new FileWriter(file);

                // create CSVWriter object filewriter object as parameter
                CSVWriter writer = new CSVWriter(outputfile);

                //Store it into File
                List<String[]> data = new LinkedList<>();
                data.add(lines.get(0).split(","));
                consumerData.stream().forEach( d -> data.add(d.split(",")));
                writer.writeAll(data);
                writer.close();

                // pending task to add the in hdfs in pending


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


