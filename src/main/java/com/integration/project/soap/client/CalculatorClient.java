package com.integration.project.soap.client;


import com.integration.project.soap.calculator.models.*;

import lombok.extern.slf4j.Slf4j;
import com.integration.project.soap.constant.ClientConstant;
import com.integration.project.soap.constant.ErrorConstant;
import com.integration.project.soap.fault.AppException;
import com.integration.project.soap.reuqestandresponse.CalculatorRequest;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.Objects;


@Slf4j
public class CalculatorClient extends WebServiceGatewaySupport {

    public int add(CalculatorRequest calculatorRequest) {
        final Add request = createAddRequest(calculatorRequest);

        final AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback(ClientConstant.ADD_SOAP_ACTION_URL));

        if (Objects.isNull(response)) {
            log.error("No response received from the service");
            throw new AppException(ErrorConstant.NO_RESPONSE_RECEIVED_ERROR_MESSAGE);
        }
        log.info("Received add response: {}", response);
        return response.getAddResult();
    }

    public int subtract(CalculatorRequest calculatorRequest) {
        final Subtract request = createSubtractRequest(calculatorRequest);

        final SubtractResponse response = (SubtractResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback(ClientConstant.SUBTRACT_SOAP_ACTION_URL));

        if (Objects.isNull(response)) {
            log.error("No response received from the service");
            throw new AppException(ErrorConstant.NO_RESPONSE_RECEIVED_ERROR_MESSAGE);
        }
        log.info("Received subtract response: {}", response);
        return response.getSubtractResult();
    }

    public int divide(CalculatorRequest calculatorRequest) {
        final Divide request = createDivideRequest(calculatorRequest);

        final DivideResponse response = (DivideResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback(ClientConstant.DIVIDE_SOAP_ACTION_URL));

        if (Objects.isNull(response)) {
            log.error("No response received from the service");
            throw new AppException(ErrorConstant.NO_RESPONSE_RECEIVED_ERROR_MESSAGE);
        }
        log.info("Received divide response: {}", response);
        return response.getDivideResult();
    }

    public int multiply(CalculatorRequest calculatorRequest) {
        final Multiply request = createMultiplyRequest(calculatorRequest);

        final MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback(ClientConstant.MULTIPY_SOAP_ACTION_URL));

        if (Objects.isNull(response)) {
            log.error("No response received from the service");
            throw new AppException(ErrorConstant.NO_RESPONSE_RECEIVED_ERROR_MESSAGE);
        }
        log.info("Received multiply response: {}", response);
        return response.getMultiplyResult();
    }


    private static Add createAddRequest(CalculatorRequest calculatorRequest) {
        final Add request = new Add();
        request.setIntA(calculatorRequest.getIntA());
        request.setIntB(calculatorRequest.getIntB());
        return request;
    }

    private static Subtract createSubtractRequest(CalculatorRequest calculatorRequest) {
        final Subtract request = new Subtract();
        request.setIntA(calculatorRequest.getIntA());
        request.setIntB(calculatorRequest.getIntB());
        return request;
    }

    private static Divide createDivideRequest(CalculatorRequest calculatorRequest) {
        final Divide request = new Divide();
        request.setIntA(calculatorRequest.getIntA());
        request.setIntB(calculatorRequest.getIntB());
        return request;
    }

    private static Multiply createMultiplyRequest(CalculatorRequest calculatorRequest) {
        final Multiply request = new Multiply();
        request.setIntA(calculatorRequest.getIntA());
        request.setIntB(calculatorRequest.getIntB());
        return request;
    }
}
