package com.java.learn.main;

import java.time.LocalDateTime;

public class NamingConventions {
    private static final double VALUE_OF_PI = 3.14159;

    public static int areaOfTriangle(int length, int width) {
        return length * width;
    }

    public static void main(String[] args) {
        System.out.println("The value of Pi is: " + VALUE_OF_PI);

        // Calculate and print the area of a rectangle
        int length = 10, width = 20;
        System.out.println("Area of Triangle: " + areaOfTriangle(length, width));

        // Demonstrate StringBuilder usage
        StringBuilder message = new StringBuilder("Vinay");
        message.append("Shanigarapu");
        System.out.println(message);

        // Local date time demonstration
        LocalDateTime currDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currDateTime.plusDays(20).plusHours(12).plusMinutes(30);
        System.out.println("Current Date and Time : " + currDateTime);
        System.out.println("Future Date and Time : " + futureDateTime);
    }
}
