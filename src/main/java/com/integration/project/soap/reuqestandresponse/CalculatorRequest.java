package com.integration.project.soap.reuqestandresponse;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CalculatorRequest {
    @NotNull
    private int intA;
    @NotNull
    private int intB;
}
