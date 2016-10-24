package com.company;

/**
 * Created by Trebek on 10/24/16.
 */
public class Car {
    // public is an access modifier to see who has access to it (public == unrestricted) could use private or protected

    // state component defined as fields
    private int doors; // state components of a car
    private int wheels;
    private String model;
    private String engine;
    private String color;

    public void setModel(String model){
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }

}
