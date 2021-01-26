package workloads.Product;

import model.ProductDTO;
import model.StoreDTO;
import workloads.Store.Store;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository; }

    public boolean addProduct(ProductDTO newProduct) {
        var existingPerson = productRepository.getProductById(newProduct.getId());
        if (existingPerson != null) {
            return false;
        }

        var product = new Product();
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productRepository.addProduct(product);
        return true;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(Long id){
        return productRepository.getProductById(id);
    }

    public boolean removeProduct(Long id){
        var product = productRepository.getProductById(id);
        if(product == null)
            return false;

        productRepository.removeProduct(product);
        return true;
    }
}
