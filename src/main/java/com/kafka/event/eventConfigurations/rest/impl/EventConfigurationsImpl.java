package com.kafka.event.eventConfigurations.rest.impl;


import com.kafka.event.eventConfigurations.model.EventConfiguration;
import com.kafka.event.eventConfigurations.rest.EventConfigurations;
import com.kafka.event.eventConfigurations.service.EventConfigurationsService;
import com.kafka.event.eventConfigurations.wrapper.EventConfigurationsWrapper;
import com.kafka.event.eventConfigurations.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.kafka.event.status.Status.SUCCESS;


/**
 * The type Event configurations.
 */
@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "eventConfigurations")
public class EventConfigurationsImpl implements EventConfigurations {

    @Autowired
    private EventConfigurationsService eventConfigurationsService;

    @Override
    public EventConfiguration createEventConfigurations(EventConfigurationsWrapper eventConfigurationsWrapper) {
        log.trace("Going to createeventConfigurations having eventConfigurationsWrapper : {}", eventConfigurationsWrapper);
        return eventConfigurationsService.createEventConfiguration(eventConfigurationsWrapper);
    }


    @Override
    public List<EventConfiguration> getAllEventConfigurations(String name, String eventConfigurations, String parseType, Integer llimit, Integer ulimit) {
        log.trace("Going to getAllEventConfigurationss");
        return eventConfigurationsService.getAllEventConfigurations(name, eventConfigurations, parseType, llimit, ulimit);
    }


    @Override
    public EventConfiguration getEventConfigurationsByName(String eventConfigurationsName) {
        log.trace("Inside geteventConfigurationsByName having getEventConfigurationsByName : {} ", eventConfigurationsName);
        return eventConfigurationsService.getEventConfigurationsByName(eventConfigurationsName);
    }


    @Override
    public ResponseWrapper deleteEventConfigurationsDetails(Integer id) {
        log.trace("Going to delete EventConfiguration having Id: {}", id);
        eventConfigurationsService.deleteEventConfigurations(id);
        return new ResponseWrapper("SOFT DELETE SUCCESSFULLY", SUCCESS);
    }

    @Override
    public Long getEventConfigurationsDetailsCount(String name) {
        return eventConfigurationsService.getEventConfigurationsCount(name);
    }

    @Override

    public EventConfiguration getEventConfigurations(Integer id) {
        return eventConfigurationsService.getEventConfigurations(id);
    }

    @Override
    public List<EventConfiguration> findAllEventConfigurations() {
        return eventConfigurationsService.findAllEventConfigurations();
    }
}
