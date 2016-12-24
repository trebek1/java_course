package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// typed parameters

        // array list without generics
        // this is a generic
        // this is a diamond <> -> for implied type

        ArrayList<Integer> items = new ArrayList<>();

        items.add(1);
        items.add(2);
        items.add(4);
        items.add(110);

        printDoubled(items);

    }
    private static void printDoubled(ArrayList<Integer> n){
        for(int i : n){
            System.out.println( i * 2);
        }
    }
}
