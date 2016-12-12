package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // create a simple interface that allows object to be saved to a medium
        // interface will specify two methods, one to return an arraylist of values to be saved
        // other to populate the objects fields from an arrayList
        // create some sample classes that implement your saveable interface (game with players and monsters )
        // override toString to print easier for useral

        // in main write a method that takes an object that implements the interface as a param and saves the values
        Player alex = new Player("alex", 10, 15);

        System.out.println(alex.toString());
        saveObject(alex);

        alex.setHitPoints(25);
        System.out.println(alex);
        alex.setWeapon("sword");
        saveObject(alex);
        //loadObject(alex);
        System.out.println(alex);

        ISaveable goblin = new Monster("Goblin", 15, 3);

        // to print out strength param using get Strength must cast Monster class
        // if we didnt use implementation ISaveable but used Monster class it would work as expected
        // methods exist in class not in implementation

        System.out.println(((Monster) goblin).getStrength());
        System.out.println(goblin);
        saveObject(goblin);



    }

    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;

        System.out.println("Choose \n + " +
                "1 to enter a string \n" +
                "0 to quit");
        while(!quit){
            System.out.println("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("enter a string");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }

        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave){
        for(int i = 0; i<objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + "to storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

}





























