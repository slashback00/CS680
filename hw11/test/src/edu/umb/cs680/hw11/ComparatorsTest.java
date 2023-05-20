package edu.umb.cs680.hw11;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



public class ComparatorsTest {
    LinkedList<Car> Cars = new LinkedList<Car>();
        Car c1= new Car("Honda","Odessey" , 18 , 2020, 132225);
        Car c2= new Car("Audi","Q8" , 14 , 2021, 155590 );
        Car c3= new Car("Tesla","X" , 20 , 2023, 350000 );

        @Test
        public void checkMilageComparatorSort(){
            Cars.add(c1);
            Cars.add(c2);
            Cars.add(c3);

            LinkedList<Car> expected = new LinkedList<Car>();
            expected.add(c2);      
            expected.add(c1);
            expected.add(c3);

            Collections.sort(Cars, new MileageComparator());
            Assert.assertArrayEquals(expected.toArray(), Cars.toArray());
        }
        @Test
        public void checkPriceComparator(){
            Cars.add(c1);
            Cars.add(c2);
            Cars.add(c3);

            LinkedList<Car> expected = new LinkedList<Car>();
            expected.add(c1);      
            expected.add(c2);
            expected.add(c3);

            Collections.sort(Cars, new PriceComparator());
            Assert.assertArrayEquals(expected.toArray(), Cars.toArray());
        }
        @Test
        public void checkParetoComparator(){
            Cars.add(c1);
            Cars.add(c2);
            Cars.add(c3);

            LinkedList<Car> expected = new LinkedList<Car>();
            expected.add(c1);      
            expected.add(c2);
            expected.add(c3);

            Collections.sort(Cars, new ParetoComparator());
            Assert.assertArrayEquals(expected.toArray(), Cars.toArray());
        }
   

        @Test
        public void checkMilageComparatorWithNegativeMilage(){
            Car c1 = new Car("Toyota", "Camry", 2015, -5000, 0);
            Car c2 = new Car("Honda", "Civic", 2018, 10000, 0);
            Car c3 = new Car("Ford", "Escape", 2017, 20000, 0);
            Cars.add(c1);
            Cars.add(c2);
            Cars.add(c3);

            LinkedList<Car> expected = new LinkedList<Car>();
            expected.add(c1);      
            expected.add(c3);
            expected.add(c2);

            Collections.sort(Cars, new MileageComparator());
            Assert.assertArrayEquals(expected.toArray(), Cars.toArray());
        }

     
        @Test
        public void checkByYearComparator() {
            List<Car> expected = new ArrayList<>(Cars);
            Collections.sort(expected, Comparator.comparingInt(Car::getYear));

            Collections.sort(Cars, new YearComparator());

            Assert.assertEquals(expected, Cars);
        }

}

