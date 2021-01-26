package model;

public class ProductDTO {

    private Long Id;
    private String name;
    private Double price;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductDTO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public ProductDTO() {}
}
