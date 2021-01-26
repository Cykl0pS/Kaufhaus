package workloads.Store;

import workloads.Bill.Bill;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @OneToMany(mappedBy = "Id.store", cascade = CascadeType.REMOVE)
    List<Bill> bills = new ArrayList<>();


    public List<Bill> getBills() { return bills; }

    public void setBills(Bill bill) { this.bills.add(bill); }

    public Long getId() { return Id; }

    public void setId(Long id) { this.Id = id; }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Store(String name) {
        this.name = name;
    }

    public Store() {}
}
