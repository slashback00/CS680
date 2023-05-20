package edu.umb.cs680.hw16;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw16.DjiAapp.DJIAQuoteObservable;
import edu.umb.cs680.hw16.DjiAapp.LineChartObserver;
import edu.umb.cs680.hw16.DjiAapp.Observable;
import edu.umb.cs680.hw16.DjiAapp.Observer;
import edu.umb.cs680.hw16.DjiAapp.TableObserver;
import edu.umb.cs680.hw16.DjiAapp.ThreeDObserver;

public class DJIAQuoteObservableTest 
{
       

    @Test
    public void testDJIAQuoteObservable() {
        DJIAQuoteObservable subject = new DJIAQuoteObservable();
        LineChartObserver lineChartObserver = new LineChartObserver();
        TableObserver tableObserver = new TableObserver();
        ThreeDObserver threeDObserver = new ThreeDObserver();
        subject.addObserver(lineChartObserver);
        subject.addObserver(tableObserver);
        subject.addObserver(threeDObserver);
        subject.changeQuote(5.5);
        subject.changeQuote(10.5);
        subject.changeQuote(15.5);
        // Assert something here if needed
    }

    @Test
    public void checkDJIAQuoteObservable() {
        DJIAQuoteObservable observable = new DJIAQuoteObservable();
        LineChartObserver lineChartObserver = new LineChartObserver();
        TableObserver tableObserver = new TableObserver();
        ThreeDObserver threeDObserver = new ThreeDObserver();
        observable.addObserver(lineChartObserver);
        observable.addObserver(tableObserver);
        observable.addObserver(threeDObserver);
        observable.changeQuote(1000.0);
        observable.clearObservers();
        assertEquals(0, observable.countObservers());
    }

    @Test
    public void checkObserverRemove() {
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        LineChartObserver LCO = new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();
        DQO.addObserver(LCO);
        DQO.addObserver(TO);
        DQO.addObserver(TDO);
        DQO.removeObserver(TDO);
        DQO.removeObserver(TO);
        assertEquals(1, DQO.getObservers().size());
        assertEquals(LCO.getClass().toString(), DQO.getObservers().get(0).getClass().toString());
    }
    
    @Test
    public void checkObserversCount() {
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        LineChartObserver LCO = new LineChartObserver();
        TableObserver TO = new TableObserver();
        ThreeDObserver TDO = new ThreeDObserver();
        DQO.addObserver(LCO);
        DQO.addObserver(TO);
        DQO.addObserver(TDO);
        assertEquals(3, DQO.countObservers());
    }

    @Test
    public void checkLEObserver() {
        DJIAQuoteObservable DQO = new DJIAQuoteObservable();
        Observer quoteUpdateLineChart = (Observable Sender, Object event) -> {
            System.out.println("LineChartObserver..." + "Sender : " + Sender + "Event:" + event);
        };
        DQO.addObserver(quoteUpdateLineChart);
        assertEquals(1, DQO.getObservers().size());
    }

}
    
    

