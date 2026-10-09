package lk.ac.iit.tut1;

public class Product {
    private Long id;
    private String name;
    private double price;

    public Product() { }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

}
