package com.integration.project.soap.service;

import com.integration.project.soap.constant.ApplicationConstant;
import com.integration.project.soap.constant.ErrorConstant;
import com.integration.project.soap.fault.AppException;
import com.integration.project.soap.reuqestandresponse.CalculationResponse;
import com.integration.project.soap.reuqestandresponse.CalculatorRequest;
import com.integration.project.soap.client.CalculatorClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {
    private final CalculatorClient calculatorClient;

    @Override
    public CalculationResponse add(CalculatorRequest calculatorRequest) {
        try {
            final int result = calculatorClient.add(calculatorRequest);
            return new CalculationResponse(result, ApplicationConstant.ADD);
        } catch (Exception e) {
            log.error("Error occurred while calling SOAP service::errorDescription={}", e);
            throw new AppException(ErrorConstant.ERROR_OCCURRED_SOAP_SERVICE_MESSAGE, e);
        }
    }

    @Override
    public CalculationResponse subtract(CalculatorRequest calculatorRequest) {
        try {
            final int result = calculatorClient.subtract(calculatorRequest);
            return new CalculationResponse(result, ApplicationConstant.SUBTRACT);
        } catch (Exception e) {
            log.error("Error occurred while calling SOAP service::errorDescription={}", e);
            throw new AppException(ErrorConstant.ERROR_OCCURRED_SOAP_SERVICE_MESSAGE, e);
        }
    }

    @Override
    public CalculationResponse divide(CalculatorRequest calculatorRequest) {
        try {
            final int result = calculatorClient.divide(calculatorRequest);
            return new CalculationResponse(result, ApplicationConstant.DIVIDE);
        } catch (Exception e) {
            log.error("Error occurred while calling SOAP service::errorDescription={}", e);
            throw new AppException(ErrorConstant.ERROR_OCCURRED_SOAP_SERVICE_MESSAGE, e);
        }
    }

    @Override
    public CalculationResponse multiply(CalculatorRequest calculatorRequest) {
        try {
            final int result = calculatorClient.multiply(calculatorRequest);
            return new CalculationResponse(result, ApplicationConstant.MULTIPY);
        } catch (Exception e) {
            log.error("Error occurred while calling SOAP service::errorDescription={}", e);
            throw new AppException(ErrorConstant.ERROR_OCCURRED_SOAP_SERVICE_MESSAGE, e);
        }
    }

}
