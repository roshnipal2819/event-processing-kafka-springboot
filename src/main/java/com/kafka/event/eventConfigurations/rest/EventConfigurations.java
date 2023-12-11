package com.kafka.event.eventConfigurations.rest;

import com.kafka.event.eventConfigurations.model.EventConfiguration;
import com.kafka.event.eventConfigurations.wrapper.EventConfigurationsWrapper;
import com.kafka.event.eventConfigurations.wrapper.ResponseWrapper;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The interface Event configurations.
 */
@ResponseBody
@Api(tags = {"API's Related to EventConfigurations"})
@SwaggerDefinition(tags = {@Tag(name = "EventConfigurationss", description = "REST APIs related to Kafka Events ")})
public interface EventConfigurations {

    /**
     * Create event configurations event configuration.
     *
     * @param eventConfigurationsWrapper
     *         the event configurations wrapper
     *
     * @return the event configuration
     */
    @PostMapping(value = "/create")
    @ApiOperation(value = "Create EventConfigurations", response = EventConfiguration.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventConfigurations_DETAILS_CREATE", description = "Create EventConfigurations")})})
    EventConfiguration createEventConfigurations(@RequestBody EventConfigurationsWrapper eventConfigurationsWrapper);


    /**
     * Gets event configurations.
     *
     * @param id
     *         the id
     *
     * @return the event configurations
     */
    @GetMapping(value = "{id}")
    @ApiOperation(value = "get EventConfigurations Details", response = List.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventConfigurations_DETAILS_GET_EventConfigurations", description = "get EventConfigurations Details")})})
    EventConfiguration getEventConfigurations(@ApiParam(value = "id") @PathVariable("id") Integer id);


    /**
     * Find all event configurations list.
     *
     * @return the list
     */
    @GetMapping(value = "findAll")
    @ApiOperation(value = "Find All EventConfigurations", response = List.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventConfigurations_DETAILS_FIND_ALL", description = "Find All EventConfigurations")})})
    List<EventConfiguration> findAllEventConfigurations();

    /**
     * Gets all event configurations.
     *
     * @param name
     *         the name
     * @param eventConfigurations
     *         the event configurations
     * @param parseType
     *         the parse type
     * @param llimit
     *         the llimit
     * @param ulimit
     *         the ulimit
     *
     * @return the all event configurations
     */
    @GetMapping(value = "get")
    @ApiOperation(value = "Get All EventConfigurations", response = List.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventConfigurations_DETAILS_FIND_ALL", description = "get All EventConfigurations")})})
    List<EventConfiguration> getAllEventConfigurations(@ApiParam(value = "name") @RequestParam(required = false, name = "name") String name, @ApiParam(value = "eventConfigurations") @RequestParam(required = false, name = "EventConfigurations") String eventConfigurations, @ApiParam(value = "parseType") @RequestParam(required = false, name = "parseType") String parseType, @ApiParam(value = "llimit") @RequestParam(name = "llimit") Integer llimit, @ApiParam(value = "ulimit") @RequestParam(name = "ulimit") Integer ulimit);

    /**
     * Gets event configurations by name.
     *
     * @param eventConfigurationsName
     *         Configured EventConfigurations name
     *
     * @return EventConfiguration event configurations by name
     */
    @GetMapping(value = "get/{eventConfigurations}")
    @ApiOperation(value = "get EventConfigurations details by EventConfigurations name ", response = EventConfiguration.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventConfigurations_DETAILS_BY_EventConfigurations_NAME", description = "get EventConfigurations details by EventConfigurations name")})})
    EventConfiguration getEventConfigurationsByName(@ApiParam(value = "eventConfigurations") @PathVariable(name = "eventConfigurations") String eventConfigurationsName);

    /**
     * Delete event configurations details response wrapper.
     *
     * @param id
     *         the id
     *
     * @return the response wrapper
     */
    @PostMapping(value = "/delete/{id}")
    @ApiOperation(value = "delete EventConfigurations details by id", response = Void.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "DELETE_EVENT_CONFIGURATION_BY_EventConfigurations_ID", description = "delete EventConfigurations details by EventConfigurations id")})})
    ResponseWrapper deleteEventConfigurationsDetails(@ApiParam(value = "id") @PathVariable(required = true) Integer id);

    /**
     * Gets event configurations details count.
     *
     * @param name
     *         the name
     *
     * @return the event configurations details count
     */
    @GetMapping(path = "/count")
    @ApiOperation(value = "count", response = Long.class)
    Long getEventConfigurationsDetailsCount(@ApiParam(value = "name") @RequestParam(required = false, name = "name") String name);
}
