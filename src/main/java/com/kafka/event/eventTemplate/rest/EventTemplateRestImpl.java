package com.kafka.event.eventTemplate.rest;

import com.kafka.event.eventTemplate.model.EventTemplate;
import com.kafka.event.eventTemplate.model.EventTemplateParameter;
import com.kafka.event.eventTemplate.service.EventTemplateService;
import com.kafka.event.eventTemplate.wrapper.EventTemplateWapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "event-template")
public class EventTemplateRestImpl  implements EventTemplateRest{

    @Autowired EventTemplateService eventTemplateService;

    @Override
    public EventTemplate createEventTemplate(EventTemplateWapper eventTemplateWapper) {
        return eventTemplateService.createEventTemplate(eventTemplateWapper);
    }

    @Override
    public EventTemplate getEventTemplateByID(Integer id) {
        return eventTemplateService.getEventTemplateByID(id);
    }

    @Override
    public List<EventTemplate> findAllEventTemplate() {
        return eventTemplateService.findAllEventTemplate();
    }

    @Override
    public EventTemplate getEventTemplateByName(String name) {
        return eventTemplateService.getEventTemplateByName(name);
    }

    @Override
    public String deleteEventTemplate(Integer id) {
        return eventTemplateService.deleteEventTemplate(id);
    }
}
