package com.example.mypackage;

import static com.example.mypackage.ThreadColor.ANSI_GREEN;
import static com.example.mypackage.ThreadColor.ANSI_PURPLE;
import static com.example.mypackage.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {

        // a process is a unit of execution that has its own memory space
        // Each instance of JVM runs a process
        // Java Console has its own process
        // Java FX Has its own process too
        // Process and Application used interchangeably
        // Each application has its own Heap or memory space
        // 1st app cant access 2nd apps heap

        // a thread is a unit of execution within a process
        // each process can have multiple threads

        // in java each process has at least one thread, the main thread
        // for UI applications this is the JavaFX application thread
        // many processes have several threads for memory management, and IO

        // our code usually just uses the Main Thread

        // creating a thread is less resources than creating a process

        // every thread created by a process shares the process' memory and files

        // Each thread has a thread stack which is memory that only that thread can access (in addition to process' memory)

        // Why use multiple threads?
        // Perform a task that might take a long time (fetch data from a database)
        // code executes in linear fashion so we dont want to block the Main thread (main thread would be suspended)

        // Some APIs need to be given a second thread
        // provide code that will run when a method we've called reaches a certain point in its execution


        //concurrency --> application doing more than one thing at a time
        // progress can be made on more than one task. Not necessarily at the same time

        // download data and draw a shape on the screen --> download some data, draw some shape download some data...etc..
        // cant guarantee all users will see the same thing. Some prints may be done before others on different machines

        // at mercy of JVM


        System.out.println(ANSI_GREEN + "Hello from the main thread");
        // create an instance of a subclass of thread

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");

        // changing this to run shows it is running on main thread instead of its own thread
        anotherThread.start(); // start will run "run" method

        new Thread(){ // anonymous class thread
            public void run(){
                System.out.println(ANSI_RED + "Hello from the anonymous thread");
            }
        }.start();

        // pass the class that implements runnable to the new Thread

        Thread myRunnableThread = new Thread(new MyRunnable());

        myRunnableThread.start();

        Thread mySecondRunnableThread = new Thread(new MyRunnable()){
            @Override
            public void run() {
                System.out.println(ANSI_PURPLE + "Run from an anonymous implementation of run");
                try{

                    // when anotherThread terminates then this continues
                    // timeout so if thread does not terminate, will continue after timeout time
                    anotherThread.join(2000);
                    // thread class also lets you set priority but not all OS support it

                    System.out.println(ANSI_PURPLE + "Another thread terminated or timed out so i'm running again");
                }catch(InterruptedException e){
                    System.out.println(ANSI_PURPLE + "I couldn't wait after all. I was interrupted ");

                }
            }
        };

        // most developers use runnable instance since a lot of methods that want a runnable instance passed to them.
        // Lambda expressions want runable instances
        // more convenient and flexable

        // call run instead of start is a common problem. If you call run, app wont crash but instead of starting new thread,
        // runs process on same thread

        mySecondRunnableThread.start();

        // This interrupts the anotherThread and the 3 second wait does not happen
        //anotherThread.interrupt();

        System.out.println(ANSI_GREEN + "Hello again from main thread");

        // cant start a thread more than once
        //anotherThread.start();







    }
}
