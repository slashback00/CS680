package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class SingletonPrimeGeneratorTest {

    @Test
    void testGetInstance() {
        SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance(1, 100);
        SingletonPrimeGenerator instance2 = SingletonPrimeGenerator.getInstance(1, 100);
        
        assertNotNull(instance1);
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    @Test
    void testGetPrimes() {
        SingletonPrimeGenerator instance = SingletonPrimeGenerator.getInstance(1, 10);
        instance.generatePrimes();
        LinkedList<Long> expected = new LinkedList<Long>(Arrays.asList(2L, 3L, 5L, 7L));
        assertIterableEquals(expected, instance.getPrimes());
    }
    
    @Test
    void testException() {
        assertThrows(RuntimeException.class, () -> SingletonPrimeGenerator.getInstance(-10, 10));
    }

}

