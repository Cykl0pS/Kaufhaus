package workloads.Delivery;

import workloads.Customer.Customer;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class DeliveryRepository {

    private final EntityManager entityManager;

    public DeliveryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Delivery getDeliveriesById(Long id) {
        var query = entityManager.createQuery("select d from Delivery d where d.Id = :id", Delivery.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }
    public void addDelivery(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public List<Delivery> getAllDeliveries() {
        var query = entityManager.createQuery("select d from Delivery d", Delivery.class);
        return query.getResultList();
    }
}
