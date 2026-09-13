package com.springboot.ProductionReady.spring_production_ready.controllers;

import com.springboot.ProductionReady.spring_production_ready.clients.impl.EmployeeClient;
import com.springboot.ProductionReady.spring_production_ready.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeClient employeeClient;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeClient.getEmployees());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeClient.getEmployeeId(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeClient.createEmployee(employeeDTO));
    }
}
