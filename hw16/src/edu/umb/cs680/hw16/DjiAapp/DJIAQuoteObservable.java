package edu.umb.cs680.hw16.DjiAapp;

public class DJIAQuoteObservable extends Observable{
    double quote;

    public void changeQuote(Double q){
        quote = q;
        notifyObservers(Double.valueOf(this.quote));
    }
}