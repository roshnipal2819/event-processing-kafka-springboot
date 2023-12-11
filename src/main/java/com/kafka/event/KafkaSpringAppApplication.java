package com.kafka.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Kafka spring app application.
 */
@SpringBootApplication
public class KafkaSpringAppApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args
	 *         the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringAppApplication.class, args);
	}

}
