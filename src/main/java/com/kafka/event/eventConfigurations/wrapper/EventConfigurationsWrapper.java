package com.kafka.event.eventConfigurations.wrapper;


import com.kafka.event.eventConfigurations.model.EventConfiguration;
import lombok.Data;

/**
 * The type Event configurations wrapper.
 */
@Data
public class EventConfigurationsWrapper {

    private String rule;

    private String action;

    private EventConfiguration.ParseType parseType;

    private Boolean isDeleted;

    private String name;

    private String schemaValidation;
}