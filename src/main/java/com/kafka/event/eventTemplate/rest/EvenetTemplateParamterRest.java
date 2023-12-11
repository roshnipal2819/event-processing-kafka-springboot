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
@Api(tags = {"API's Related to EvenetTemplateRest"})
@SwaggerDefinition(tags = {@Tag(name = "EvenetTemplateRest", description = "REST APIs related to Kafka Events ")})
public interface EvenetTemplateParamterRest {

        @PostMapping(value = "/create")
        @ApiOperation(value = "Create EventTemplateParameter", response = EventConfiguration.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventTemplateParameter_DETAILS_CREATE", description = "Create EventConfigurations")})})
        EventTemplateParameter createEventTemplateParameter(@RequestBody EvenetTemplateParamterWrapper evenetTemplateParamterWrapper);

        @GetMapping(value = "{id}")
        @ApiOperation(value = "get EventTemplateParameter Details", response = List.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventTemplateParameter_DETAILS_GET_EventConfigurations", description = "get EventConfigurations Details")})})
        EventTemplateParameter getEventTemplateParameterByID(@ApiParam(value = "id") @PathVariable("id") Integer id);

        @GetMapping(value = "findAll")
        @ApiOperation(value = "Find All EventTemplateParameter", response = List.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventTemplateParameter_DETAILS_FIND_ALL", description = "Find All EventConfigurations")})})
        List<EventTemplateParameter> findAllEventTemplateParameter();

        @GetMapping(value = "get/{name}")
        @ApiOperation(value = "get EventTemplateParameter details by EventTemplateParameter name ", response = EventConfiguration.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "ROLE_API_EventTemplateParameter_DETAILS_BY_EventConfigurations_NAME", description = "get EventConfigurations details by EventConfigurations name")})})
        EventTemplateParameter getEventTemplateParameterByName(@ApiParam(value = "name") @PathVariable(name = "name") String name);

        @PostMapping(value = "/delete/{id}")
        @ApiOperation(value = "delete EventTemplateParameter details by id", response = Void.class, authorizations = {@Authorization(value = "default", scopes = {@AuthorizationScope(scope = "DELETE_EVENT_CONFIGURATION_BY_EventTemplateParameter_ID", description = "delete EventConfigurations details by EventConfigurations id")})})
        String deleteEventTemplateParameter(@ApiParam(value = "id") @PathVariable(required = true) Integer id);

}



