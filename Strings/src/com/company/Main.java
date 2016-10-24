package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //byte
        //short
        //int
        //long
        //float
        //double
        //char
        //boolean

        boolean alex = true;

        // string is really a class not a primitive type, string class
        String myString = "Alex is here ";
        System.out.println("mystring is here " + myString);

        String numberString = "250.44";
        numberString = numberString + "49.99";
        System.out.println(numberString);

        String lastString = "10";

        int myInt = 50;

        lastString = lastString + myInt;

        System.out.println(lastString);
        double doubleNumber = 120.47;
        lastString = lastString + doubleNumber;

        System.out.println(lastString);
    }
}
