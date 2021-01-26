package model;

import java.time.LocalDate;

public class BillDTO {

    private Integer customerId;
    private Integer storeId;
    private LocalDate date;
    private Integer productId;

    public BillDTO(Integer customerId, Integer storeId, LocalDate date, Integer productId) {
        this.customerId = customerId;
        this.storeId = storeId;
        this.date = date;
        this.productId = productId;
    }

    public BillDTO() {}

    public Integer getProductId() { return productId; }

    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
