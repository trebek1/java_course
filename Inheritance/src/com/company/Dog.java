package com.company;

/**
 * Created by Trebek on 10/25/16.
 */
public class Dog extends Animal{

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        // call constructor for class extending from
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew(){
        System.out.println("Dog chew called");
    }

    public void walk(){
        System.out.println("Dog.walk called ");
        super.move(5); // showing how if you use super you cant override from Dog class
    }

    public void run(){
        System.out.println("Dog.run called");
        move(10); // here will be overwritten with the override below
    }

    private void moveLegs(int speed){
        System.out.println("Dog.moveLegs() called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move called");
        moveLegs(speed);
        super.move(speed);
    }

    @Override
    public void eat() {
        // this is called with dog.eat in main!
        System.out.println("dog.eat called");
        chew();
        super.eat();
    }
}
