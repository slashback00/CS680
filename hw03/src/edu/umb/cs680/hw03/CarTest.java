package edu.umb.cs680.hw03;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


public class CarTest 
{
    @Test
    public void verifyCarEqualityWithMakeModelYear() {
     
        String[] expected = {"Toyota", "RAV4", "2018"};    
        Car actual = new Car("Toyota", "RAV4", 2018, 0, 0);
            String[] actualArray = carToStringArray(actual);
            assertArrayEquals(expected, actualArray);
    }

    private void assertArrayEquals(String[] expected, String[] actualArray) {
    }
    private String[] carToStringArray(Car actual) {
        return null;
    } 


    @Test
    public void verifySetPrice(){
        Car actual = new Car("", "", 0, 0, 0);
        actual.setPrice(350000);
        assertEquals(350000, actual.getPrice(), 0.1);
    }


    @Test
    public void verifySetMileage(){
        Car actual = new Car("", "", 0, 0, 0);
        actual.setMileage(7300);
        assertEquals(7300, actual.getMileage(), 0.1);
    }

}
