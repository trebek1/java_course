package com.company;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Goldman Sachs");
        bank.addBranch("New York");
        bank.addCustomer("New York", "Alex", 1337);

        bank.addCustomer("New York", "Bryan", 133);

        bank.addBranch("Ohio");
        bank.addCustomer("Ohio", "Vic", 13);

        bank.addCustomerTransaction("New York", "Alex", 444);
        bank.addCustomerTransaction("New York", "Alex", 45);

        bank.listCustomers("Ohio", true);

    }
}
