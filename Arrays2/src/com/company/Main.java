package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList grocerylist = new GroceryList();
    public static void main(String[] args) {

        // array list handles resizing of array automatically
	    // write your code here

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while(!quit){
            System.out.println("Enter your choice  ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear input buffer

            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    grocerylist.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print list of grocery items");
        System.out.println("\t 2 - To add an item to modify list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item in the list");
        System.out.println("\t 5 - To search for an item in the list");
        System.out.println("\t 6 - To quit the application");
    }

    public static void addItem(){
        System.out.print("Please enter the grocery Item ");
        grocerylist.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){

        // enter item number to  modify
        System.out.println("Enter item number to modify ");
        int itemNo = scanner.nextInt();
        scanner.nextLine(); // clearing buffer

        // set item to replace current
        System.out.println("Enter replacement item ");
        String newItem = scanner.nextLine();

        grocerylist.modifyGroceryItem(itemNo-1, newItem);
    }

    public static void removeItem(){

        // enter item number to  modify
        System.out.println("Enter item number to modify ");
        int itemNo = scanner.nextInt();
        scanner.nextLine(); // clearing buffer
        grocerylist.removeGroceryItem(itemNo - 1);
    }

    public static void searchForItem(){
        System.out.println("Item to search for : ");
        String searchItem = scanner.nextLine();
        if(grocerylist.findItem(searchItem) != null){
            System.out.println("Found " + searchItem + " in our grocery list ");
        }else{
            System.out.println(searchItem + " is not in our grocery list ");
        }
    }
}
