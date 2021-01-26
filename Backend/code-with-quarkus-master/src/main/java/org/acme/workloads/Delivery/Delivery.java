package workloads.Delivery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer count;
    private LocalDate date;
    private Long warehouseId;
    private Long productId;

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public Integer getCount() { return count; }

    public void setCount(Integer count) { this.count = count; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public Long getWarehouseId() { return warehouseId; }

    public void setWarehouseId(Long warehouseId) { this.warehouseId = warehouseId; }

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }
}
