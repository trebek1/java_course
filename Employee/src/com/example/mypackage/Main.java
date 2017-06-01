package com.example.mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
        printEmployeesByAge(employees, "employees > 30", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 30;
            }
        });

        IntPredicate intp = i -> i > 15;
        IntPredicate intd = i -> i < 100;

        System.out.println(intp.test(10));

        // can reuse predicates
        int a = 20;
        System.out.println(intp.test(a + 5));

        // can chain predicates
        System.out.println(intp.and(intd).test(50));
        // or and negate as well

        Random random = new Random();
        for(int i =0; i<10; i++){
            System.out.println(random.nextInt());
        }

        //supplier interface
        // supplier always return a value

        // needs expected return type (integer here) since returns a value
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i =0; i<10; i++){
            System.out.println(randomSupplier.get());
        }


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
