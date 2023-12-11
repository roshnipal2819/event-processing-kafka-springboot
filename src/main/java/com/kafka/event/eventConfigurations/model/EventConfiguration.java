package com.kafka.event.eventConfigurations.model;

import lombok.*;

import javax.persistence.*;

/**
 * The type Event configuration.
 */
@Entity
@Table(name = "EVENT_CONFIGURATION")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EVENT_CONFIGURATION")
    private String eventConfiguration;

    @Column(name = "ACTION")
    private String action;

    @Enumerated(EnumType.STRING)
    @Basic
    @Column(name = "PARSE_TYPE")
    private ParseType parseType;

    @Column(name = "DELETED")
    private boolean isDeleted;

    @Column(name = "SCHEMA_VALIDATION")
    private String schemaValidation;


    /**
     * The enum Parse type.
     */
    public enum ParseType {
        /**
         * Http parse type.
         */
        HTTP,
        /**
         * Feign client parse type.
         */
        FEIGN_CLIENT,
        /**
         * Service call parse type.
         */
        SERVICE_CALL
    }
}
