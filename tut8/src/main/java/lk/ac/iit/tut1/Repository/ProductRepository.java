package lk.ac.iit.tut1.Repository;

import lk.ac.iit.tut1.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);
}
