package edu.umb.cs680.hw16.StockApp;

public class LineChartObserver implements Observer<StockEvent>{

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        

        System.out.println("Sender: " + sender + "Event: " + event);;
        
    }
}
