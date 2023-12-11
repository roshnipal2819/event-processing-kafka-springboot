package com.kafka.event.eventTemplate.service.impl;

import com.kafka.event.eventTemplate.dao.EventTemplateParameterDao;
import com.kafka.event.eventTemplate.model.EventTemplateParameter;
import com.kafka.event.eventTemplate.service.EvenetTemplateParamter;
import com.kafka.event.eventTemplate.wrapper.EvenetTemplateParamterWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenetTemplateParamterImpl implements EvenetTemplateParamter {

    private @Autowired EventTemplateParameterDao eventTemplateParameterDao;

    @Override
    public EventTemplateParameter createEventTemplateParameter(EvenetTemplateParamterWrapper evenetTemplateWrapper) {
        EventTemplateParameter eventTemplateParameter = new EventTemplateParameter();
        return eventTemplateParameterDao.save(eventTemplateParameter);
    }

    @Override
    public EventTemplateParameter getEventTemplateParameter(Integer id) {
        return eventTemplateParameterDao.findById(Long.valueOf(id)).get();
    }

    @Override
    public List<EventTemplateParameter> findAllEventTemplateParameter() {
        return eventTemplateParameterDao.findAll();
    }

    @Override
    public String deleteEventTemplateParameter(Integer id) {
        eventTemplateParameterDao.deleteById(Long.valueOf(id));
        return "Success";
    }

    @Override
    public EventTemplateParameter getEventTemplateParameterByID(Integer id) {
        return eventTemplateParameterDao.findById(Long.valueOf(id)).get();
    }

    @Override
    public EventTemplateParameter getEventTemplateParameterByName(String name) {
        return eventTemplateParameterDao.getEventTemplateParameterByFiled(name);
    }
}
