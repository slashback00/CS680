package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceTest {
    
    // Define your min and max for each car property for normalization
    double minPrice = 1000, maxPrice = 10000; 
    double minYear = 2010, maxYear = 2023; 
    double minMileage = 5000, maxMileage = 200000;

    @Test
    public void testDistanceMatrix() {
        List<Double> car1 = Arrays.asList(5000.0, 2020.0, 100000.0);
        List<Double> car2 = Arrays.asList(8000.0, 2022.0, 50000.0);
        List<Double> car3 = Arrays.asList(7000.0, 2019.0, 75000.0);
        List<Double> car4 = Arrays.asList(10000.0, 2021.0, 30000.0);
        List<Double> car5 = Arrays.asList(6000.0, 2018.0, 120000.0);

        // Normalize points
        List<List<Double>> points = new ArrayList<>();
        points.add(normalize(car1));
        points.add(normalize(car2));
        points.add(normalize(car3));
        points.add(normalize(car4));
        points.add(normalize(car5));

        // Use the Distance class
        List<List<Double>> matrixEuclidean = Distance.matrix(points, new Euclidean());
        List<List<Double>> matrixManhattan = Distance.matrix(points, new Manhattan());

        // Write your assertions here...
        // Assert the size of the matrix equals the number of cars
        assertEquals(5, matrixEuclidean.size());
        assertEquals(5, matrixManhattan.size());

        // Assert the size of each row in the matrix equals the number of cars
        for(int i=0; i<5; i++) {
            assertEquals(5, matrixEuclidean.get(i).size());
            assertEquals(5, matrixManhattan.get(i).size());
        }

        // Assert that the distance from a car to itself is zero for each car
        for(int i=0; i<5; i++) {
            assertEquals(0, matrixEuclidean.get(i).get(i));
            assertEquals(0, matrixManhattan.get(i).get(i));
        }
    }

    @Test
    public void testEuclideanDistance() {
        List<Double> car1 = normalize(Arrays.asList(5000.0, 2020.0, 100000.0));
        List<Double> car2 = normalize(Arrays.asList(8000.0, 2022.0, 50000.0));
        
        double distance = Distance.get(car1, car2, new Euclidean());
        
        // Assert that the distance is positive
        assertTrue(distance >= 0);
        
        // Assert that the distance is zero when the two points are the same
        assertEquals(0, Distance.get(car1, car1, new Euclidean()));
    }

    @Test
    public void testManhattanDistance() {
        List<Double> car1 = normalize(Arrays.asList(5000.0, 2020.0, 100000.0));
        List<Double> car2 = normalize(Arrays.asList(8000.0, 2022.0, 50000.0));
        
        double distance = Distance.get(car1, car2, new Manhattan());
        
        // Assert that the distance is positive
        assertTrue(distance >= 0);
        
        // Assert that the distance is zero when the two points are the same
        assertEquals(0, Distance.get(car1, car1, new Manhattan()));
    }

    @Test
    public void testChebyshevDistance() {
    List<Double> car1 = normalize(Arrays.asList(5000.0, 2020.0, 100000.0));
    List<Double> car2 = normalize(Arrays.asList(8000.0, 2022.0, 50000.0));
    
    double distance = Distance.get(car1, car2, new Chebyshev());
    
    // Assert that the distance is positive
    assertTrue(distance >= 0);
    
    // Assert that the distance is zero when the two points are the same
    assertEquals(0, Distance.get(car1, car1, new Chebyshev()));
    }

    // Method to normalize car properties
    private List<Double> normalize(List<Double> car) {
        double normalizedPrice = (car.get(0) - minPrice) / (maxPrice - minPrice);
        double normalizedYear = (car.get(1) - minYear) / (maxYear - minYear);
        double normalizedMileage = (car.get(2) - minMileage) / (maxMileage - minMileage);
        return Arrays.asList(normalizedPrice, normalizedYear, normalizedMileage);
    }
}
