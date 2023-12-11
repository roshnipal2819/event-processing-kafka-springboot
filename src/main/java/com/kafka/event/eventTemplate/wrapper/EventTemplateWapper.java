package com.kafka.event.eventTemplate.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventTemplateWapper {


    private Long id;
    private String eventName;
    private String eventType;
    private Boolean deleted;
    private String name;
}
