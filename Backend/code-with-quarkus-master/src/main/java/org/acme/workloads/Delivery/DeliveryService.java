package workloads.Delivery;

import model.DeliveryDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public boolean addDelivery(DeliveryDTO newDelivery) {
        var existingPerson = deliveryRepository.getDeliveriesById(newDelivery.getId());
        if (existingPerson != null) {
            return false;
        }

        var delivery = new Delivery();
        delivery.setProductId(newDelivery.getProductId());
        delivery.setCount(newDelivery.getCount());
        delivery.setDate(newDelivery.getDate());
        delivery.setWarehouseId(newDelivery.getWarehouseId());
        deliveryRepository.addDelivery(delivery);
        return true;
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.getAllDeliveries();
    }

    public Delivery getDeliveryById(Long id){
        return deliveryRepository.getDeliveriesById(id);
    }
}
