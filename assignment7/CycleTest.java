package com.assignment7;

class Cycle{
    public void ride() {
        System.out.println("Cycle is being ridden.");
    }
}
class Unicycle extends Cycle{
    public Unicycle(){
        System.out.println("Unicycle created.");
    }
    public void balance(){
        System.out.println("Unicycle balances");
    }
}
class Bicycle extends Cycle {
    public Bicycle() {
        System.out.println("Bicycle created.");
    }

    public void balance() {
        System.out.println("Bicycle balances.");
    }
}
class Tricycle extends Cycle {
    public Tricycle() {
        System.out.println("Tricycle created.");
    }
}
public class CycleTest {
    public static void main(String[] args) {
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
        for(Cycle cycle : cycles){
            // cycle.balance(); ( causes error )
            cycle.ride();
            if(cycle instanceof Unicycle)
                ((Unicycle) cycle).balance();
            else if (cycle instanceof Bicycle)
                ((Bicycle) cycle).balance();
        }
    }
}
