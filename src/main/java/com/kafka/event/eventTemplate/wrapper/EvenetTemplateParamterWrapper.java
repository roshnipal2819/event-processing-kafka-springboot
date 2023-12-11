package com.kafka.event.eventTemplate.wrapper;

import com.kafka.event.eventTemplate.model.EventTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvenetTemplateParamterWrapper {


    private Long id;
    private String filed;
    private String required;
    private Boolean deleted;
    private String type;
    private Long eventTemplateId;
}
