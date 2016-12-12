package com.company;

import java.util.ArrayList;

/**
 * Created by Trebek on 11/30/16.
 */
public class MobilePhone {
    private ArrayList<Contact> myContacts;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact){
        // check weather or not exists
        if(findContact(contact.getName()) >= 0){

            System.out.println("Contact is already on file");
            return false;
        }else {
            this.myContacts.add(contact);
            return true;
        }
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name){
        for(int i = 0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);

            if (contact.getName().equals(name)) {
                return i;
            }
        }
            return -1;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }else{
            return null;
        }
    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition >= 0){
            this.myContacts.remove(foundPosition);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);

        if (foundPosition >= 0) {

            this.myContacts.set(foundPosition, newContact); // set takes index and new value
            return true;

        } else {
            System.out.println("Contact was not found ");
            return false;
        }
    }

    public void printContacts(){
        for(int i = 0; i<this.myContacts.size(); i++){
            System.out.println( this.myContacts.get(i).getName());
        }
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.myContacts.get(position);
        }
        return null;

    }
}





