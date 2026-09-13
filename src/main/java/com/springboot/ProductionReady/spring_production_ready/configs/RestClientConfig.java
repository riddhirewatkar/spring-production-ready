package com.springboot.ProductionReady.spring_production_ready.configs;

import com.springboot.ProductionReady.spring_production_ready.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Value("${employeeService.base.url}")
    private String BASE_URL;
    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, (req, res) -> {
                    System.out.println(new String(res.getBody().readAllBytes()));
                    throw new EmployeeNotFoundException("Employee not found");
                })
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, (req, res) -> {
                    System.out.println(new String(res.getBody().readAllBytes()));
                    throw new EmployeeNotFoundException("Employee not found");
                })
                .build();
    }
}
