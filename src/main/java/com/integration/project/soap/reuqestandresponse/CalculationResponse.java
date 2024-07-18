package com.integration.project.soap.reuqestandresponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CalculationResponse {
    private int result;
    private String operation;
}
