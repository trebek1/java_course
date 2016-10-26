package com.company;

public class Main {

    public static void main(String[] args) {

        VipCustomer alex = new VipCustomer();
        VipCustomer alex2 = new VipCustomer("Alex", 9999);
        System.out.println("Fields " + alex.getEmail() + "  " + alex.getName() + "  " + alex.getCreditLimit());
        System.out.println("Fields " + alex2.getEmail() + "  " + alex2.getName() + "  " + alex2.getCreditLimit());

    }
}
