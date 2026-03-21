package com.example.employee_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeRequestDto {

    @NotBlank(message="Name is required")
    @Size(min=2,max=100, message="Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message="Email id required")
    @Email(message="Must be a valid email address")
    private String email;

    @NotBlank(message="Department is required")
    private String department;

    @NotNull(message="Salary  is required")
    @Positive(message="Salary must be a positive number")
    private Double salary;
}
