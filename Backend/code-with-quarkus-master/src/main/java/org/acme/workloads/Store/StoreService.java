package workloads.Store;

import model.BillDTO;
import model.DeliveryDTO;
import model.StoreDTO;
import workloads.Bill.Bill;
import workloads.Bill.BillId;
import workloads.Customer.Customer;
import workloads.Customer.CustomerRepository;
import workloads.Delivery.Delivery;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class StoreService {

    private final StoreRepository storeRepository;
    private final CustomerRepository customerRepository;

    public StoreService(StoreRepository storeRepository, CustomerRepository customerRepository) {
        this.storeRepository = storeRepository;
        this.customerRepository = customerRepository;
    }

    public boolean addStore(StoreDTO newStore) {
        var existingPerson = storeRepository.getStoreById(newStore.getId());
        if (existingPerson != null) {
            return false;
        }

        var store = new Store();
        store.setName(newStore.getName());
        storeRepository.addStore(store);
        return true;
    }

    public List<Store> getAllStores() {
        return storeRepository.getAllStores();
    }

    public Store getStoreById(Long id){
        return storeRepository.getStoreById(id);
    }

    public boolean addBill(BillDTO newBill){

        if(newBill == null)
            return false;

        var bill = new Bill();
        bill.setProductId((long)newBill.getProductId());
        bill.setDate(newBill.getDate());
        bill.setId(new BillId(customerRepository.getCustomerById((long)newBill.getCustomerId())
                , storeRepository.getStoreById((long)newBill.getCustomerId()), storeRepository.getId()));
        storeRepository.addBill(bill);
        return true;
    }

    public boolean removeStore(Long id){
        var store = storeRepository.getStoreById(id);
        if(store == null)
            return false;

        storeRepository.removeStore(store);
        return true;
    }
}
