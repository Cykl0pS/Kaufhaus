package workloads.Bill;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Bill {

    @EmbeddedId
    private BillId Id;

    private LocalDate date;
    private Long productId;

    public Long getProductId() { return productId; }

    public void setProductId(Long productId) { this.productId = productId; }

    public BillId getId() { return Id; }

    public void setId(BillId id) { Id = id; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public Bill(BillId id, LocalDate date, Long productId) {
        Id = id;
        this.date = date;
        this.productId = productId;
    }

    public Bill() {}
}
