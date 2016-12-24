package com.example.mypackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer here");
        X x = new X(scanner.nextInt());
        x.x();

    }

}

