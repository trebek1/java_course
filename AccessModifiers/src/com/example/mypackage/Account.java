package com.example.mypackage;

import java.util.ArrayList;

/**
 * Created by Alex on 12/22/16.
 */
public class Account {
    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        if(amount > 0){
            transactions.add(amount);
            System.out.println(amount+ " amount deposited");
        }else{
            System.out.println("cannot negative sums");
        }
    }

    public void withdrawal(int amount){
        int withdrawal = -amount;

        if(withdrawal < 0){
            this.transactions.add(withdrawal);
            System.out.println(amount + "amount withdrawn");
        }else{
            System.out.println("You can't withdraw negative sums ");
        }
    }


    public void  calculateBalance(){
        this.balance = 0;

        for(int i : this.transactions){
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }



























}
