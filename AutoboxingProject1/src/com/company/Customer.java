package com.company;

import java.util.ArrayList;

/**
 * Created by Trebek on 12/2/16.
 */
public class Customer {
    private ArrayList<Double> transactions;
    private String name;

    Customer(double initialAmount, String name){
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);

    }

    public void addTransaction(double trans){
        this.transactions.add(trans);
    }


    public String getName(){
        return name;
    }

    public ArrayList<Double> getTransactions(){
        return transactions;
    }

}



// add additional transactions


