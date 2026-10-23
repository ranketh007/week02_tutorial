package lk.ac.iit.tut1;

//Physical Product IS-A Product because PhysicalProduct is a subclass being extended from the superclass
//ShoppingCart HAS-A Product, therefore cannot be an extended Subclass
public class PhysicalProduct extends Product{
    private double weightKg;
    private String dimensions;

    public PhysicalProduct(){}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }


}
