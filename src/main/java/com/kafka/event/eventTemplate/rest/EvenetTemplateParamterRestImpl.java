package com.kafka.event.eventTemplate.rest;

import com.kafka.event.eventTemplate.model.EventTemplateParameter;
import com.kafka.event.eventTemplate.service.EvenetTemplateParamter;
import com.kafka.event.eventTemplate.wrapper.EvenetTemplateParamterWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "event-template-paramter")
public class EvenetTemplateParamterRestImpl implements EvenetTemplateParamterRest {

    private @Autowired EvenetTemplateParamter eventTemplateService;

    @Override
    public EventTemplateParameter createEventTemplateParameter(EvenetTemplateParamterWrapper evenetTemplateWrapper) {
        return eventTemplateService.createEventTemplateParameter(evenetTemplateWrapper);
    }

    @Override
    public EventTemplateParameter getEventTemplateParameterByID(Integer id) {
        return eventTemplateService.getEventTemplateParameterByID(id);
    }

    @Override
    public List<EventTemplateParameter> findAllEventTemplateParameter() {
        return eventTemplateService.findAllEventTemplateParameter();
    }

    @Override
    public EventTemplateParameter getEventTemplateParameterByName(String name) {
        return eventTemplateService.getEventTemplateParameterByName(name);
    }

    @Override
    public String deleteEventTemplateParameter(Integer id) {
        return eventTemplateService.deleteEventTemplateParameter(id);
    }
}
