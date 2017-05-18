package com.example.mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.example.mypackage.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
	    List<String> buffer = new ArrayList<String>();
	    ReentrantLock bufferLock = new ReentrantLock();
	    // not all implementations of lock are reentrant
        // all threads need to compete for same lock to prevent thread interference


        ExecutorService executorService = Executors.newFixedThreadPool(3);




        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
	    MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
	    MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        // new Thread(producer).start();
        // new Thread(consumer1).start();
        // new Thread(consumer2).start();

        //Using ExecutorService package instead of the above
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        // submit method to recieve a message back from a thread
        Future<String> future = executorService.submit(new Callable<String>(){
         @Override
            public String call() throws Exception{
             System.out.println(ThreadColor.ANSI_GREEN + "I'm being printed frm the callable class");
             return "This is the callable result";
            }
        });
        try{
            // /blocks until result is available
            System.out.println(future.get());
        }catch(ExecutionException e){
            System.out.println("Something went wrong ");
        }catch(InterruptedException e){
            System.out.println("Thread running task was interrupted");
        }
        // Have to remember to terminate the application manually
        executorService.shutdown();
        // Wont shut down until all threads are done running

    }
}

class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4","5"};

        for(String num : nums){
            try{
                System.out.println( color + "adding..." + num);
                bufferLock.lock();
                try{
                    buffer.add(num);
                } finally{
                    // finally code is executed no matter what
                    // if exception in try block still executed
                    bufferLock.unlock();
                }
                // must manually unlock the lock after execution
                //synchronized would automatially do this

                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
                System.out.println("producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
            bufferLock.lock();
            try{
                buffer.add("EOF");
            }finally{
                bufferLock.unlock();
            }


    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run(){

        int counter = 0;

        while(true){
            // if the lock is available, do the code
            if(bufferLock.tryLock()){
                try{
                    if(buffer.isEmpty()){
                        continue;
                    }
                    System.out.println(color + "The counter = " + counter);
                    if(buffer.get(0).equals(EOF)){
                        System.out.println( color + "Exiting");
                        break;
                    }else{
                        System.out.println( color + "removed " + buffer.remove(0));
                    }
                }finally{
                    bufferLock.unlock();
                }
            }else{
                counter++;
            }

        }
    }
}

// doing this type of synchronization not all threads get the same opportunity
// 1st one to be blocked may be the last to be unblocked
//-- blocked cant be interrupted
//-- stuck until getting lock that it is synchronizing on
//
//-- synchronized block must be in same method
//
//-- cant test to see if objects intrinsic lock is available
//
//-- cant timeout after waiting for lock for a while
//
//-- not first come first served if multiple threads are trying to use lock

//-- Lock instance does not have these problems

// cant release lock until lock count = 0

// use a try finally block to call unlock in one place
//  code in critical section could throw exception not explicitly handled in try catch

//java.lang.IllegalMonitorStateException if try to unlock a lock that the object doesnt own

// fairness parameter can be added to use thread that has been waiting the longest

// getQueuedLength method returns number of waiting threads

// lock API http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/Lock.html

// executor service implementation --> give list of things to be done, dont worry about
// how they will be done

// thread pool --> managed set of threads
// reduces overhead of thread creatation
// manage number of active threads
// thread pools keep application from running lots of threads and getting blocked

// execute method in executor service interface
// execute is replacement for : (new Thread(r)).start();
// using execute: ex.execute(r);    \

// Fixed Thread pool : specific # of threads available to do tasks at one time
// Other tasks wait in a queue

