package edu.umb.cs680.hw15;

public class Animal {
    private AnimalPattern pattern;
    
    public Animal(AnimalPattern pattern) {
        this.pattern = pattern;
    }
    
    public void displayPattern() {
        pattern.displayPattern();
    }
}

