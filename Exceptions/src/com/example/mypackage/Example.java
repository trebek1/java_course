package com.example.mypackage;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Alex on 5/16/17.
 */
public class Example {
    public static void main(String[] args) {
        try{
            int result = divide();
            System.out.println(result);
            // java 7 you can use bitwise or
        }catch(ArithmeticException | NoSuchElementException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down ");
        }

    }
    private static int divide(){
        int x;
        int y;
       // try{
            x = getInt();
            y = getInt();
            return x/y;
       // }catch(NoSuchElementException e){
        // simplifies the stack trace
        //    throw new NoSuchElementException(   "no suitable data");
        //}catch(ArithmeticException e){
        //  throw new ArithmeticException("attempt to divide by zero");
        //}
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println( "please enter an integer");
        while(true){
            try{
                return s.nextInt();
            }catch(InputMismatchException e){
                // go round again
                s.nextLine();
                System.out.println( "enter valid numbers 0 to 9");
            }
        }
    }
}

// Thrown exceptions are passed up through calling methods
// until the program finds one that can handle the exception

// All exception objects hold the call stack trace
// all particular exceptions are subclasses of exception
// exception is a subclass of throwable
// throwing exceptions reduces stack trace code
