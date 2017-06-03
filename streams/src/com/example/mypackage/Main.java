package com.example.mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    // stream: set of computational steps that are chained together

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "b50", "N40", "N36", "B12", "B6", "G53", "G49", "G60", "I26", "I29", "B52"
        );

        List<String> gNumbers = new ArrayList<>();

//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("B")){
//                // can use gNumbers since effectively final
//                gNumbers.add(number);
//               // System.out.println(number);
//            }
//        });
//
//        // dont need these types
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        // lets use a stream
        someBingoNumbers
                .stream()
                .map(String ::toUpperCase) // same as s -> s.toUpperCase(); also see notes below
                .filter(s->s.startsWith("B")) // cant infer what refs are as in "B" in example filter expects a predicate
                .sorted()
                .forEach(System.out::println); // not the iterable for each method. forEach from stream class, return type is a stream so must use stream methods
                // accepts consumer
                // for each method does not return a value
                // therefore, for each is a terminal operation
                // terminal operations return void or non stream results

                // non-terminal operations are called intermediate operations

        //:: notation is a function reference
        // use when a lambda calls an existing method
        // using string object to invoke the function toUpperCase

        //String upperString = myString.toUpperCase();
        //String upperString = toUpperCase(myString); --> This second notation allows it to be passed
        // as a reference in the map method


        // shortcut, these are the same
        //list.forEach(System.out::println);
        //(String s) -> System.out.println(s);
        //Class::method

        //stream chain process
        //when a chain is evaluated a stream pipeline is created
        // consists of source, zero or more intermediate operations and a terminal operation
        // example used collection as a source but can use array or IO channel
        // you can build a stream from scratch

        // stream of stream objects, must all be same type
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");

        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");

        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        //System.out.println(concatStream.distinct().count());
        System.out.println("==========================");
        System.out.println(concatStream.distinct().peek(System.out::println).count());// count returns double so terminal operation
        // peek lets you print out the items without ending the stream


    }
}
// stream is set of object refs
// stream creates a stream from a collection
// each obj ref corresponds to an object in the collection
// ordering matches ordering of collection
// stream method must be first call made
//stream operations have 2 reqs
// non interfearing (not change stream source in any way)
// must be stateless --> must not depend on state outside of operation
// (ex: cant be dependent on variables in a previous step)

