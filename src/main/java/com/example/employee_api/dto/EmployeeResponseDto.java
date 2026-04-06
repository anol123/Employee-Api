//package com.example.employee_api.dto;
//
//import lombok.Builder;
//import lombok.Data;
//
//@Data
//@Builder
//public class EmployeeResponseDto {
//    private Long id;
//    private String name;
//    private String email;
//    private String department;
//    private Double salary;
//
//}

package com.example.employee_api.dto;

public class EmployeeResponseDto {

    private Long id;
    private String name;
    private String email;
    private String department;
    private Double salary;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public Double getSalary() { return salary; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(Double salary) { this.salary = salary; }

    // Manual builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final EmployeeResponseDto dto = new EmployeeResponseDto();

        public Builder id(Long id) { dto.id = id; return this; }
        public Builder name(String name) { dto.name = name; return this; }
        public Builder email(String email) { dto.email = email; return this; }
        public Builder department(String department) { dto.department = department; return this; }
        public Builder salary(Double salary) { dto.salary = salary; return this; }

        public EmployeeResponseDto build() { return dto; }
    }
}