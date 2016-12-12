package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("999 999 999");
    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();

        while(!quit){
            System.out.println("\n Enter action (0 -> 6)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("\n Shutting down");
                    quit = true;
                    break;
                case 1:
                    // we dont want the overall class to know that an array list is being used
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
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
                    printActions();
                    break;

            }
        }
    }

    private static void addNewContact(){
        System.out.println("Enter a name ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);

        if(mobilePhone.addNewContact(newContact)){
            System.out.println("new contact added " + name + " phone "  + phone);
        }else{
            System.out.println("Cannot add " + name + " . Already on file.");
        }
    }

    private static void startPhone(){
        System.out.println("Start phone...");
    }

    private static void printActions(){
        System.out.println("\n Available actions press ");
        System.out.println("0 to shut down \n" +
                            "1 to print contacts \n" +
                            "2 to add ontact \n" +
                            "3 to update existing \n" +
                            "4 to remove contact \n" +
                            "5 to query existing contact \n"  +
                            "6 to print list of avail actions ");
        System.out.println("Choose your action");
    }

    private static void updateContact(){
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();

        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found ");
            return;
        }

        System.out.println("Enter new contact name ");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);

        if(mobilePhone.updateContact(existingContactRecord, newContact)){
            System.out.println("successful update");
        }else{
            System.out.println("Error updating ");
        }
    }

    private static void removeContact(){
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();

        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found ");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)){
            System.out.println("successfully deleted");
        }else{
            System.out.println("error deleting record");
        }

    }

    private static void queryContact(){
        System.out.println("Enter existing contact name ");
        String name = scanner.nextLine();

        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found ");
            return;
        }

        System.out.println("Name " + existingContactRecord.getName() + " phone number " + existingContactRecord.getPhone());
    }

}
