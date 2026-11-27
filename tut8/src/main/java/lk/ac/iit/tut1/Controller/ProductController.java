package lk.ac.iit.tut1.Controller;
import lk.ac.iit.tut1.Model.DigitalProduct;
import lk.ac.iit.tut1.Model.Product;
import lk.ac.iit.tut1.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
        private final ProductService productService;

        public ProductController(ProductService productService){
            this.productService = productService;
        }

        @GetMapping("/products")
        public List<Product> getAllProducts() {
            return productService.getAllProducts();
        }

        @GetMapping("/products/{id}")
        public Product getProductById(@PathVariable Long id) {
            return productService.getProductById(id);
        }

        @PostMapping("/products")
        public void addProduct(@RequestBody DigitalProduct product) {
            productService.addProduct(product);
        }

        @DeleteMapping("/products/{id}")
        public void deleteProductById(@PathVariable Long id) {
            productService.deleteProductById(id);
        }
}
