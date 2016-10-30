package com.company;

/**
 * Created by Trebek on 10/30/16.
 */
public class Bedroom {

    private String name;
    private Wall wall1;
    private Wall wall2;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    public Bedroom(String name, Wall wall1, Wall wall2, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public Lamp getLamp(){
        return this.lamp;
    }

    public void makeBed(){
        System.out.println("bedroom  ---> Making Bed");
        bed.make();
    }
}
