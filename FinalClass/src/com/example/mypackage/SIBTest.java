package com.example.mypackage;

/**
 * Created by Alex on 12/22/16.
 */
public class SIBTest {

    public static final String owner;

    static {
        owner = "alex";
        System.out.println("SIB test static initialization block called " + owner);
    }

    public SIBTest(){
        System.out.println("SIB constructor called");
    }

    static{
        System.out.println("2nd initialization block called ");
    }
    public void someMethod(){
        System.out.println("Some method called ");
    }
}
