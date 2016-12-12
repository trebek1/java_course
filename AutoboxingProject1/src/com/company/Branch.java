package com.company;

import java.util.ArrayList;

/**
 * Created by Trebek on 12/2/16.
 */
public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    Branch(String name){
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public String getName(){
        return name;
    }

    public boolean newCustomer(String customerName, double initialAmount){

        if(findCustomer(customerName) == null){
            this.customers.add(new Customer(initialAmount, customerName));
            return true;
        }else{
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double amount){

        Customer existingCustomer = findCustomer(customerName);

        if(existingCustomer != null){
             existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String name){
        for(int i = 0; i<this.customers.size(); i++){
            Customer checkedCust = this.customers.get(i);
            if(checkedCust.getName().equals(name)){
                return checkedCust;
            }
        }

        return null;
    }

}



// add a new customer
// add initial transaction amount
// add additional transactions for branch