package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
        Series series = new Series();

        System.out.println("fibonacci " + series.fibonacci(10));
        System.out.println("factorial " + series.factorial(10));
        System.out.println("sum " + series.nSum(10));
    }
}
