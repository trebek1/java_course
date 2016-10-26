package com.company;

/**
 * Created by Trebek on 10/26/16.
 */
public class Car extends Vehicle {

    //these are called fields!
    private int doors;
    private int engineCapacity;

    public Car(String name, int doors, int engineCapacity) {
        super(name);
        this.doors = doors;
        this.engineCapacity = engineCapacity;
    }
}
