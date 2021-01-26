package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerDTO {

    private Long Id;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private String address;
    private Integer zipCode;

    public Integer getZipCode() { return zipCode; }

    public void setZipCode(Integer zipCode) { this.zipCode = zipCode; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public CustomerDTO() { }

    public CustomerDTO(LocalDate dateOfBirth, String firstName, String lastName, String address, Integer zipCode) {
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
    }

}
