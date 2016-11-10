package com.company;

public class Main {

    public static void main(String[] args) {
	    Dimentions dimentions = new Dimentions(20,20,5);
        Case theCase = new Case("220b", "Dell", "240", dimentions);
        Monitor theMonitor = new Monitor("27 inch Beast", "Acer", 27, new Resolution(2540, 1440));
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4,6, "V2.44");

        PC thePC = new PC(theCase, theMonitor, theMotherboard);

        thePC.powerUp();


        //make a bedroom with constructor

        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("South");
        Wall wall3 = new Wall("North");

        Ceiling ceiling = new Ceiling(12,55);

        Bed bed = new Bed("Modern", 4, 3, 2);

        Lamp lamp = new Lamp("Classic " ,false);

        Bedroom bedroom = new Bedroom("Alex's Room", wall1, wall2, ceiling, bed, lamp);

        bedroom.makeBed();

        bedroom.getLamp().turnOn();






    }
}
