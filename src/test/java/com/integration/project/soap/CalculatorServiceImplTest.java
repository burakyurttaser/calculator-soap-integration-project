package com.integration.project.soap;

import com.integration.project.soap.client.CalculatorClient;
import com.integration.project.soap.constant.ApplicationConstant;
import com.integration.project.soap.constant.ErrorConstant;
import com.integration.project.soap.fault.AppException;
import com.integration.project.soap.reuqestandresponse.CalculationResponse;
import com.integration.project.soap.reuqestandresponse.CalculatorRequest;
import com.integration.project.soap.service.CalculatorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Disabled
class CalculatorServiceImplTest {

    @Mock
    private CalculatorClient calculatorClient;

    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addShouldReturnCorrectResult() {
        final CalculatorRequest request = new CalculatorRequest(5, 3);
        when(calculatorClient.add(request)).thenReturn(8);

        final CalculationResponse response = calculatorService.add(request);

        assertEquals(8, response.getResult());
        assertEquals(ApplicationConstant.ADD, response.getOperation());
    }

    @Test
    void subtractShouldReturnCorrectResult() {
        final CalculatorRequest request = new CalculatorRequest(5, 3);
        when(calculatorClient.subtract(request)).thenReturn(2);

        final CalculationResponse response = calculatorService.subtract(request);

        assertEquals(2, response.getResult());
        assertEquals(ApplicationConstant.SUBTRACT, response.getOperation());
    }

    @Test
    void divideShouldReturnCorrectResult() {
        final CalculatorRequest request = new CalculatorRequest(10, 5);
        when(calculatorClient.divide(request)).thenReturn(2);

        final CalculationResponse response = calculatorService.divide(request);

        assertEquals(2, response.getResult());
        assertEquals(ApplicationConstant.DIVIDE, response.getOperation());
    }

    @Test
    void multiplyShouldReturnCorrectResult() {
        final CalculatorRequest request = new CalculatorRequest(10, 5);
        when(calculatorClient.multiply(request)).thenReturn(50);

        final CalculationResponse response = calculatorService.multiply(request);

        assertEquals(50, response.getResult());
        assertEquals(ApplicationConstant.MULTIPY, response.getOperation());
    }

    @Test
    @Disabled
    void addShouldThrowAppExceptionWhenClientThrowsException() {
        final CalculatorRequest request = new CalculatorRequest(5, 3);
        when(calculatorClient.add(request)).thenThrow(new RuntimeException("Error occurred while calling SOAP service"));

        final AppException exception = assertThrows(AppException.class, () -> calculatorService.add(request));
        assertEquals(ErrorConstant.ERROR_OCCURRED_SOAP_SERVICE_MESSAGE, exception.getMessage());
    }
}
