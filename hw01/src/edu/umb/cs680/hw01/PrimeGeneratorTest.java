package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class PrimeGeneratorTest {
    @Test
        public void primes1to10() {
            PrimeGenerator generator = new PrimeGenerator(1, 20);
            generator.generatePrimes();
            Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
            assertArrayEquals(expectedPrimes, generator.getPrimes().toArray());
        }


    @Test
        public void noPrimesInRange() {
            PrimeGenerator generator = new PrimeGenerator(90, 98);
            generator.generatePrimes();
            Long[] expectedPrimes = {97L};
            assertArrayEquals(expectedPrimes, generator.getPrimes().toArray());
        }

    @Test
        public void primes20to30() {
            PrimeGenerator generator = new PrimeGenerator(20, 30);
            generator.generatePrimes();
            Long[] expectedPrimes = {23L, 29L};
            assertArrayEquals(expectedPrimes, generator.getPrimes().toArray());
        }
        @Test
            public void LBGreaterThanUpperB() {
                try {
                    PrimeGenerator G1 = new PrimeGenerator(20, 10);
                    } catch(Exception e) {
                assertEquals("Wrong input values: from=20 to=10", e.getMessage());
                }
            }


        @Test
            public void negtopos() {  /* negative test */
                try {
                    PrimeGenerator G2 = new PrimeGenerator(-3,3);
                }
                    catch(Exception e) {
            assertEquals("Wrong input values: from=-3 to=3" ,e.getMessage());
            }
    }



}

