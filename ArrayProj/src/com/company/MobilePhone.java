package com.company;

import java.util.ArrayList;

/**
 * Created by Trebek on 11/23/16.
 */
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> contacts = new ArrayList<Contacts>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(Contacts contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }else{
            contacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);

        if(foundPosition <0){
            System.out.println(oldContact.getName() + " was not found");
            return false;
        }else{
            this.contacts.set(foundPosition, newContact);
            System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
            return true;
        }
    }

    public boolean removeContact(Contacts contact){
        int foundPosition = findContact(contact);

        if(foundPosition <0){
            System.out.println(contact.getName() + " was not found");
            return false;
        }

        this.contacts.remove(foundPosition);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }

    // return index of contact given contact instance
    private int findContact(Contacts contact){
        return this.contacts.indexOf(contact);
    }

    // return index given contact name
    private int findContact(String contactName){

        for(int i = 0; i<this.contacts.size(); i++){
            Contacts contact = this.contacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }

        }
        return -1;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.contacts.get(position);
        }

        return null;
    }

    public void printContacts(){
        System.out.println("contact List ");
        for(int i = 0; i < this.contacts.size(); i++){
            System.out.println((i + 1) + " . " + this.contacts.get(i).getName() + " --> " + this.contacts.get(i).getPhone());
        }
    }

    public String queryContact(Contacts contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }

}
