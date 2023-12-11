package com.kafka.event.eventTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event_template_paramter")
public class EventTemplateParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="filed")
    private String filed;

    @Column(name="REQUIRED")
    private String required;

    @Column(name="deleted")
    private Boolean deleted;

    @Column(name="type")
    private String type;

    @JoinColumn(name = "event_temlate_id_fk", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private EventTemplate eventTemplateId;



}
