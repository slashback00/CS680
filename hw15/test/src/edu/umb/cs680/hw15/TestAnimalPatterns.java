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

    @Test
    void testPatternOrder() {
        AnimalPattern pattern1 = new Stripes();
        AnimalPattern pattern2 = new Spots();
        AnimalPattern pattern3 = new ColorfulFeathers();

        Animal animal1 = new Animal(pattern1);
        Animal animal2 = new Animal(pattern3);
        Animal animal3 = new Animal(pattern2);

        assertDoesNotThrow(() -> animal1.displayPattern());
        assertDoesNotThrow(() -> animal2.displayPattern());
        assertDoesNotThrow(() -> animal3.displayPattern());
    }

   
}

    
