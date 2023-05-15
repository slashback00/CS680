package edu.umb.cs680.hw16.DjiAapp;

public class TableObserver  implements Observer<Double>{

    @Override
    public void update(Observable<Double> sender, Double event) {
       
        System.out.println("TableObserver: " + event);
    
    }
}
