package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("33425345354");

    public static void main(String[] args) {



        //* create a program that implements a simple mobile phone with the following:
        // store, modify, and query contact names
        //* create a separate class for contacts (name and phone number)
        //* create a master class (mobile phone) that holds the array list of contacts
        // MobilePhone has functionality listed above
        // add a menu of options that are available
        // Options: quit, print, list contacts, add new contact, update contact, remove contact, search and find contact
        // when adding or updating, check to make sure that the contact exists
        // be sure not to expose the innerworkings of arraylist in mobile phone
        // MobilePhone should do everything with contact objects only


        boolean quit = false;

        startPhone();
        printActions();

        while(!quit){
            System.out.println("Enter action 0 to 6");
            int action = scanner.nextInt();

            switch(action){
                case 0:
                    System.out.println("shutting down");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    updateContact();
                case 3:
                    addContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    break;
            }
        }

    }




    private static void updateContact(){
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber); // in java to call method off class need static method
        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("success");
        }else{
            System.out.println("something went wrong");
        }
    }

    private static void removeContact(){
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }

        mobilePhone.removeContact(existingContactRecord);
        System.out.println("remove success");

    }

    private static void queryContact(){
        System.out.println("Enter existing contact name");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name " + existingContactRecord.getName());
    }


    private static void addContact(){
        System.out.println("Enter new contact name");
        String name = scanner.nextLine();
        System.out.println("Enter phone number ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone); // factory method (static) (no instance or object)
        if(mobilePhone.addContact(newContact)){
            System.out.println("new contact added " + name + " phone " + phone);
        }else{
            System.out.printf("cannot add naem" );
        }
    }

    private static void startPhone(){
        System.out.printf("Starting Phone");
    }

    private static void printActions(){
        System.out.println("Available actions press ");
        System.out.println(" 0 to shutdown");
        System.out.println("1 to print contacts ");
        System.out.println(" 2 to update ");
        System.out.println(" 3 to add  ");
        System.out.println(" 4 to remove contact  ");
        System.out.printf("5 query if exists ");
        System.out.println("6 print list of avail actions ");
        System.out.println( "Choose your action");
    }

}



