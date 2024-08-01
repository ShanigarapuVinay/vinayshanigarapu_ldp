package com.assignment7;

class Outer1{
    class Inner1{
        Inner1(String message) {
            System.out.println("Inner1 created with message: " + message);
        }
    }
}

class Outer2 {
    class Inner2 extends Outer1.Inner1 {
        Inner2(Outer1 outer1, String message) {
            outer1.super(message);
            System.out.println("Inner2 created extending Inner1 with message: "+message);
        }
    }
}
public class InnerClassTest {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Outer1.Inner1 inner1 = outer1.new Inner1("Vinay and Lahari");
        Outer2 outer2 = new Outer2();
        Outer2.Inner2 inner2 = outer2.new Inner2(outer1, "Vinay Shanigarapu");
    }

}
