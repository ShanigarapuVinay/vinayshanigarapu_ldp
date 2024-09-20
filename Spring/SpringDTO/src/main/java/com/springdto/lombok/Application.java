package com.springdto.lombok;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee(1,"Vinay", 200000);
        System.out.println(employee);
        System.out.println(employee.getName());
        employee.setName("Lahari");
        System.out.println(employee);
    }
}
