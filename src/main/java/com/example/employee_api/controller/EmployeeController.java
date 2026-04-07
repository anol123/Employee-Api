package com.example.employee_api.controller;

import com.example.employee_api.dto.EmployeeRequestDto;
import com.example.employee_api.dto.EmployeeResponseDto;
import com.example.employee_api.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    @RequestMapping("/create-employee")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(requestDto));
    }

    @GetMapping
    @RequestMapping("/employee-list")
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }

}
