package com.example.mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "b50", "N40", "N36", "B12", "B6", "G53", "G49", "G60", "I26", "I29", "B52"
        );

        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers
                .stream()
                .map(String ::toUpperCase) // same as s -> s.toUpperCase(); also see notes below
                .filter(s->s.startsWith("B")) // cant infer what refs are as in "B" in example filter expects a predicate
                .sorted()
                .forEach(System.out::println); // not the iterable for each method. forEach from stream class, return type is a stream so must use stream methods

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        System.out.println("==========================");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());// count returns double so terminal operation

        Employee alex = new Employee("Alex Trz", 25);
        Employee john = new Employee("john roberts", 26);
        Employee jane = new Employee("gi jane", 27);
        Employee jack = new Employee("jack hammer", 28);
        Employee joe = new Employee("joe buck", 29);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(joe);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(alex);
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
        System.out.println( "-------------------");
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                // supplier, accumulator, combiner

        for(String s : sortedGNumbers){
            System.out.println(s);
        }

        // Collectors.groupingBy method
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream().flatMap(department ->  department.getEmployees().stream())
                .reduce((e1,e2) -> e1.getAge() < e2.getAge() ? e1: e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    // this will not be printed because of lazy evaluation
                    // nothing happens until there is a terminal operation
                    return s.length() == 3;
                })
                .count();
            // to see the counted number this would need to be saved to a variable and printed

    }
}

//Flatmap
// accepts a function that returns a stream value
// stream returns with several objects

//Collect Method
// terminal operation
// return a differenet type than was input

// if want arraylist rather than list can use more specific collect method

//Reduce method
// combine all to single result
// 3 types
// 1). Reduce to one element of the stream
// use ifPresent because result is optional
// reduce is a terminal operation in this case

// cant reuse a stream (illegal state exception)
// lazy evaluation -> intermediate functions are not carried out until there is a terminal operation
// parallel streams for increased performance

// could get parallel stream from a collection using parallelStream method from a collection

// trade off between conciseness and readability with lambdas
// leaving off types can make it harder to figure out what the expression is doing months or years later
// even though it is not required for the compiler to operate on the code

// be consistent in a project
// dont include in some places and not include in others


