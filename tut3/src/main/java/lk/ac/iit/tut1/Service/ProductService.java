package lk.ac.iit.tut1.Service;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lk.ac.iit.tut1.Model.DigitalProduct;
import lk.ac.iit.tut1.Model.PhysicalProduct;
import lk.ac.iit.tut1.Model.Product;
import lk.ac.iit.tut1.Repository.InMemoryProductRepository;
import lk.ac.iit.tut1.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Product getProductById(Long Id) {
        return repository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Invalid Id : " + Id));
    }

    public void deleteProductById(Long Id) {
        getProductById(Id);
        repository.delete(Id);
    }

}
