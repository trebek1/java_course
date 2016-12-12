package com.company;

/**
 * Created by Trebek on 12/11/16.
 */
public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void breathe();

    public String getName() {
        return name;
    }

    // force class that implements to implement each.
}
