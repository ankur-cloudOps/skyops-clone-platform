package com.skyops.backend.controller;

import com.skyops.backend.dto.EmployeeRequest;
import com.skyops.backend.dto.EmployeeResponse;
import com.skyops.backend.model.ApiResponse;
import com.skyops.backend.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(
            @Valid @RequestBody EmployeeRequest request) {

        logger.info("Creating employee with email: {}", request.getEmail());

        EmployeeResponse employee = employeeService.createEmployee(request);

        logger.info("Employee created successfully with ID: {}", employee.getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Employee created successfully.", employee));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> getAllEmployees() {

        logger.info("Fetching all employees");

        List<EmployeeResponse> employees = employeeService.getAllEmployees();

        logger.info("Total employees found: {}", employees.size());

        return ResponseEntity.ok(
                ApiResponse.success("Employees fetched successfully.", employees)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> getEmployeeById(
            @PathVariable Long id) {

        logger.info("Fetching employee with ID: {}", id);

        EmployeeResponse employee = employeeService.getEmployeeById(id);

        logger.info("Employee found with ID: {}", employee.getId());

        return ResponseEntity.ok(
                ApiResponse.success("Employee fetched successfully.", employee)
        );
    }
}