package com.example.mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        // easier way to work with interfaces with one method

//        new Thread(new CodeToRun()).start();
//
//        new Thread(new Runnable(){
//            @Override
//            public void run(){
//                System.out.println( "printing from runner");
//            }
//
//        }).start();
        // lambda added in java 8
        new Thread(()-> {
            System.out.println("printing from runnable ");
            System.out.println("line 2");
        }).start();

        Employee john = new Employee("john doe ", 30);
        Employee tim = new Employee("tim ", 31 );
        Employee alex = new Employee("alex", 11);
        Employee yuriy = new Employee("yuriy ", 15);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(alex);
        employees.add(yuriy);

        // when an enhanced for loop is use a new local variable is
        // created for each iteration of the loop
        // variables are effectively final

        for(Employee employee : employees){
            System.out.println(employee.getName());
            new Thread(()-> System.out.println(employee.getAge())).start();
        }

        // also effectively final since new variable made for each iteration
        // could not declare employee variable outside the loop
        for(int i = 0; i< employees.size(); i++){
            Employee employee = employees.get(i);
            System.out.println(employee.getName());
            new Thread(()-> System.out.println(employee.getAge())).start();
        }
        // forEach iterator added for lambdas
        // lambdas are syntactic sugar!
        // 1st step into functional programming (computing results based)

        employees.forEach(employee ->{
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });






//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(employee1, employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        Collections.sort(employees,(employee1,employee2)-> {
           return employee1.getName().compareTo(employee2.getName());
        });





        // a functional interface can be used as the assignment targret for a lambda expression or method interface
        // functional interface only has one method that has to be implemented



        for(Employee employee : employees){
            System.out.println(employee.getName());
        }

        // argument list, arrow, body
        // functional interfaces
//        String sillyString = doStringStuff(new UpperConcat(){
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s2.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        UpperConcat uc = (String s1, String s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase(); // semicolons req after every line
            return result; // return keyword required for more than one statement
        };

        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);




        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

    }// end of main here



    public static final String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);
    };

}

//class CodeToRun implements Runnable{
//    @Override
//    public void run(){
//        System.out.println(" running from Runnable ");
//    }
//}


class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2 );
}

class AnotherClass {
    public String doSomething(){
//            UpperConcat uc = (s1,s2) -> {
//                System.out.println("the lambda expressions class name is " + getClass().getSimpleName());
//                // this is anotherclass so therefore lambdas are treated like blocks of code
//                // this has same scope as a nested block
//
//                // while anonymous functions do not have scope of outer class (must have final vars declared)
//                String result = s1.toUpperCase() + s2.toUpperCase();
//                return result;
//            };

        int i = 0;
        // anonymous classes have to have final variables
        // cant use local variables
        // vars dont belong to class

        // essentially a lambda
        // cant get to vars out of enclosing block
        // can use unchanged vars from outer scope

        int j = 0;
        {
            String s1 = "test1";
            String s2 = "test2";

            System.out.println("lambda expression class is " + getClass().getSimpleName());
            System.out.println("j " + j);
        }

        UpperConcat uc = (s1, s2) -> {
            System.out.println("lambda expression class is " + getClass().getSimpleName());
            System.out.println("i " + i);
            // variables must be effectively final to be used in lambda block
            // copied when lambda created with initial value
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

//        UpperConcat uc = new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("I in anonymous class " +    i);
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        };
        System.out.println("The anotherclass classes name is " + getClass().getSimpleName());
       // i++;
        return Main.doStringStuff(uc, "String1337", "String2" );






//        System.out.println( "The anotherclass class's name is " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println( "The anonymous class's name is " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String 1", "string2");
    };

    public void printValue(){
        int number = 25;
        Runnable r = () -> {
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Rhe value is " + number);

        };
        new Thread(r).start();
    }
}
