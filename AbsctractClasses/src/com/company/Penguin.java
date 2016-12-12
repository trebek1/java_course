package com.company;

/**
 * Created by Trebek on 12/11/16.
 */
public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I'm not very good at that --> swim instead");
    }
}
