package model;

public class StoreDTO {

    private Long Id;
    private String name;

    public Long getId() { return Id; }

    public void setId(Long id) { Id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public StoreDTO( String name) {
        this.name = name;
    }

    public StoreDTO() {}
}
