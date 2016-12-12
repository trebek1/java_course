package com.company;

import java.util.ArrayList;

class IntClass {
    private int myValue;

    public IntClass(int myValue){
        this.myValue = myValue;
    }

    public int getMyValue(){
        return myValue;
    }

    public void setMyValue(int myValue){
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
	    String[] strArray = new String[10];
        int[] intArray = new int[10]; // positions in array zero through 9

        ArrayList<String> strArrayList = new ArrayList<String>();

        strArrayList.add("Alex");

//        ArrayList<int> intArrayList = new ArrayList<int>(); cant use primitive type in array list
        // primitives are not class types

        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));

        // autoboxing allows user to use primitive types as classes
        Integer integer = new Integer(10);
        Double doubleValue = new Double(10);

        // allows us to do ...

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();

        // autoboxing
        for(int i = 0; i<=10; i++){
            intArrayList.add(Integer.valueOf(i));
        }

        // unboxing
        for(int i = 0; i<=10; i++){
            System.out.println(i + "  ->>>> " + intArrayList.get(i).intValue());
        }

        Integer myIntValue = 56; // Integer.valueOf(56) at compile time

        Double myDoubleValue = 56.56;

        int myInt = myIntValue; // myInt.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();

        for(double dbl=0.0; dbl<=10.0; dbl +=0.5){
            myDoubleValues.add(Double.valueOf(dbl)); // can just use dbl
        }

        for(int i = 0; i<myDoubleValues.size(); i++){
            double value = myDoubleValues.get(i).doubleValue(); // dont need doubleValue
            System.out.println(i + "----> " + value);
        }
    }
}


