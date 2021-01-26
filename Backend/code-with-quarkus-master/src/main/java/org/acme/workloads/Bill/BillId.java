package workloads.Bill;

import workloads.Customer.Customer;
import workloads.Store.Store;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @Column(name = "BillNo")
    private Long BillNo = 0L;

    public BillId(Customer customer, Store store, Long BillNo) {
        this.customer = customer;
        this.store = store;
        this.BillNo = BillNo;
    }

    public BillId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillId billId = (BillId) o;
        return Objects.equals(customer, billId.customer) &&
                Objects.equals(store, billId.store);
    }

    @Override
    public int hashCode() { return Objects.hash(customer, store); }
}
