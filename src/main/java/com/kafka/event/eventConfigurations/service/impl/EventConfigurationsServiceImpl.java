package com.kafka.event.eventConfigurations.service.impl;

import com.kafka.event.eventConfigurations.dao.EventConfigurationDao;
import com.kafka.event.eventConfigurations.model.EventConfiguration;
import com.kafka.event.eventConfigurations.service.EventConfigurationsService;
import com.kafka.event.eventConfigurations.wrapper.EventConfigurationsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Event configurations service.
 */
@Service
public class EventConfigurationsServiceImpl implements EventConfigurationsService {

    @Autowired
    private EventConfigurationDao eventConfigurationDao;

    @Override
    public EventConfiguration createEventConfiguration(EventConfigurationsWrapper eventConfigurationsWrapper) {
        EventConfiguration eventConfiguration = new EventConfiguration();
        // TODO need to add the code here
        return eventConfigurationDao.save(eventConfiguration);
    }

    @Override
    public List<EventConfiguration> findAllEventConfigurations() {
        return eventConfigurationDao.findAll();
    }

    @Override
    public List<EventConfiguration> getAllEventConfigurations(String name, String rule, String parseType, Integer llimit, Integer ulimit) {
        return null;
    }

    @Override
    public EventConfiguration getEventConfigurationsByName(String EventConfigurationName) {
        return eventConfigurationDao.findByName(EventConfigurationName).get(0);
    }

    @Override
    public void deleteEventConfigurations(Integer id) {
        eventConfigurationDao.deleteById(id);

    }

    @Override
    public Long getEventConfigurationsCount(String eventConfigurationName) {
        return Long.valueOf(eventConfigurationDao.findByName(eventConfigurationName).size());
    }

    @Override
    public EventConfiguration getEventConfigurations(Integer id) {
        return eventConfigurationDao.findById(id).get();
    }
}
