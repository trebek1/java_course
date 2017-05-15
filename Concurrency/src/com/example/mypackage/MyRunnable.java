package com.example.mypackage;

import static com.example.mypackage.ThreadColor.ANSI_BLUE;

/**
 * Created by Alex on 5/14/17.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from my runnables implementation of run ");
    }
}
