package com.kafka.event.eventConfigurations.service;

import com.kafka.event.eventConfigurations.model.EventConfiguration;
import com.kafka.event.eventConfigurations.wrapper.EventConfigurationsWrapper;

import java.util.List;

/**
 * The interface Event configurations service.
 */
public interface EventConfigurationsService {
    /**
     * Create event configuration event configuration.
     *
     * @param eventConfigurationsWrapper
     *         the eventConfigurations wrapper
     *
     * @return the event configuration
     */
    EventConfiguration createEventConfiguration(EventConfigurationsWrapper eventConfigurationsWrapper);

    /**
     * Find all event configurations list.
     *
     * @return the list
     */
    List<EventConfiguration> findAllEventConfigurations();

    /**
     * Gets all event configurations.
     *
     * @param name
     *         the name
     * @param eventConfigurations
     *         the eventConfigurations
     * @param parseType
     *         the parse type
     * @param llimit
     *         the llimit
     * @param ulimit
     *         the ulimit
     *
     * @return the all event configurations
     */
    List<EventConfiguration> getAllEventConfigurations(String name, String eventConfigurations, String parseType, Integer llimit, Integer ulimit);

    /**
     * Gets event configurations by name.
     *
     * @param eventConfigurations
     *         the eventConfigurations name
     *
     * @return the event configurations by name
     */
    EventConfiguration getEventConfigurationsByName(String eventConfigurationsName);

    /**
     * Delete event configurations.
     *
     * @param id
     *         the id
     */
    void deleteEventConfigurations(Integer id);

    /**
     * Gets event configurations count.
     *
     * @param name
     *         the name
     *
     * @return the event configurations count
     */
    Long getEventConfigurationsCount(String name);

    /**
     * Gets event configurations.
     *
     * @param id
     *         the id
     *
     * @return the event configurations
     */
    EventConfiguration getEventConfigurations(Integer id);
}
