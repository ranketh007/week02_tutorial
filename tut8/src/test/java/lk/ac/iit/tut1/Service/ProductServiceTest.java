package lk.ac.iit.tut1.Service;

import lk.ac.iit.tut1.Exception.ProductNotFoundException;
import lk.ac.iit.tut1.Model.DigitalProduct;
import lk.ac.iit.tut1.Model.PhysicalProduct;
import lk.ac.iit.tut1.Model.Product;
import lk.ac.iit.tut1.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService productService;

    private final Product ebook =
            new DigitalProduct(1L, "E-book", 9.99, "/dl/1", 4.2);
    private final Product monitor =
            new PhysicalProduct(2L, "Monitor", 249.99, 5.4, "60x40");


    @Test
    void shouldReturnAllProducts() {
        when(repository.findAll()).thenReturn(List.of(ebook, monitor));
        List<Product> products = productService.getAllProducts();

        assertEquals(2, products.size());
        assertEquals("E-book", products.get(0).getName());
    }

    @Test
    void shouldReturnProductById() {
        when(repository.findById(1L)).thenReturn(Optional.of(ebook));
        Product result = productService.getProductById(1L);
        assertEquals("E-book", result.getName());
        assertEquals(9.99, result.getPrice(), 0.001);
    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class,
                () -> productService.getProductById(99L));
    }

    @Test
    void shouldSaveNewProduct() {
        DigitalProduct notes = new DigitalProduct(null, "Notes", 2.99, "/dl/3", 2.56);
        when(repository.save(notes)).thenReturn(notes);
        Product result = productService.addProduct(notes);
        verify(repository).save(notes);
        assertEquals("Notes", result.getName());
    }

    @Test
    void shouldNotDeleteWhenProductMissing() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class,
                () -> productService.deleteProductById(99L));

        verify(repository, never()).delete(any());
    }
}