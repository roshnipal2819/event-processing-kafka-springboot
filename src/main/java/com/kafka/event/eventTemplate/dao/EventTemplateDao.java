package com.kafka.event.eventTemplate.dao;

import com.kafka.event.eventTemplate.model.EventTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTemplateDao extends JpaRepository<EventTemplate,Long> {
    EventTemplate getEventTemplateByEventName(String eventName);


}
