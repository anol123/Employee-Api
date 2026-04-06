package com.example.employee_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private Double salary;

    // Constructors
    public Employee() {}

    public Employee(Long id, String name, String email, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

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

    // Builder
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final Employee e = new Employee();

        public Builder id(Long id) { e.id = id; return this; }
        public Builder name(String name) { e.name = name; return this; }
        public Builder email(String email) { e.email = email; return this; }
        public Builder department(String department) { e.department = department; return this; }
        public Builder salary(Double salary) { e.salary = salary; return this; }

        public Employee build() { return e; }
    }
}