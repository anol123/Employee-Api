package com.example.employee_api.service;

import com.example.employee_api.dto.EmployeeRequestDto;
import com.example.employee_api.dto.EmployeeResponseDto;
import com.example.employee_api.entity.Employee;
import com.example.employee_api.exception.EmployeeNotFoundException;
import com.example.employee_api.repository.EmployeeRepository;
//import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


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

    public EmployeeResponseDto getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
        return toResponseDto(employee);
    }


    public String deleteById(Long id) {
        employeeRepository.deleteById(id);
        return "Deleted employee: "+ id;
    }

//    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto) {
//        Employee employee = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
//        employee.setName(requestDto.getName());
//        employee.setDepartment(requestDto.getDepartment());
//        employee.setEmail(requestDto.getEmail());
//        employee.setSalary(requestDto.getSalary());
//
//        return toResponseDto(employee);
//    }
}
