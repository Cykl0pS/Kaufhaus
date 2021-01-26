package workloads.Store;

import workloads.Bill.Bill;
import workloads.Employee.Employee;
import workloads.Employee.EmployeeRepository;
import workloads.Product.Product;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class StoreRepository {

    private final EntityManager entityManager;

    public StoreRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Store getStoreById(Long id) {
        var query = entityManager.createQuery("select s from Store s where s.Id = :id", Store.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
    public void addStore(Store store) {
        entityManager.persist(store);
    }

    public List<Store> getAllStores() {
        var query = entityManager.createQuery("select s from Store s", Store.class);
        return query.getResultList();
    }

    public void addBill(Bill bill) {entityManager.persist(bill);}

    public Long getId() { return entityManager.createQuery("SELECT coalesce(MAX(b.Id.BillNo), 0) +1 FROM Bill b", Long.class).getSingleResult(); }

    public void removeStore(Store store){entityManager.remove(store);}

}
