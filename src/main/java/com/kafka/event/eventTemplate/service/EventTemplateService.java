package com.kafka.event.eventTemplate.service;


import com.kafka.event.eventTemplate.model.EventTemplate;
import com.kafka.event.eventTemplate.wrapper.EventTemplateWapper;

import java.util.List;

public interface EventTemplateService {
    EventTemplate createEventTemplate(EventTemplateWapper eventTemplateWapper);

    EventTemplate getEventTemplateByID(Integer id);

    List<EventTemplate> findAllEventTemplate();

    EventTemplate getEventTemplateByName(String name);

    String deleteEventTemplate(Integer id);
}
