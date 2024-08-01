package com.assignment7;

abstract class Rodent {
    public Rodent() {
        System.out.println("Rodent created.");
    }

    abstract void eat();

    abstract void run();

    public void sleep() {
        System.out.println("Rodent sleeps.");
    }
}

class Mouse extends Rodent {
    public Mouse() {
        System.out.println("Mouse created.");
    }

    @Override
    void eat() {
        System.out.println("Mouse eats cheese..");
    }

    @Override
    void run() {
        System.out.println("Mouse runs so fast..");
    }

}

class Gerbil extends Rodent {
    public Gerbil() {
        System.out.println("Gerbil created.");
    }

    @Override
    void eat() {
        System.out.println("Gerbil eats seeds.");
    }

    @Override
    void run() {
        System.out.println("Gerbil runs energetically.");
    }
}

class Hamster extends Rodent {
    public Hamster() {
        System.out.println("Hamster created.");
    }

    @Override
    void eat() {
        System.out.println("Hamster eats fruits.");
    }

    @Override
    void run() {
        System.out.println("Hamster runs in a wheel.");
    }
}

public class RodentTest {
    public static void main(String[] args) {
        Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};
        System.out.println();
        for(Rodent rodent : rodents){
            rodent.eat();
            rodent.run();
            rodent.sleep();
            System.out.println();
        }
    }
}
