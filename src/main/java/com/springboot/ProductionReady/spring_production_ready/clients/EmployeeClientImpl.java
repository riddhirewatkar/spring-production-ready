package com.springboot.ProductionReady.spring_production_ready.clients;

import com.springboot.ProductionReady.spring_production_ready.advices.ApiResponse;
import com.springboot.ProductionReady.spring_production_ready.clients.impl.EmployeeClient;
import com.springboot.ProductionReady.spring_production_ready.configs.RestClientConfig;
import com.springboot.ProductionReady.spring_production_ready.dto.EmployeeDTO;
import com.springboot.ProductionReady.spring_production_ready.exceptions.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;
    @Override
    public List<EmployeeDTO> getEmployees() {
        try {
            List<EmployeeDTO> employees = restClient.get()
                    .uri("/employee")
                    .retrieve()
                    .body(
                            new ParameterizedTypeReference<List<EmployeeDTO>>() {}
                    );

            return employees;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeId(Long id) {
        try {
            EmployeeDTO employee = restClient.get()
                    .uri("/employee/{employeeId}", id)
                    .retrieve()
                    .body(EmployeeDTO.class);

            return employee;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        try {
            EmployeeDTO employeeDTO1 = restClient.post()
                    .uri("/employee")
                    .body(employeeDTO)
                    .retrieve()
                    .body(EmployeeDTO.class);
            return employeeDTO1;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
