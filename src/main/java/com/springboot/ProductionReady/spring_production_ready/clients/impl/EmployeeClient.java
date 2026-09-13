package com.springboot.ProductionReady.spring_production_ready.clients.impl;

import com.springboot.ProductionReady.spring_production_ready.advices.ApiResponse;
import com.springboot.ProductionReady.spring_production_ready.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getEmployees();
    EmployeeDTO getEmployeeId(Long id);
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
}
