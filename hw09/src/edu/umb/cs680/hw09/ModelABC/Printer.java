package edu.umb.cs680.hw09.ModelABC;

public class Printer {
    private static Printer instance;

    private Printer() {
        
    }

    public static Printer getInstance() {
        if (instance == null) {
            synchronized (Printer.class) {
                if (instance == null) {
                    instance = new Printer();
                }
            }
        }
        return instance;
    }
    

    public void print(){
        System.out.println("Printing begings.....");
    }
}
