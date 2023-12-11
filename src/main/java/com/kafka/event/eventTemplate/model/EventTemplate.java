package com.kafka.event.eventTemplate.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table(name="event_template")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class EventTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="event_name")
    private String eventName;

    @Column(name ="event_type")
    private String eventType;

    @Column(name ="deleted")
    private Boolean deleted;

    @Column(name ="name")
    private String name;



}
