package lk.ac.iit.tut1.Repository;

import lk.ac.iit.tut1.Model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;

@Primary
@Repository
public class InMemoryProductRepository implements ProductRepository{
    private final Map<Long, Product> store = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Product save(Product product) {
        if(product.getId()==null){
            product.setId(nextId);
            nextId++;
        }
        store.put(product.getId(), product);
        return product;
    }

    @Override
    public void delete(Long id) {
        store.values().removeIf(product -> product.getId().equals(id));
    }
}
