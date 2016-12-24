package com.example.mypackage;

/**
 * Created by Alex on 12/22/16.
 */
public class SomeClass {


    private static int classCounter = 0;
    public final int instanceNumber; // initialize in the constuctor if result from other code // cant change when the instance is created
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter; // can be declared once, unique database key that is read once database is accessed
        System.out.println(name + " created instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
