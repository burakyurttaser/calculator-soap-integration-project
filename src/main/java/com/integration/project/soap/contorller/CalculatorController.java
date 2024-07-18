package com.integration.project.soap.contorller;

import com.integration.project.soap.reuqestandresponse.CalculationResponse;
import com.integration.project.soap.reuqestandresponse.CalculatorRequest;
import com.integration.project.soap.service.CalculatorService;
import com.integration.project.soap.validatations.CalculatorValidator;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final CalculatorValidator calculatorValidator;

    @PostMapping("/add")
    public CalculationResponse add(@Valid @RequestBody CalculatorRequest calculatorRequest) {
        calculatorValidator.isValidInteger(calculatorRequest);
        return calculatorService.add(calculatorRequest);
    }

    @PostMapping("/subtract")
    public CalculationResponse subtract(@Valid @RequestBody CalculatorRequest calculatorRequest) {
        calculatorValidator.isValidInteger(calculatorRequest);
        return calculatorService.subtract(calculatorRequest);
    }


    @PostMapping("/multiply")
    public CalculationResponse multiply(@Valid @RequestBody CalculatorRequest calculatorRequest) {
        calculatorValidator.isValidInteger(calculatorRequest);
        return calculatorService.multiply(calculatorRequest);
    }

    @PostMapping("/divide")
    public CalculationResponse divide(@Valid @RequestBody CalculatorRequest calculatorRequest) {
        calculatorValidator.isValidInteger(calculatorRequest);
        return calculatorService.divide(calculatorRequest);
    }
}
