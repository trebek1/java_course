package com.example.mypackage;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    //private static Object lock = new Object();
    private static ReentrantLock lock = new ReentrantLock(true);
    // true makes the lock a first come first serve fair lock
    // only fairness in acquiring lock
    // one thread could take a long time (no fairness in scheduling)
    // fairlocks are slower than having no fairness due to extra processing







    // Thread starvation is due to thread priority
    // Thread isnt ever given a chance to run
    // isnt first come first served for threads

    public static void main(String[] args) {
	    Thread t1 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 2");

        // removing this causes almost random except for 1st thread

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        // priority 10 does start 1st because of this
        // priority 10 frequently starts 2nd if we move it to the end

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // since just one instance of object, each thread will not block
        // OS will chose what thread to use 1st, 2nd etc...
        // thread order not maintained even though given priority

        // although lock is released frequently, often highest priority will hog all time
        // then next priority does not always go next!


    }

    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        // ctrl + i to bring up override menu

        @Override
        public void run() {
            for(int i = 0; i<100; i++){
                //synchronized (lock){
                lock.lock();
                try{
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
                } finally{
                    lock.unlock();
                    // use finally to make sure that lock is unlocked
                    // starvation may not be an issue so you might not care
                    // might be better to have starvation instead and use synchronized blocks
                }

            }
        }
    }
}

// how do you prevent starvation?
// how do you make 1st come 1st served? Fair Locks.

//can create fair locks from reentrant locks

// live locks is like deadlocks where two or more threads are waiting for others to complete
// and are always active

