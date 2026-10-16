package lk.ac.iit.tut1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

        @Autowired
        private ProductService productService;

        @GetMapping("/products")
        public List<Product> getAllProducts() {
            return productService.getAllProducts();
        }

        @GetMapping("/products/{id}")
        public Product getProductById(@PathVariable Long id) {
            return productService.getProductById(id).orElse(null);
        }

        @PostMapping("/products")
        public void addProduct(@RequestBody Product product) {
            productService.addProduct(product);
        }

        @DeleteMapping("/products/{id}")
        public void deleteProductById(@PathVariable Long id) {
            productService.deleteProductById(id);
        }

        @GetMapping("/products/search")
        public List<Product> search(@RequestParam String name) {
            return productService.findByName(name);
        }
}
