package com.company;

/**
 * Created by Trebek on 10/25/16.
 */
public class VipCustomer {
    private String name;
    private double creditLimit;
    private String email;

    public VipCustomer(){
        this("Alex", 100_000, "trebek@gmail");
    }

    public VipCustomer(String name, double creditLimit){
        this(name, creditLimit, "default@email");
    }

    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
