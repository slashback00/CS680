package edu.umb.cs680.hw16.StockApp;

public class ThreeDObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
       
        System.out.println("ThreeDObserver: " + event);
    }
}
