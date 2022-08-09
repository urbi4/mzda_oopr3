package com.company;

public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee("Petr",29000,1000,false);
        Employee employee1 = new Employee("Jan",19000,15000,true);
        Employee employee2 = new Employee("Zuzana",5000,1000, true);
        Employee employee3 = new Employee("Radim", 18500,0,false);
        System.out.println(employee);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
    }
}
