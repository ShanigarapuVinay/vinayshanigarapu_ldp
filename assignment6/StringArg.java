package com.assignment6;

public class StringArg {
    public StringArg(String arg){
        System.out.println("Constructor called with argument: " + arg);
    }

    public static void main(String[] args) {
        // Array of references without object creation
        StringArg[] array1 = new StringArg[5];

        // Creating objects and attaching to array
        StringArg[] array2 = new StringArg[5];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = new StringArg("Object " + (i + 1));
        }
    }
}
