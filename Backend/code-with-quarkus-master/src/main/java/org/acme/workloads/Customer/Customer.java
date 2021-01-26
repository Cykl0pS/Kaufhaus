package workloads.Customer;

import workloads.Bill.Bill;
import workloads.Store.Store;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private String address;
    private Integer zipCode;

    @OneToMany(mappedBy = "Id.customer", cascade = CascadeType.REMOVE)
    List<Bill> bills = new ArrayList<>();

    public List<Bill> getBills() { return bills; }

    public void setBills(List<Bill> bills) { this.bills = bills; }

    public Integer getZipCode() { return zipCode; }

    public void setZipCode(Integer zipCode) { this.zipCode = zipCode; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Customer(LocalDate dateOfBirth, String firstName, String lastName, String address, Integer zipCode) {
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
    }

    public Customer() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(Id, customer.Id) &&
                Objects.equals(dateOfBirth, customer.dateOfBirth) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(zipCode, customer.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, dateOfBirth, firstName, lastName, address, zipCode);
    }
}

