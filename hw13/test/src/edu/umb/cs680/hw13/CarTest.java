package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class CarTest {
        Car c1= new Car("Honda","Odessey" , 18 , 2020, 132225);
        Car c2= new Car("Audi","Q8" , 14 , 2021, 155590 );
        Car c3= new Car("Tesla","X" , 20 , 2023, 350000 );

        

    @Test
    public void checkMilageComparatorSort(){
        LinkedList<Car> cars = new LinkedList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        Collections.sort(cars, Comparator.comparing(car -> car.getMileage(),Comparator.reverseOrder()));
        LinkedList<String> SortedCarNamesByMilage = new LinkedList<String>();
        for(Car car : cars){
            SortedCarNamesByMilage.add("Car : " + car.getMake() + car.getModel());

        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Car : TeslaX");
        expected.add("Car : HondaOdessey");
        expected.add("Car : AudiQ8");

        assertEquals(expected, SortedCarNamesByMilage);
        
    }

    @Test
    public void checkPriceComparatorSort(){
        LinkedList<Car> cars = new LinkedList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        Collections.sort(cars, Comparator.comparing(car -> car.getPrice()));
        LinkedList<String> SortedCarNamesByPrice = new LinkedList<String>();
        for(Car car : cars){
            SortedCarNamesByPrice.add("Car : " + car.getMake() + car.getModel());

        }
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Car : HondaOdessey");
        expected.add("Car : AudiQ8");
        expected.add("Car : TeslaX");

        assertEquals(expected, SortedCarNamesByPrice);
        
    }

    @Test
    public void checkYearComparatorSort(){
        LinkedList<Car> cars = new LinkedList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        Collections.sort(cars, Comparator.comparing(car -> car.getYear(),Comparator.reverseOrder()));
        LinkedList<String> SortedCarNamesByYear = new LinkedList<String>();
        for(Car car : cars){
            SortedCarNamesByYear.add("Car : " + car.getMake() + car.getModel());

        }
        LinkedList<String> expected = new LinkedList<String>();
        
        expected.add("Car : TeslaX");
        expected.add("Car : AudiQ8");
        expected.add("Car : HondaOdessey");
        
        assertEquals(expected, SortedCarNamesByYear);
    }


    @Test
    public void testSortingEmptyList() {
        LinkedList<Car> cars = new LinkedList<Car>();
        Collections.sort(cars, Comparator.comparing(car -> car.getMileage(),Comparator.reverseOrder()));
        assertTrue(cars.isEmpty());
    }

    @Test
public void testParetoComparisonSort() {
    Car c1 = new Car("Honda", "Odessey", 18, 2020, 132225);
    Car c2 = new Car("Audi", "Q8", 14, 2021, 155590);
    Car c3 = new Car("Tesla", "X", 20, 2023, 350000);

    LinkedList<Car> cars = new LinkedList<>();
    cars.add(c1);
    cars.add(c2);
    cars.add(c3);

    Collections.sort(cars, (car1, car2) -> {
        boolean car1DominatesCar2 = car1.getMileage() >= car2.getMileage() && car1.getPrice() <= car2.getPrice();
        boolean car2DominatesCar1 = car2.getMileage() >= car1.getMileage() && car2.getPrice() <= car1.getPrice();

        if (car1DominatesCar2 && !car2DominatesCar1) {
            return -1; 
        } else if (!car1DominatesCar2 && car2DominatesCar1) {
            return 1; 
        } else {
            return 0; 
        }
    });

    LinkedList<String> sortedCarNames = new LinkedList<>();
    for (Car car : cars) {
        sortedCarNames.add("Car: " + car.getMake() + car.getModel());
    }

    LinkedList<String> expected = new LinkedList<>();
    expected.add("Car: HondaOdessey");
    expected.add("Car: AudiQ8");
    expected.add("Car: TeslaX");

    assertEquals(expected, sortedCarNames);
}


   
}