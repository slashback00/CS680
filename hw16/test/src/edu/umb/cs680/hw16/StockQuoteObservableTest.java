package edu.umb.cs680.hw16;


import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;


import java.util.LinkedList;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw16.StockApp.LineChartObserver;
import edu.umb.cs680.hw16.StockApp.Observable;
import edu.umb.cs680.hw16.StockApp.Observer;
import edu.umb.cs680.hw16.StockApp.StockEvent;
import edu.umb.cs680.hw16.StockApp.StockQuoteObservable;
import edu.umb.cs680.hw16.StockApp.TableObserver;
import edu.umb.cs680.hw16.StockApp.ThreeDObserver;


public class StockQuoteObservableTest {

    
    @Test
    public void checkaddObserver(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);
        List<String> actual= new LinkedList<String>();
        List<Observer<StockEvent>> Observers = SQO.getObservers();
        for(Observer<StockEvent> element: Observers){
            actual.add(element.getClass().toString());
        }
        List<String> expected= new LinkedList<String>(Arrays.asList("class edu.umb.cs680.hw16.StockApp.LineChartObserver", "class edu.umb.cs680.hw16.StockApp.TableObserver" , "class edu.umb.cs680.hw16.StockApp.ThreeDObserver"));
        assertEquals(expected, actual);
    }

    @Test
    public void checkObserverremove(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);
        SQO.removeObserver(TDO);
        SQO.removeObserver(TO);
        List<String> actual= new LinkedList<String>();
        List<Observer<StockEvent>> Observers = SQO.getObservers();
        for(Observer<StockEvent> element: Observers){
            actual.add(element.getClass().toString());
        }
        
        List<String> expected= new LinkedList<String>(Arrays.asList("class edu.umb.cs680.hw16.StockApp.LineChartObserver"));
        assertEquals(expected, actual);
    }

    @Test
    public void checkObserverclear(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);
        
        SQO.clearObservers();
        List<String> actual= new LinkedList<String>();
        List<Observer<StockEvent>> Observers = SQO.getObservers();
        for(Observer<StockEvent> element: Observers){
            actual.add(element.getClass().toString());
        }
        
        List<String> expected= new LinkedList<String>(Arrays.asList());
        assertEquals(expected, actual);
    }

    @Test
    public void checkObserverscount(){
        StockQuoteObservable SQO = new StockQuoteObservable();
        LineChartObserver LCO= new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();

        SQO.addObserver(LCO);
        SQO.addObserver(TO);
        SQO.addObserver(TDO);
        
        int actual= SQO.countObservers();
        int expected=3;
        assertEquals(expected, actual);
    }

    @Test
    public void checkLEObserver(){
        StockQuoteObservable SQO = new StockQuoteObservable();
            
        Observer quoteUpdateLineChart = (Observable observable, Object obj) -> {
            System.out.println("LineChartObserver LE : "+"ticker = "+((StockEvent) obj).getTicker()+" quote = "+((StockEvent) obj).getQuote());};

        
        SQO.addObserver(quoteUpdateLineChart);
        
        List<String> actual= new LinkedList<String>();
        List<Observer<Double>> Observers = SQO.getObservers();
        for(Observer<Double> element: Observers){
            actual.add(element.getClass().toString());
        }
       
        assertNotNull(actual);
    }
   
}
