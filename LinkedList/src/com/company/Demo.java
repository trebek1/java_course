package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by Trebek on 12/5/16.
 */
public class Demo {
    public static void main(String[] args) {
        // psvm <tab>

        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "New York");
        addInOrder(placesToVisit, "Avon Lake");
        addInOrder(placesToVisit, "LA");
//        placesToVisit.add("Sydney");
//        placesToVisit.add("New York");
//        placesToVisit.add("Avon Lake");
//        placesToVisit.add("London");

        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs ");
        addInOrder(placesToVisit, "LA");
        visit(placesToVisit);

//        placesToVisit.add(1, "Australia");
//        placesToVisit.remove(4);
//        printList(placesToVisit);

    }
        private static void printList(LinkedList<String> linkedList){
            // iterator

            Iterator<String> i = linkedList.iterator();
            while(i.hasNext()){
                System.out.println("Visiting " + i.next()); // move to next, print value, i++
            }
        System.out.println("===============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList,String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        // must use .next to get to the first entry
        // shouldn't use .next, not good modify LL

        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0){
                // equal do not add
                System.out.println(newCity + " is already in the list ");
                return false;
            }else if(comparison > 0){
                // new city shold appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }else{
                // move onto next city

            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("No cities in the itinerary");
            return;
        }else{
            System.out.println("now visiting " + listIterator.next());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){

                case 0:
                    System.out.println("Holiday vacation over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){ // going toward the end of the list
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    }else{
                        System.out.println("Reach the end of the list ");
                    }
                    break;
                case 2:
                    if(goingForward){ // going toward the head of the list
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("now visiting " + listIterator.previous());
                        break;
                    }else{
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                        break;
                    }
                case 3:
                    printMenu();
                    break;
                default:
                    break;
            }

        }

    }


    private static void printMenu(){
        System.out.println("Available actions press ");
        System.out.println("0 -- to quit \n" +
        " 1 - go to next city \n" +
        " 2 - go to previous city\n + " +
                " 3 -- print menu options");
    }

}
