package com.kafka.event.eventTemplate.dao;

import com.kafka.event.eventTemplate.model.EventTemplateParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTemplateParameterDao extends JpaRepository<EventTemplateParameter,Long> {
        EventTemplateParameter getEventTemplateParameterByFiled(String filed);

}
