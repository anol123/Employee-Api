package com.example.employee_api.service;

import com.example.employee_api.dto.EmployeeRequestDto;
import com.example.employee_api.dto.EmployeeResponseDto;
import com.example.employee_api.entity.Employee;
import com.example.employee_api.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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

    //create
    public EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto){
        if(employeeRepository.existsByEmail(requestDto.getEmail())){
            throw new IllegalArgumentException("Email already exists: "+ requestDto.getEmail());
        }

        Employee employee = Employee.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .department(requestDto.getDepartment())
                .salary(requestDto.getSalary())
                .build();
        Employee saved = employeeRepository.save(employee);
        return toResponseDto(saved);
    }

    public List<EmployeeResponseDto> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }


}
