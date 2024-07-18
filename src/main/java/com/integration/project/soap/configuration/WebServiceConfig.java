package com.integration.project.soap.configuration;

import com.integration.project.soap.client.CalculatorClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class WebServiceConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.integration.project.soap.calculator.models");
        return marshaller;
    }

    @Bean
    public CalculatorClient calClient(Jaxb2Marshaller marshaller) {
        final CalculatorClient calClient = new CalculatorClient();
        calClient.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        calClient.setMarshaller(marshaller);
        calClient.setUnmarshaller(marshaller);
        return calClient;
    }
}
