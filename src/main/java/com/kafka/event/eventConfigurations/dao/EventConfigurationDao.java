package com.kafka.event.eventConfigurations.dao;

import com.kafka.event.eventConfigurations.model.EventConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * The interface Event configuration dao.
 */
@Repository
public interface EventConfigurationDao extends JpaRepository<EventConfiguration, Integer> {
    List<EventConfiguration> findByName(String eventConfigurationName);
}
