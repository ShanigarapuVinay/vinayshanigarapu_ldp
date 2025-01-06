package com.assignment6;

public class OverloadedConstructors {
    private int value;
    private String name;
    public OverloadedConstructors(int value){
        this(value, "Vinay");
    }
    public OverloadedConstructors(int value, String name){
        this.value = value;
        this.name = name;
        System.out.println("Constructed with value: " + value + " and name: " + name);
    }

    public static void main(String[] args) {
        OverloadedConstructors obj = new OverloadedConstructors(7);
        OverloadedConstructors obj2 = new OverloadedConstructors(15, "Lahari");
    }
}
