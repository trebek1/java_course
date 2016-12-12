package com.company;

import java.util.ArrayList;

/**
 * Created by Trebek on 12/2/16.
 */
public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);

        if(branch != null){
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);

        if(branch != null){
            return branch.addCustomerTransaction(customerName, amount);
        }else{
            return false;
        }
    }

    private Branch findBranch(String name){
        for(int i = 0; i<this.branches.size(); i++){
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(name)){
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){ //showTransactions is true if want to show transactions

        Branch branch = findBranch(branchName);

            if(branch != null){
                System.out.println("Customers for branch " + branch.getName());

                ArrayList<Customer> branchCustomers = branch.getCustomers();

                for(int i = 0; i<branchCustomers.size(); i++){
                    Customer branchCust = branchCustomers.get(i);
                    System.out.println("customers " + branchCust.getName());
                    if(showTransactions){
                        // get list of transactions
                        System.out.println("Transactions ");

                        ArrayList<Double> trans = branchCust.getTransactions();
                        for(int j = 0; j<trans.size(); j++){
                            System.out.println("transaction " + j + " " + trans.get(j));
                        }
                    }
                }
                return true;

            }else{
                return false;
            }

    }

}

// add new branch
// add new customer for branch with initial transaction
// add transaction for customer already at bank
// show a list of customers at a given branch and optionally show transactions

