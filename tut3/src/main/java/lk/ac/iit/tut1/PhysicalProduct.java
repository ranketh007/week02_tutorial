package lk.ac.iit.tut1;

//Physical Product IS-A Product because PhysicalProduct is a subclass being extended from the superclass
//ShoppingCart HAS-A Product, therefore cannot be an extended Subclass
public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

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

    @Override
    public String getSummary(){
        return "Physical Product ID: %d | Name: %s | Price: %.2f | Weight: %.2f | Dimensions: %s".formatted(super.getId(), super.getName(), super.getPrice(), weightKg, dimensions);
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        discountedPrice -= getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
