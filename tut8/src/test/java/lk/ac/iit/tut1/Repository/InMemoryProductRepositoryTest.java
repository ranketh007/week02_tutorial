package lk.ac.iit.tut1.Repository;

import lk.ac.iit.tut1.Model.DigitalProduct;
import lk.ac.iit.tut1.Model.PhysicalProduct;
import lk.ac.iit.tut1.Model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryProductRepositoryTest {

    private InMemoryProductRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryProductRepository();
    }

    @Test
    void shouldAssignIdWhenSavingNewProduct() {
        Product notes = new DigitalProduct(null, "Course notes", 4.99, "/dl/2", 1.1);
        Product saved = repository.save(notes);
        assertNotNull(saved.getId());
        assertSame(notes, repository.findById(saved.getId()).get());
    }

    @Test
    void shouldDeleteProduct(){
        Product stickerPack = new PhysicalProduct(4L, "Stickers", 8.99, 0.005, "2x2");
        repository.save(stickerPack);
        assertEquals(4L, stickerPack.getId());
        repository.delete(4L);
        assertTrue(repository.findById(4L).isEmpty());
    }

}