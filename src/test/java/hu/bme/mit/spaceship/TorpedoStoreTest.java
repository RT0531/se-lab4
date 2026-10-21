package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

     @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);
        // Act
        boolean result = store.fire(1);
        // Assert
        assertEquals(true, result);
    }
    @Test
    void fire_FailOverheat() {//Egységteszt a random overheat ellenőrzésére
        // Arrange
        TorpedoStore store = new TorpedoStore(1,1.0);
        // Act
        boolean result = store.fire(1);
        // Assert
        assertEquals(false, result);
    }
    @Test
    void fire_FailTooMany() {//Egységteszt a mohóság ellenőzésére
        // Arrange
        TorpedoStore store = new TorpedoStore(1);
        // Act
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class, ()->store.fire(2));
        assertEquals("numberOfTorpedos", e.getMessage());
    }
    @Test
    void fire_FailIncorrectAmmount() {//Egységteszt az exception || elötti részére
        // Arrange
        TorpedoStore store = new TorpedoStore(1);
        // Act
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class, ()->store.fire(0));
        assertEquals("numberOfTorpedos", e.getMessage());
    }
    @Test
    void isEmpty_true() {//Egységteszt az isEmpty igaz ágára
        // Arrange
        TorpedoStore store = new TorpedoStore(1);
        // Act
        store.fire(1);
        Boolean result=store.isEmpty();
        // Assert
        assertEquals(true, result);
    }
    @Test
    void isEmpty_false() {//Egységteszt az is Empty hamis ágára
        // Arrange
        TorpedoStore store = new TorpedoStore(2);
        // Act
        store.fire(1);
        Boolean result=store.isEmpty();
        // Assert
        assertEquals(false, result);
    }
    @Test
    void getTorpedoCount() {//Egységteszt az getTorpedoCountra
        // Arrange
        TorpedoStore store = new TorpedoStore(2);
        // Act
        store.fire(1);
        int result=store.getTorpedoCount();
        // Assert
        assertEquals(1, result);
    }
}
