package com.company;

/**
 * Created by Trebek on 11/30/16.
 */
public class Contact {

    private String phoneNumber;
    private String name;

    public Contact(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName(){
        return name;
    }

    public static Contact createContact(String name, String phoneNumber){
        return new Contact(phoneNumber, name);
    }

}
