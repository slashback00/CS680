package edu.umb.cs680.hw13;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Car {
	private String make;
	private String model;
	private int mileage;
	private int year;
	private float price;
	private int dominationCount;
	
	public Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

   
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return dominationCount;
	}
	
	public void setDominationCount(LinkedList<Car> cars) {
		this.dominationCount = 0;
		for (Car car : cars) {
			if(car.getYear() >= this.getYear() && car.getMileage() <= this.getMileage() && car.getPrice() <= this.getPrice()) 
            { 
                
				if(car.getYear() > this.getYear() || car.getMileage() < this.getMileage() || car.getPrice() < this.getPrice()) {
                   
					dominationCount++;
				}
			}
		}
	}
    public static void main(String[] args){
        Car c1= new Car("Honda","Odessey" , 18 , 2020, 132225);
        Car c2= new Car("Audi","Q8" , 14 , 2021, 155590 );
        Car c3= new Car("Tesla","X" , 20 , 2023, 350000 );


        LinkedList<Car> cars = new LinkedList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        c1.setDominationCount(cars);
        c2.setDominationCount(cars);
        c3.setDominationCount(cars);

       
        LinkedList<String> UnSortedCarNames= new LinkedList<String>();
        for(Car car : cars){
            UnSortedCarNames.add("Car : " + car.getMake() + car.getModel() + 
            " milage =" + car.getMileage() +
            " year =" + car.getYear() +
            " price =" + car.getPrice()
            );

        }
        System.out.println("List Unsorted  ");
        System.out.println(UnSortedCarNames);
       
        Collections.sort(cars, Comparator.comparing(car -> car.getMileage(),Comparator.reverseOrder())); 
        

        LinkedList<String> SortedCarNamesByMilage = new LinkedList<String>();
        for(Car car : cars){
            SortedCarNamesByMilage.add("Car : " + car.getMake() + car.getModel() + " milage =" + car.getMileage());

        }
        System.out.println(" Milage Sorted : ");
        System.out.println(SortedCarNamesByMilage);

       

        LinkedList<String> SortedCarNamesByYear = new LinkedList<String>();
        Collections.sort(cars, Comparator.comparing(car -> car.getYear(),Comparator.reverseOrder())); 
   
        for(Car car : cars){
            SortedCarNamesByYear.add("Car : " + car.getMake() + car.getModel() + " year =" + car.getYear());

        }
        System.out.println("Year sorted: ");
        System.out.println(SortedCarNamesByYear);

        
        LinkedList<String> SortedCarNamesByPrice = new LinkedList<String>();
        Collections.sort(cars, Comparator.comparing(car -> car.getPrice())); 
       
        for(Car car : cars){
            SortedCarNamesByPrice.add("Car : " + car.getMake() + car.getModel() + " price =" + car.getPrice());

        }
        System.out.println("Price sorted: ");
        System.out.println(SortedCarNamesByPrice);
    }
}