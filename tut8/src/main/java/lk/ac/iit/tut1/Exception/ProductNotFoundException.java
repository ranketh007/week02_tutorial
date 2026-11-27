package lk.ac.iit.tut1.Exception;

public class ProductNotFoundException extends IllegalArgumentException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
