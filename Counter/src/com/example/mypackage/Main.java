package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
       // Countdown countdown2 = new Countdown();

        // Setting different instances to thread 2 keeps interference from happening
        // Cant do this in real world applications. Think about bank balances not up to date in instances

        // control when threads can change a val in heap is called synchronization
        // if a class has 3 synchronized methods, only one can execute at a time

        // if same instance variables are referenced outside of it, that can cause interference


        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}

class Countdown {

    // local variables are stored in the thread stack
    // instance value is on the heap

    // This private variable is on the heap
    private int i;

    //Add keyword synchronized to make method sync (whole method to run before another thread gets access to it)
    // cant synchronize constructor

    // each object has an intrinsic lock (called a monitor)
    // only one thread can hold a lock at a time
    // primitive types dont have locks

    //can synchronize an entire method public synchronized void doCountdown(){

    public void doCountdown(){
        String color;
        switch(Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }
        // Thread interference when multiple threads are reading and writing to same resource

        // can synchronize just a block of code
        // synchronizing on color wont work since local variable color is a copy in each thread
        // cant lock this
        // could use a string? because of string pools

        // using lock on static var gives lock to static's class
        // synchronization is reentrant --> if a thread acquires lock in synchronized code calls method that is
        // also synchronized, method can keep executing since object already has the lock

        // critical section is a piece of code that references a shared resouce like a var
        // only one thread at a time should be able to execute a critical section at a time

        //Thread safe: dev has synchronized all critical sections in code so we dont have to worry about thread interference
        // Methods that isnt thread safe ---> method isn't synchronized --> not safe for multiple threads to use method

        //Methods that can only be used in synchronized code (wait, notify and notifyAll methods)

        synchronized(this){
            for( i = 10; i > 0; i--){
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }

    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;
    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }
    public void run(){
        threadCountdown.doCountdown();
    }
}
