package com.company;

/**
 * Created by Trebek on 10/25/16.
 */
public class Vehicle {

    private String name;
    private int currentVelocity = 0;
    private int currentDirection = 0;

    public Vehicle(String name) {

        this.name = name;
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction){
        this.currentDirection += direction;
        System.out.println("steering at " + currentDirection);
    }

    public void move(int velocity, int direction){
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("vehicle moving at " + currentVelocity + "in the direction " + currentDirection);
    }


    public String getName() {
        return name;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void stop(){
        this.currentVelocity = 0;
    }
}
