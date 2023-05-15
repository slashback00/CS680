package edu.umb.cs680.hw16.DjiAapp;

public class ThreeDObserver implements Observer<Double>{

    @Override
    public void update(Observable<Double> sender, Double event) {
        System.out.println("ThreeDObserver: " + event);
    }
}
