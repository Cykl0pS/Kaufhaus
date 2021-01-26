package workloads.Customer;

import model.CustomerDTO;
import workloads.Delivery.Delivery;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean addCustomer(CustomerDTO newCustomer) {
        var existingPerson = customerRepository.getCustomerById(newCustomer.getId());
        if (existingPerson != null) {
            return false;
        }

        var customer = new Customer();
        customer.setDateOfBirth(newCustomer.getDateOfBirth());
        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setAddress(newCustomer.getAddress());
        customer.setZipCode(newCustomer.getZipCode());
        customerRepository.addCustomer(customer);
        return true;
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.getCustomerById(id);
    }

    public boolean removeCustomer(Long id){
        var customer = customerRepository.getCustomerById(id);
        if(customer == null)
            return false;

        customerRepository.removeCustomer(customer);
        return true;
    }
}
