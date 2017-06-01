package com.example.mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("john doe ", 30);
        Employee tim = new Employee("tim ", 31 );
        Employee alex = new Employee("alex", 11);
        Employee yuriy = new Employee("yuriy ", 15);
        Employee red = new Employee("Red hood", 35);
        Employee charming = new Employee("charming ", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(alex);
        employees.add(yuriy);
        employees.add(red);
        employees.add(charming);

        printEmployeesByAge(employees, "employees over 30", employee -> employee.getAge() > 30);
        System.out.println("XXXXXXXXXXXX");

        // consumer is functional interface with method accept
        // use f1 to show notes on hover
        // consumer --> something in, nothing out

        employees.forEach(employee ->{
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        System.out.println("employees over 30 ");
        System.out.println("++++++++++++++");
        // lambda expression of below loop
        employees.forEach( employee -> {
            if(employee.getAge() > 30){
                System.out.println(employee.getName());
            }
        });

        // classic loop

//        for(Employee employee : employees){
//            if(employee.getAge() > 30){
//                System.out.println(employee.getName());
//            }
//        }

    }
    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){

        System.out.println(ageText);
        System.out.println("++++++++++++++");

        for(Employee employee : employees){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        };

    }
}
