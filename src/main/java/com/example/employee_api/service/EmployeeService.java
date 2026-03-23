package com.example.employee_api.service;

import com.example.employee_api.dto.EmployeeRequestDto;
import com.example.employee_api.dto.EmployeeResponseDto;
import com.example.employee_api.entity.Employee;
import com.example.employee_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;


    private EmployeeResponseDto toResponseDto(Employee employee){
        return EmployeeResponseDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build();
    }


}
