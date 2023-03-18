package edu.umb.cs680.hw03;

public class Car 
{
    private String make, model;
    private int year;
    private int mileage;
    private float price;

    public Car(String make, String model, int year) 
    {
        super();        
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(String string, String string2, int i, int j, int k) {
    }

    public void setMileage(int mileage) 
    {
        if (mileage < 0) {
            throw new IllegalArgumentException("Mileage cannot be negative");
        }
        this.mileage = mileage;
    }

    public void setPrice(float price) 
    {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }

}
