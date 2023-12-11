package com.kafka.event.eventTemplate.service;

import com.kafka.event.eventTemplate.model.EventTemplateParameter;
import com.kafka.event.eventTemplate.wrapper.EvenetTemplateParamterWrapper;

import java.util.List;

public interface EvenetTemplateParamter {

    EventTemplateParameter createEventTemplateParameter(EvenetTemplateParamterWrapper evenetTemplateWrapper);

    EventTemplateParameter getEventTemplateParameter(Integer id);

    List<EventTemplateParameter> findAllEventTemplateParameter();

    String deleteEventTemplateParameter(Integer id);

    EventTemplateParameter getEventTemplateParameterByID(Integer id);

    EventTemplateParameter getEventTemplateParameterByName(String name);
}
