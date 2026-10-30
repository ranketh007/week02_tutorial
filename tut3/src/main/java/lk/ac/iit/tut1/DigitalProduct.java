package lk.ac.iit.tut1;

public class DigitalProduct extends Product implements Discountable{
    private String downloadURL;
    private double fileSize;
    private double discountedPrice;

    public DigitalProduct(){}

    public DigitalProduct(Long id, String name, double Price, String downloadURL, double fileSize){
        super(id, name, Price);
        this.downloadURL = downloadURL;
        this.fileSize = fileSize;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public double getFileSize() {
        return fileSize;
    }

    @Override
    public String getSummary() {
        return "Digital Product ID: %d | Name: %s | Price: %.2f | Download URL: %s | File Size: %.2f".formatted(super.getId(), super.getName(), super.getPrice(), downloadURL, fileSize);
    }

    @Override
    public void applyDiscount(double rate) {
        discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}

