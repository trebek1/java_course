package com.example.mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// LBYL -> Look before you leap
    // EAFP -> Get an error then deal with it
    // easier to ask forgiveness than permission

//        int x = 98;
//        int y = 0;
//
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFPI(x,y));

        int x = getIntLBYL();
        System.out.println("x is " + x);



    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();

    }

    private static int getIntLBYL(){
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer");
        String input = s.next();
        for(int i = 0; i<input.length(); i++ ){
            if(!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if(isValid){
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try{
            return s.nextInt();
            // could have caught general exception Exception e
        }catch(InputMismatchException e){
            return 0;
        }
    }

    private static int divideLBYL(int x, int y){
        if(y != 0){
            return x/y;
        }else{
            return 0;
        }
    }

    private static int divideEAFPI(int x, int y){
        try{
            return x/y;
        }catch(ArithmeticException e){
            return 0;
        }
    }

}
