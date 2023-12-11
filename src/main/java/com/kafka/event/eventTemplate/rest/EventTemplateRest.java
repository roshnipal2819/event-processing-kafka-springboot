package com.kafka.event.eventTemplate.rest;

import com.kafka.event.eventConfigurations.model.EventConfiguration;
import com.kafka.event.eventTemplate.model.EventTemplate;
import com.kafka.event.eventTemplate.model.EventTemplateParameter;
import com.kafka.event.eventTemplate.wrapper.EvenetTemplateParamterWrapper;
import com.kafka.event.eventTemplate.wrapper.EventTemplateWapper;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@Api(tags = {"API's Related to EventTemplateRest"})
@SwaggerDefinition(tags = {@Tag(name = "EventTemplateRest", description = "REST APIs related to Kafka Events ")})
public interface EventTemplateRest {

    @PostMapping(value = "/create")
    @ApiOperation(value = "Create EventTemplateRest", response = EventConfiguration.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventTemplate_DETAILS_CREATE", description = "Create EventConfigurations")})})
    EventTemplate createEventTemplate(@RequestBody EventTemplateWapper eventTemplateWapper);

    @GetMapping(value = "{id}")
    @ApiOperation(value = "get EventTemplate Details", response = List.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventTemplate_DETAILS_GET_EventConfigurations", description = "get EventConfigurations Details")})})
    EventTemplate getEventTemplateByID(@ApiParam(value = "id") @PathVariable("id") Integer id);

    @GetMapping(value = "findAll")
    @ApiOperation(value = "Find All EventTemplateRest", response = List.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventTemplate_DETAILS_FIND_ALL", description = "Find All EventConfigurations")})})
    List<EventTemplate> findAllEventTemplate();

    @GetMapping(value = "get/{name}")
    @ApiOperation(value = "get EventTemplateRest details by EventTemplateRest name ", response = EventConfiguration.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventTemplate_DETAILS_BY_EventTemplate_NAME", description = "get EventConfigurations details by EventConfigurations name")})})
    EventTemplate getEventTemplateByName(@ApiParam(value = "name") @PathVariable(name = "name") String name);

    @PostMapping(value = "/delete/{id}")
    @ApiOperation(value = "delete EventTemplateRest details by id", response = Void.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "DELETE_EVENT_CONFIGURATION_BY_EventTemplate_ID", description = "delete EventConfigurations details by EventConfigurations id")})})
    String deleteEventTemplate(@ApiParam(value = "id") @PathVariable(required = true) Integer id);

}

