package com.kafka.event.eventTemplate.service.impl;

import com.kafka.event.eventTemplate.dao.EventTemplateDao;
import com.kafka.event.eventTemplate.model.EventTemplate;
import com.kafka.event.eventTemplate.service.EventTemplateService;
import com.kafka.event.eventTemplate.wrapper.EventTemplateWapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTemplateServiceImpl implements EventTemplateService {

    private @Autowired EventTemplateDao eventTemplateDao;

    @Override
    public EventTemplate createEventTemplate(EventTemplateWapper eventTemplateWapper) {
        EventTemplate eventTemplate= new EventTemplate();


        return eventTemplateDao.save(eventTemplate);
    }

    @Override
    public EventTemplate getEventTemplateByID(Integer id) {
        return eventTemplateDao.findById(Long.valueOf(id)).get();
    }

    @Override
    public List<EventTemplate> findAllEventTemplate() {
        return eventTemplateDao.findAll();
    }

    @Override
    public EventTemplate getEventTemplateByName(String name) {
        return eventTemplateDao.getEventTemplateByEventName(name);
    }

    @Override
    public String deleteEventTemplate(Integer id) {
         eventTemplateDao.deleteById(Long.valueOf(id));
        return "Success";
    }

}
