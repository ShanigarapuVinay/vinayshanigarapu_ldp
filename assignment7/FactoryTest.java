package com.assignment7;

interface Cycle2 {
    void ride();
}

class Unicycle2 implements Cycle2 {
    public void ride() {
        System.out.println("Riding a unicycle.");
    }
}

class Bicycle2 implements Cycle2 {
    public void ride() {
        System.out.println("Riding a bicycle.");
    }
}

class Tricycle2 implements Cycle2 {
    public void ride() {
        System.out.println("Riding a tricycle.");
    }
}

interface CycleFactory {
    Cycle2 createCycle();
}

class UnicycleFactory implements CycleFactory {
    public Cycle2 createCycle() {
        return new Unicycle2();
    }
}

class BicycleFactory implements CycleFactory {
    public Cycle2 createCycle() {
        return new Bicycle2();
    }
}

class TricycleFactory implements CycleFactory {
    public Cycle2 createCycle() {
        return new Tricycle2();
    }
}

public class FactoryTest {
    public static void main(String[] args) {
        CycleFactory[] factories = {new UnicycleFactory(), new BicycleFactory(), new TricycleFactory()};
        for(CycleFactory factory : factories){
            Cycle2 cycle = factory.createCycle();
            cycle.ride();
        }
    }
}
