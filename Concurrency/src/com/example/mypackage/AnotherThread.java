package com.example.mypackage;

import static com.example.mypackage.ThreadColor.ANSI_CYAN;

/**
 * Created by Alex on 5/14/17.
 */
public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "Hello from  " + currentThread().getName());
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            // catch interruptedException or interrupted method returns true on check to see an interruption
            System.out.println(ANSI_CYAN + "Another thread wake me up ");
            return; // terminates the anotherThread instance
        }
        System.out.println(ANSI_CYAN + "Three seconds have passed and I am awake ");
    }
}
