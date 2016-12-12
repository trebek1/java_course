package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        // write your code here
        // four types of nexted classes
        // static nested classes --> associate class w/ outer class
        // non-static nested classes (inner class)
        // local class -> inner class defined in a scope block (method)
        // anonymous class --> nested class wo class name

        GearBox mcLaren = new GearBox(6);
        // inner class new definition
//        GearBox.Gear first = mcLaren.new Gear(1,12.3);
//        System.out.println(first.driveSpeed(1000));

        //GearBox.Gear second = new GearBox.Gear(2,15.4); does not work
        //GearBox.Gear third = new mcLaren.Gear(3,17.8); also does not work

        // part 2

//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(1);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(1000));
//        mcLaren.changeGear(2);
//        System.out.println(mcLaren.wheelSpeed(3000));
//        mcLaren.operateClutch(true);
//        mcLaren.changeGear(3);
//        mcLaren.operateClutch(false);
//        System.out.println(mcLaren.wheelSpeed(6000));

        // part 2 of video series

//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("i've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//
//        btnPrint.setOnClickListener(new ClickListener());

        // Anonymous class now

        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + "Was clicked");
            }
        });

        listen();
    }
        private static void listen(){
        boolean quit = false;
        while(!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
            }

        }
    }

}

