package com.company;

/**
 * Created by Trebek on 12/11/16.
 */
public class Parrot extends Bird {
    public Parrot(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Flying from branch to branch");
    }
}
