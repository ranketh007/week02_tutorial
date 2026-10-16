package lk.ac.iit.tut1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
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
}
