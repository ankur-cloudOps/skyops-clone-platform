package com.skyops.backend.service.impl;

import com.skyops.backend.dto.EmployeeRequest;
import com.skyops.backend.dto.EmployeeResponse;
import com.skyops.backend.entity.Employee;
import com.skyops.backend.exception.ResourceNotFoundException;
import com.skyops.backend.repository.EmployeeRepository;
import com.skyops.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        log.info("Creating employee with email={}", request.getEmail());

        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .department(request.getDepartment())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        log.info("Employee created successfully with id={}", savedEmployee.getId());

        return mapToResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        log.info("Fetching all employees from database");

        List<EmployeeResponse> employees = employeeRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

        log.info("Successfully fetched {} employees", employees.size());

        return employees;
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        log.info("Fetching employee with id={}", id);

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee not found with id={}", id);
                    return new ResourceNotFoundException("Employee not found with id: " + id);
                });

        log.info("Employee found with id={}", id);

        return mapToResponse(employee);
    }

    private EmployeeResponse mapToResponse(Employee employee) {

        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .build();
    }
}