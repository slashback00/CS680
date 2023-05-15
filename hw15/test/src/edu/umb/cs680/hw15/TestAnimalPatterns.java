package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestAnimalPatterns {

    @Test
    void testStripesPattern() {
        Animal zebra = new Animal(new Stripes());
        assertDoesNotThrow(() -> zebra.displayPattern());
    }

    @Test
    void testSpotsPattern() {
        Animal leopard = new Animal(new Spots());
        assertDoesNotThrow(() -> leopard.displayPattern());
    }

    @Test
    void testColorfulFeathersPattern() {
        Animal peacock = new Animal(new ColorfulFeathers());
        assertDoesNotThrow(() -> peacock.displayPattern());
    }
}

    
