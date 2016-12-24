package com.example.mypackage;

public class Main{

    public static void main(String[] args) {
	// write your code here
        // final to define constant values
        // can be modified, only once before class constructor finishes
        // first declared or in constructor

        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());


        // private constructor --> cannot instantiate new class instance
        // since static, avail without requiring an instance
        // create subclass of math? --> declare math class as final --> cannot be subclassed! (cannot extends math from other classes)



        // by making instancer numbrer final cant be changed once it is created
        //one.instanceNumber = 4;

        // final if should not be changed once set once

        // static final if you know the value at initialization. Do not store a copy in each instance.

        System.out.println(Math.PI);

        //Math m = new Math();
        // Constructor is set to private
        // all values static final so that no instances are created, no new instances

        // public final cannot extend math

        // mark methods to be final so that they cannot be extended but new instance can be created;

        int pw = 1337;

        Password password = new ExtendedPassword(pw);
        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(62);
        password.letMeIn(1337);
        // could ovrride storePassword

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("owner is " + SIBTest.owner);
        // both static blocks were called before the constructor and before any class methods



    }
}
