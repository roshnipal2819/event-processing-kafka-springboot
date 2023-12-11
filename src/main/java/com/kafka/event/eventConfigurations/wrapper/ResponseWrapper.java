package com.kafka.event.eventConfigurations.wrapper;


import com.kafka.event.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Response wrapper.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper {
    private String responseBody;
    private Integer statusCode;
    private Status status;
    private String identifier;
    private String ruleName;
    private String nextRuleName;
    private String payload;
    private String entityType;
    private Integer callBackCounter;

    /**
     * Instantiates a new Response wrapper.
     *
     * @param responseBody
     *         the response body
     * @param statusCode
     *         the status code
     */
    public ResponseWrapper(String responseBody, Integer statusCode) {
        this.responseBody = responseBody;
        this.statusCode = statusCode;
    }

    /**
     * Instantiates a new Response wrapper.
     *
     * @param responseBody
     *         the response body
     * @param status
     *         the status
     */
    public ResponseWrapper(String responseBody, Status status) {
        this.responseBody = responseBody;
        this.status = status;
    }

    /**
     * Instantiates a new Response wrapper.
     *
     * @param moduleName
     *         the module name
     * @param responseBody
     *         the response body
     * @param status
     *         the status
     */
    public ResponseWrapper(String moduleName, String responseBody, Status status) {
        this.responseBody = responseBody;
        this.status = status;
    }

    /**
     * Instantiates a new Response wrapper.
     *
     * @param responseBody
     *         the response body
     * @param status
     *         the status
     * @param ruleName
     *         the rule name
     */
    public ResponseWrapper(String responseBody, Status status, String ruleName) {
        this.responseBody = responseBody;
        this.status = status;
        this.ruleName = ruleName;
    }

    /**
     * Instantiates a new Response wrapper.
     *
     * @param responseBody
     *         the response body
     * @param statusCode
     *         the status code
     * @param status
     *         the status
     */
    public ResponseWrapper(String responseBody, Integer statusCode, Status status) {
        this.responseBody = responseBody;
        this.status = status;
        this.statusCode = statusCode;
    }

    /**
     * Instantiates a new Response wrapper.
     *
     * @param responseBody
     *         the response body
     */
    public ResponseWrapper(String responseBody) {
        this.responseBody = responseBody;
    }

    /**
     * Instantiates a new Response wrapper.
     *
     * @param status
     *         the status
     */
    public ResponseWrapper(Status status) {
        this.status = status;
    }

    /**
     * Instantiates a new Response wrapper.
     *
     * @param responseBody
     *         the response body
     * @param status
     *         the status
     */
    public ResponseWrapper(String responseBody, String status) {
        this.responseBody = responseBody;
        this.status = Status.valueOf(status);
    }
}
