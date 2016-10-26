package com.company;

/**
 * Created by Trebek on 10/24/16.
 */
public class BankAccount {
    private double balance;
    private int accountNumber;
    private String customer;
    private String email;
    private String phone;

    public BankAccount(){
        this(2500, 0001,"default", "somewhere@nowhere.com","4409331234");
        System.out.println("empty constructor called");
    }

    public BankAccount(double balance, int accountNumber, String customer, String email, String phone) {
        System.out.println("bankAccount constructor called with parameters called");
        // dont use setters in constructor because subclassing wont always work

        this.balance = balance;
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.email = email;
        this.phone = phone;
    }



        // this sets default value for balance and account number while creating the fields for the other settings
    public BankAccount(String customer, String email, String phone) {
        this(100.55, 9999, customer, email, phone);
        this.customer = customer;
        this.email = email;
        this.phone = phone;
    }



    // setting defaults for this constructor created based on the class

    public void getBalance(){
        System.out.println("Your balance is " + this.balance);
    }

    public int getAccountNumber(){
        System.out.println("Your account number is " + this.accountNumber);
        return this.accountNumber;
    }

    public String getCustomer(){
        System.out.println("The customer is " + this.customer);
        return this.customer;
    }

    public String getEmail(){
        System.out.println("The email is " + this.email);
        return this.email;
    }

    public String getPhone(){
        System.out.println("The phone number is " + this.phone);
        return this.phone;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAccountNumber(int num){
        this.accountNumber = num;
    }

    public void setCustomer(String name){
        this.customer = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void deposit(double amount){
        this.balance += amount;
        System.out.println("you have " + this.balance + " in your account");
    }

    public void withdraw(double amount){
        if(amount <= this.balance){
            this.balance -= amount;

            System.out.println("you have " + this.balance + " in your account");

        }else {
            System.out.println("Insufficient Funds, you only have " + this.balance + " in the bank");
        }
    }



}
