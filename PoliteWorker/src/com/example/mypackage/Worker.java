package com.example.mypackage;

/**
 * Created by Alex on 5/24/17.
 */
public class Worker {
    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker){
        while(active){
            // see if the worker has the resource,
            // if not, wait 10 seconds and try again

            if(sharedResource.getOwner() != this){
                try{
                    wait(10);
                }catch(InterruptedException e){

                }
                continue;
            }
            // if we do own the resource, check to see if the thread is active

            if(otherWorker.isActive()){
                System.out.println(getName() + " : give the resource to the worker " + otherWorker.getName());
                // if it is, politely give the resource to the other thread
                sharedResource.setOwner(otherWorker);
                continue;
            }

            // case where owns resource and the other thread is not active
            System.out.println(getName() + " : working on the common resource");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }
}


