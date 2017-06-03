package com.example.mypackage;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //Challenge 1

        // write the following anonymous class as a lambda expression
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                String myString = "Let's split this into an array";
                String[] parts = myString.split( " ");
                for(String part: parts){
                    System.out.println(part);
                }
            }
        };

        // This does not map to a function in the Functions package
        // since this does not take an argument or return a value or both
        Runnable runnable1 = () -> {
            String myString = "Let's split this into an array";
            String[] parts = myString.split( " ");
            for(String part: parts){
                System.out.println(part);
            }
        };

        //Solution for part 2
        Function<String,String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i<s.length(); i++){
                if(i%2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        //Challenge 3
        // use lambda function from part 2 to print to screen

        // must use apply for running a lambda function with arguments
        System.out.println(lambdaFunction.apply("1234567890"));

//        This is ok but needs Function expression in order to work right
//        s -> {
//            StringBuilder returnVal = new StringBuilder();
//            for(int i = 0; i<s.length(); i++){
//                if(i%2 == 1){
//                    returnVal.append(s.charAt(i));
//                }
//            }
//            return returnVal.toString();
//        };


        //challenge 5
        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));

        //Challenge 6
        // write a lambda expression that maps to java.util.Supplier interface & return string "I love java;

//        public String iLoveJava = () -> {
//            return "I love java";
//        };

        // Target type of a lambda must be an interface (Supplier)
        // So supplier is basically created just so that you can return things from a lambda expression

        Supplier<String> iLoveJava = () -> {
            return "I love java";
        };

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

    }

    //challenge 4
    // use lambda in function
    public static String everySecondCharacter(Function<String,String> func, String source){
        return func.apply(source);
    }



    //Challenge 2
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i<source.length(); i++){
            if(i%2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }




}

