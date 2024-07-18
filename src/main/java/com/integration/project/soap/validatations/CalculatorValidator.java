package com.integration.project.soap.validatations;

import com.integration.project.soap.reuqestandresponse.CalculatorRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CalculatorValidator {
    public static boolean isValidInteger(CalculatorRequest calculatorRequest) {
        try {
            Integer.parseInt(String.valueOf(calculatorRequest.getIntA()));
            Integer.parseInt(String.valueOf(calculatorRequest.getIntB()));
            return true;
        } catch (NumberFormatException e) {
            log.error("Number format exception::::errorDescription={}", e);
            throw new NumberFormatException(calculatorRequest.toString());
        }
    }
}
