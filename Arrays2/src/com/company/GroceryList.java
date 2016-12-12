package com.company;

import java.util.ArrayList;

/**
 * Created by Trebek on 11/13/16.
 */
public class GroceryList {
    // define int explicitly
    //private int[] myNumbers;

    // Since ArrayList can hold anything here we specify String in <>
    // ArrayList is a constructor so we put ();
    // in this example the constructor is empty;

    private ArrayList<String> groceryList = new ArrayList<String>();



    public void addGroceryItem(String item){
        groceryList.add(item); // must use method to add element to array list

    }

    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in grocery list ");

        for(int i = 0; i<groceryList.size(); i++){
            System.out.println((i+1) + ". "  + groceryList.get(i));
        }

    }

    public void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Grocery Item " + (position + 1) + "has been modified");
    }

    public void removeGroceryItem(int position){
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }

    public String findItem(String searchItem){
        // can search manually but contains is optimized
        //boolean exists = groceryList.contains(searchItem);

        int position = groceryList.indexOf(searchItem);

        if(position >= 0){
            return groceryList.get(position);
        }

        return null;
    }
}
