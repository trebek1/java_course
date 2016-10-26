package com.company;

/**
 * Created by Trebek on 10/25/16.
 */
public class Car extends Vehicle {

    private boolean aux;
    private boolean usb;
    private boolean satelliteRadio;
    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;


    public Car( String name, boolean aux, boolean usb, boolean satelliteRadio, int wheels, int doors, int gears, boolean isManual, int currentGear) {
        super(name);
        this.aux = aux;
        this.usb = usb;
        this.satelliteRadio = satelliteRadio;
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = currentGear;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car set current gear to " + this.currentGear);
    }

    public void changeVelocity(int speed, int direction){
        move(speed,direction);
        System.out.println("Change velocity " + speed + "direction " + direction);
    }
}
