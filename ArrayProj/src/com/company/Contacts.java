package com.company;

/**
 * Created by Trebek on 11/23/16.
 */
public class Contacts {

    private String name;
    private String phone;

    public Contacts(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    // static allows calling of this function without a specific instance of the constructor
    public static Contacts createContact(String name, String phone){
        return new Contacts(name, phone);
    }
}





