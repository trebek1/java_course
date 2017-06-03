package com.example.mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("john doe ", 30);
        Employee tim = new Employee("tim allen", 31 );
        Employee alex = new Employee("alex tee", 11);
        Employee yuriy = new Employee("yuriy b", 15);
        Employee red = new Employee("Red hood", 35);
        Employee charming = new Employee("charming prince", 31);

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

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println(lastName);
        });

        // predicate only returns true and false
        // function interface takes a value and returns a value

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };
        // functions pass code that accepts and returns a value to a method
        // in the form as a lambda expression without creating an interface

        // accept an argument, return a value, use a function *

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        // from documentation // <input type,return type>
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String,String> getUpperFirstName = name -> name.substring(0,name.indexOf(' '));

        // chain functions together with andThen
        Function chainedFunction = upperCase.andThen(getUpperFirstName);

        // use apply to run composed function
        System.out.println(chainedFunction.apply(employees.get(0)));
        // compose is slightly different
        // functions passed run first, then original function is run
        System.out.println("VVVVVVVVVV");

        // type first, type second, return
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        // no compose method
        // using a biFunction
        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)) + " BBBBBBBBBBBBB");


        // Unary operator -- returns same type as input

        IntUnaryOperator intBy5 = i -> i + 5;


        System.out.println(intBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello World");



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

        Random random1 = new Random();
        for(Employee employee : employees){
            if(random1.nextBoolean()){
                System.out.println(getAName(getFirstName, employee));
            }else{
                System.out.println(getAName(getLastName, employee));
            }
        }

        // create lambda for each step

    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);

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
