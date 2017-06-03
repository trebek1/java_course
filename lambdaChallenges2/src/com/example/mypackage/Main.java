package com.example.mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach(name ->
//        firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
////        firstUpperCaseList.sort((s1,s2)-> s1.compareTo(s2));
////        firstUpperCaseList.forEach(s -> System.out.println(s));
//        // challenge 10, use method references
//        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.forEach(System.out::println);

        // challenge 11 use streams

        topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        // challenge 12 print out how many names begin with the letter 'A'

        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("Number of names beginning with a is " + namesBeginningWithA);

        topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println) // use peek and sout to print result
                .sorted(String::compareTo); // no terminal operation then nothing will happen
                // could use collect or count or forEach for terminal operation
    }


}
