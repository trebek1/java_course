package com.company;


import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);

        for(int i = 0; i<myIntegers.length; i++){
            System.out.println("Element " + i + " typed value " + myIntegers[i]);
        }

        // initialize an array with 10 spots
        double[] myDoubleArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // shortcut to create 10 spot array and assign values

        // myIntArray[5] = 50; Save Value 50 to element 6

        // System.out.println(myDoubleArray[5]); retrieve the value
        // cant put double in integer array

        System.out.println(myDoubleArray[8]);

        int[] myIntArray = new int[15];

        for (int i = 0; i < myIntArray.length; i++) {
            myIntArray[i] = i * 10;
        }

        printArray(myIntArray);

        System.out.println("The average is " + getAverage(myIntegers));

    }

    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values \r");

        int[] values = new int[number];

        for(int i = 0; i<values.length; i++){
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static void printArray(int[] array){
            for(int i =0; i<array.length; i++){
                System.out.println("Element " + i + " value is " + array[i]);
            }
        }

    public static double getAverage(int[] array){
        int sum = 0;
        for(int i =0; i<array.length; i++){
            sum+= array[i];
        }

        return (double)sum/(double)array.length;

    }

        //.length is a method on myIntArray

    }
