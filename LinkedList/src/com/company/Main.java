package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // write your code here
        // strings are variable in size
        // integers always same size
        // LL encapsulates the idea of pointers with the = sign in java

        Customer customer = new Customer("tim", 55);

        Customer anotherCustomer;

        anotherCustomer = customer;
        anotherCustomer.setBalance(10);

        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        for(int i = 0; i<intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }


        intList.add(1,2);

        for(int i = 0; i<intList.size(); i++){
            System.out.println(i + ": " + intList.get(i));
        }

    }
}
