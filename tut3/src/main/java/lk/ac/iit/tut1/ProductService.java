package lk.ac.iit.tut1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService(){
        //id, name and price derives from the superclass Product
        products.add(new DigitalProduct(1L, "Ebook", 5.99, "file/path/url", 2.5));
        products.add(new PhysicalProduct(2L, "Refridgerator", 5099.99, 250.69, "25X25"));
    }

    public List<Product> getAllProducts() {
        return products;
    }
    public Product addProduct(Product product) {
        product.setId(nextId++);
        return product;
    }

    public Optional<Product> getProductById(Long Id) {
        return products.stream().filter(p -> p.getId().equals(Id)).findFirst();
    }

    public void deleteProductById(Long Id) {
        products.removeIf(p -> p.getId().equals(Id));
    }

    public List<Product> findByName(String name) {
        return products.stream().filter(p -> p.getName().contains(name)).toList();
    }
    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product p : products) {
            summaries.add(p.getSummary());
        }
        return summaries;
    }
}
