package workloads.Customer;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class CustomerRepository {

    private final EntityManager entityManager;

    public CustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Customer getCustomerById(Long id) {
        var query = entityManager.createQuery("select c from Customer c where c.Id = :id", Customer.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> getAllCustomer() {
        var query = entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    public void removeCustomer(Customer customer){entityManager.remove(customer);}
}
