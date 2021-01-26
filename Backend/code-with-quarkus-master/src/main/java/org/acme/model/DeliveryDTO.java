package model;

import java.time.LocalDate;

public class DeliveryDTO {

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

    public DeliveryDTO(Integer count, LocalDate date, Long warehouseId, Long productId) {
        this.count = count;
        this.date = date;
        this.warehouseId = warehouseId;
        this.productId = productId;
    }

    public DeliveryDTO() { };
}
