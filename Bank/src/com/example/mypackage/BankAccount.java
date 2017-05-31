package com.example.mypackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Alex on 5/26/17.
 */
public class BankAccount {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    // part 2 make thread safe using synchronize

    // solution 1
//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    // solution 2
    // synchronize smallest amount of code needed
    // better solution if large parts of methods dont need to be in sync

    public void deposit(double amount) {
        boolean status = false;
        // status is threadsafe because its a local variable
        // local variables are stored on thread stack
        // each has own copy

        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    balance += amount;
                    status = true;
                }finally{
                    lock.unlock();
                }
            }else{
                System.out.println("could not get lock");
            }
        }catch(InterruptedException e){
            System.out.println("IE");
        }
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
           try{
               if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                   try{
                       balance -= amount;
                       status = true;
                   }finally{
                       lock.unlock();
                   }
               }else{
                   System.out.println("Could not get lock");
               }

           }catch(InterruptedException e){

           }

        System.out.println("Transaction status = " + status);
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number = " + this.accountNumber);
    }


}

