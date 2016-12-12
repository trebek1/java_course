package com.company;

/**
 * Created by Trebek on 12/11/16.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name); // calls constructor in animal class
    }

    // interface is completely abstract
    // no opportunity to add fields

    // abstract classes can have constructors and fields and certain methods can be abstract like an interface

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in and breathe out ");
    }
}
