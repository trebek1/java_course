package com.company;

/**
 * Created by Trebek on 12/4/16.
 */
public class Customer {

    private String name;
    private double balance;

    Customer(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
