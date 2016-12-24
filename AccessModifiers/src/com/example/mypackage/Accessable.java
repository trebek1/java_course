package com.example.mypackage;

/**
 * Created by Alex on 12/22/16.
 */
public interface Accessable { // all clases in package (package private)
    int SOME_CONSTANT = 100; // all public static final
    public void methodA(); // all interface methods automatically public
    void methodB();
    boolean methodC();
}

// interface is visible to whoever inherits from it
// int var is visible anywhere interface is instantiated
// a,b,c all visible wherever interface is used ( and required)
