package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// typed parameters

        
        // ArrayList is a raw type witout a type parameter (<Integer>)  
        // this is a diamond <> -> for implied type

        ArrayList<Integer> items = new ArrayList<>();

        items.add(1);
        items.add(2);
        items.add(4);
        // items.add("alex"); without adding Ingeger, program doesnt fail until compile time 
        items.add(110);

        printDoubled(items);

    }
    private static void printDoubled(ArrayList<Integer> n){
        for(int i : n){
            System.out.println( i * 2);
        }
    }
}
