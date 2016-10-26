package com.company;

public class Main {

    public static void main(String[] args) {
        BankAccount Alex = new BankAccount();
        Alex.getPhone();
        Alex.setBalance(45_000);
        Alex.withdraw(500);


        BankAccount AlexAccount = new BankAccount("Alex", "trbek@gmail.com", "4409333333");
        System.out.println(AlexAccount.getAccountNumber() + " hello "+ AlexAccount.getEmail());




    }
}
