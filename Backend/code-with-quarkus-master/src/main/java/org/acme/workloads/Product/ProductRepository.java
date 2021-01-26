package workloads.Product;

import workloads.Employee.Employee;
import workloads.Store.Store;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class ProductRepository {

    private final EntityManager entityManager;
    public ProductRepository(EntityManager entityManager) { this.entityManager = entityManager; }

    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    public List<Product> getAllProducts() {
        var query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    public Product getProductById(Long id) {
        var query = entityManager.createQuery("select p from Product p where p.Id = :id", Product.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    public void removeProduct(Product product){entityManager.remove(product);}
}
