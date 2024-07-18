package com.integration.project.soap.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorConstant {
    public static final String NO_RESPONSE_RECEIVED_ERROR_MESSAGE = "No response received from the service";
    public static final String ERROR_OCCURRED_SOAP_SERVICE_MESSAGE = "Error occurred while calling SOAP service";
}
