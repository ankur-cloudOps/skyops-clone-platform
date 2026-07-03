package com.skyops.backend.service;

import com.skyops.backend.dto.EmployeeRequest;
import com.skyops.backend.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest request);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(Long id);
}
