package api;
import model.CustomerDTO;
import model.EmployeeDTO;
import model.ProductDTO;
import model.StoreDTO;
import workloads.Customer.CustomerService;
import workloads.Delivery.DeliveryService;
import workloads.Employee.Employee;
import workloads.Employee.EmployeeService;
import workloads.Product.Product;
import workloads.Product.ProductService;
import workloads.Store.Store;
import workloads.Store.StoreService;

import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/api/initDB")
public class AddingToDatabase {

    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final StoreService storeService;
    private final ProductService productService;
    private final DeliveryService deliveryService;

    public AddingToDatabase(CustomerService customerService, EmployeeService employeeService, StoreService storeService, ProductService productService, DeliveryService deliveryService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.storeService = storeService;
        this.productService = productService;
        this.deliveryService = deliveryService;
    }


    @Path("/initdb")
    @POST
    @Transactional
    public Response InitDB()
    {
        LocalDate date = LocalDate.now();

        CustomerDTO customer1 = new CustomerDTO(date,"Max","Mustermann","Mustermannstraße", 4493);
        CustomerDTO customer2 = new CustomerDTO(date,"Mia","Mustermann","Mustermannstraße",4493);
        CustomerDTO customer3 = new CustomerDTO(date,"Andi","Mustermann","Mustermannstraße",4493);
        CustomerDTO customer4 = new CustomerDTO(date,"Jan","Mustermann","Mustermannstraße",4493);
        CustomerDTO customer5 = new CustomerDTO(date,"Kemal","Mustermann","Mustermannstraße",4493);

        StoreDTO store1 = new StoreDTO("Billa");
        StoreDTO store2 = new StoreDTO("MCDonalds");
        StoreDTO store3 = new StoreDTO("KFC");
        StoreDTO store4 = new StoreDTO("H&M");
        StoreDTO store5 = new StoreDTO("Jack&Jones");

        EmployeeDTO emp1 = new EmployeeDTO("Max","Mustermann",date,2333.00);
        EmployeeDTO emp2 = new EmployeeDTO("Mia","Mustermann",date,2433.00);
        EmployeeDTO emp3 = new EmployeeDTO("Andi","Mustermann",date,2533.00);
        EmployeeDTO emp4 = new EmployeeDTO("Jan","Mustermann",date,2233.00);
        EmployeeDTO emp5 = new EmployeeDTO("Kemal","Mustermann",date,2133.00);

        ProductDTO product1 = new ProductDTO("Turnschuh",30.00);
        ProductDTO product2 = new ProductDTO("Maulkorb",30.00);
        ProductDTO product3 = new ProductDTO("Trickot",30.00);
        ProductDTO product4 = new ProductDTO("Erdnüsse",30.00);
        ProductDTO product5 = new ProductDTO("Handschuhe",30.00);


        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);
        customerService.addCustomer(customer4);
        customerService.addCustomer(customer5);
        storeService.addStore(store1);
        storeService.addStore(store2);
        storeService.addStore(store3);
        storeService.addStore(store4);
        storeService.addStore(store5);
        employeeService.addEmployee(emp1);
        employeeService.addEmployee(emp2);
        employeeService.addEmployee(emp3);
        employeeService.addEmployee(emp4);
        employeeService.addEmployee(emp5);
        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);
        productService.addProduct(product5);

    return Response.ok().build();

    }





}
