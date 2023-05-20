package edu.umb.cs680.hw16.StockApp;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable{
    Map<String, Double> tq = new HashMap<String, Double>();

    public void changeQuote(String t, Double q){
        tq.put(t, q);
        notifyObservers(new StockEvent(t, q));
    }
}
