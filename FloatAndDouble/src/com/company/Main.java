package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // float and double
        // double has twice as much detail as float

        //width of int is 32 bits = 4bytes of storage requires
        int myIntValue = 5/6;

        //width of float is 32 bits = 4 bytes of storage
        float myFloatValue = 5/6f; // f will typecast to float

        //width of double is 64 bits = 8 bytes of storage
        double myDoubleValue = 5/6d; // assumption of decimal point is double

        System.out.println("myIntValue " + myIntValue);
        System.out.println("myFloatValue " + myFloatValue);
        System.out.println("myDoubleValue " + myDoubleValue);

        double pounds = 200d;

        double kilograms = pounds * 0.45359237d;

        System.out.println("kilograms " + kilograms);

        double pi = 3.141_592_7d;




    }
}
