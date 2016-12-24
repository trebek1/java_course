package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // private public and protected
        // package private

        Account alexAccount = new Account("alex");
        alexAccount.deposit(1000);
        alexAccount.withdrawal(200);
        alexAccount.deposit(-20);
        alexAccount.deposit(10000);
        alexAccount.calculateBalance();
        System.out.println("Balance on account is " + alexAccount.getBalance());

        // public --> Anyone requiring class can modify
        //alexAccount.balance = 5000;
        System.out.println("Balance on account is " + alexAccount.getBalance());


    }
}
