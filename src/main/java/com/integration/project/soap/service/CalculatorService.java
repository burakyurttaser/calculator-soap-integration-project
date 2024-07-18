package com.integration.project.soap.service;


import com.integration.project.soap.reuqestandresponse.CalculationResponse;
import com.integration.project.soap.reuqestandresponse.CalculatorRequest;

public interface CalculatorService {
    CalculationResponse add(CalculatorRequest calculatorRequest);

    CalculationResponse subtract(CalculatorRequest calculatorRequest);

    CalculationResponse divide(CalculatorRequest calculatorRequest);

    CalculationResponse multiply(CalculatorRequest calculatorRequest);

}
