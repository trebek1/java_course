package com.example.mypackage;

/**
 * Created by Alex on 5/24/17.
 */
public class SharedResource {
    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    // dont want thread interference when setting
    // the worker to the resource

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }

}
