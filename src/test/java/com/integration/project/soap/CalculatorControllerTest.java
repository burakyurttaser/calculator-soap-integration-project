package com.integration.project.soap;

import com.integration.project.soap.contorller.CalculatorController;
import com.integration.project.soap.reuqestandresponse.CalculationResponse;
import com.integration.project.soap.reuqestandresponse.CalculatorRequest;
import com.integration.project.soap.service.CalculatorService;
import com.integration.project.soap.validatations.CalculatorValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Disabled
class CalculatorControllerTest {

    @Mock
    private CalculatorService calculatorService;

    @Mock
    private CalculatorValidator calculatorValidator;

    @InjectMocks
    private CalculatorController calculatorController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void addShouldReturnCorrectResponse() {
        final CalculatorRequest request = new CalculatorRequest(5, 3);
        final CalculationResponse expectedResponse = new CalculationResponse(8, "add");

        when(calculatorService.add(request)).thenReturn(expectedResponse);

        final CalculationResponse actualResponse = calculatorController.add(request);

        assertEquals(expectedResponse, actualResponse);
        verify(calculatorValidator).isValidInteger(request);
    }

    @Test
    void subtractShouldReturnCorrectResponse() {
        final CalculatorRequest request = new CalculatorRequest(5, 3);
        final CalculationResponse expectedResponse = new CalculationResponse(2, "subtract");

        when(calculatorService.subtract(request)).thenReturn(expectedResponse);

        final CalculationResponse actualResponse = calculatorController.subtract(request);

        assertEquals(expectedResponse, actualResponse);
        verify(calculatorValidator).isValidInteger(request);
    }

    @Test
    void multiplyShouldReturnCorrectResponse() {
        final CalculatorRequest request = new CalculatorRequest(5, 3);
        final CalculationResponse expectedResponse = new CalculationResponse(15, "multiply");

        when(calculatorService.multiply(request)).thenReturn(expectedResponse);

        final CalculationResponse actualResponse = calculatorController.multiply(request);

        assertEquals(expectedResponse, actualResponse);
        verify(calculatorValidator).isValidInteger(request);
    }

    @Test
    void divideShouldReturnCorrectResponse() {
        final CalculatorRequest request = new CalculatorRequest(5, 5);
        final CalculationResponse expectedResponse = new CalculationResponse(1, "divide");

        when(calculatorService.divide(request)).thenReturn(expectedResponse);

        final CalculationResponse actualResponse = calculatorController.divide(request);

        assertEquals(expectedResponse, actualResponse);
        verify(calculatorValidator).isValidInteger(request);
    }
}
