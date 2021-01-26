package model;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long Id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Double salary;

    public EmployeeDTO(String firstName, String lastName, LocalDate dateOfBirth, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    public EmployeeDTO() {}

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Double getSalary() { return salary; }

    public void setSalary(Double salary) { this.salary = salary; }
}
