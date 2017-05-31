package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
        final Worker worker1 = new Worker("worker 1", true);
        final Worker worker2 = new Worker("worker 2 ", true);

        final SharedResource sharedResource = new SharedResource(worker1);

        new Thread(new Runnable() {
            @Override
            public void run(){
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run(){
                worker2.work(sharedResource, worker1);
            }
        }).start();
    }
}

// livelock when both just hand resource back to each other instead of getting to final lines of code and finishing

// Next potential problem that can arise from multi-threaded application is called slipped condition
// thread suspended between reading a condition and acting on it

// example
// two threads reading from a buffer
// checks status
// if ok, reads data from buffer
// if data is EOF, sets status to eof and terminates, if not eof, sets status to ok
// if not synchronized properly, the following can happen....

// Thread1 checks status and gets OK, it suspends
// thread2 checks status and gets ok, reads eof and sets status to EOF an terminates

// thread1 runs again. it tries to read data from buffer but there is no data and throws an exception and crashes

// thread1 acted on obsolete data

// slipped condition is a particular type of race condition.
// must use synchronized blocks or locks to fix code.
// --> placement of synchronization may cause problem still
// with multiple locks, the order in which locks can be acquired can result in slipped condition

//Atomic actions
// cant be stopped in the middle of while running on a thread
// reading and writing reference variables
// reading and writing primitive variables except long and doubles
// system.out.println is NOT an atomic action
// reading and writing all varaibles definied as volatile

// Volatile variables
// still need to worry about thread interference with atomic actions
// each thread has a cpu cache that can contain copies of values in main memory
// can still get interference when multiple threads are reading and writing to same variables

// multiple cpus in computers, multiple cached copies, can get out of sync
// memory consistency errors

// volatile variables solve this problem
// volatile variables guarantee that once a value is updated in its cpu cache that the value is
// immediately updated in the main memory

// also guarantees that when a variable is read from memory it is given the most up to date value

//still may need to synchronize volatile variables

//example counter++

//note: not an atomic operation

//1). Read value of counter from memory
//2). Add 1 to counter
//3). write new value of counter back to memory

// thread could be suspended after any of these steps

// both threads could read the value of the counter and get 1.
// Then both update to 2 but should be 3!
// value was stale when the second counter updated

// common to use volatile when reading and writing longs and doubles (not atomic)
// using volatile makes them atomic but still need to synchronize them
// same case as before, when program takes value and updates based on old value (may be stale)

// if only 1 thread is used or none of the threads update a value of a shared variable in a way that depends on the
// existing value the volatile keywords DOES mean that we dont need synchronization
// java.util.concurrent.atomic package solves issue of worrying about memory inconsistencies
// can use AtomicInteger for thread safe, lock free programming on single variables

//private AtomicInteger counter = new AtomicInteger(0);
// has own methods
// counter.incrementAndGet();
// counter.decrementAndGet();
// here we dont have to synchronize the code in any way
// limited number of methods. Cant replace integer object
// atomic versions of boolean, integer, integer array, long, long array, object reference and double
// intented for counters and vars that are updated for some reason


// volatile --> solves difference between cpu cache and main value
// synchronization makes sure that multiple threads cant be changing the value from multiple places at the same time

// compareAndSet method, (expect value and new value) if current value doesnt equal expected value
// method returns false and set doesn't take place
// useful if thread knows that it might be suspended between getting value and updating it






