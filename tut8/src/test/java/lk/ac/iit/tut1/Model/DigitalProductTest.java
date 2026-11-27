package lk.ac.iit.tut1.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DigitalProductTest {

    @Test
    void shouldUpdatePriceWhenValid(){
        DigitalProduct ebook = new DigitalProduct(1L, "E-Book", 9.99, "/dl/1", 4.2);
        ebook.setPrice(7.49);
        assertEquals(7.49, ebook.getPrice(), 0.001);
    }

    @Test
    void shouldRejectNegativePrice(){
        DigitalProduct ebook = new DigitalProduct(1L, "E-Book", 9.99, "/dl/1", 4.2);
        assertThrows(IllegalArgumentException.class, () -> ebook.setPrice(-0.01));
    }



}