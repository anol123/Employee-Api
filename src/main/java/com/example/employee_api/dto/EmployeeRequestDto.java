//package com.example.employee_api.dto;
//
//import jakarta.validation.constraints.*;
//import lombok.Data;
//
//@Data
//public class EmployeeRequestDto {
//
//    @NotBlank(message="Name is required")
//    @Size(min=2,max=100, message="Name must be between 2 and 100 characters")
//    private String name;
//
//    @NotBlank(message="Email id required")
//    @Email(message="Must be a valid email address")
//    private String email;
//
//    @NotBlank(message="Department is required")
//    private String department;
//
//    @NotNull(message="Salary  is required")
//    @Positive(message="Salary must be a positive number")
//    private Double salary;
//}


package com.example.employee_api.dto;

public class EmployeeRequestDto {

    private String name;
    private String email;
    private String department;
    private Double salary;

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public Double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(Double salary) { this.salary = salary; }
}