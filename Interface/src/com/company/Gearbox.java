package com.company;

/**
 * Created by Trebek on 12/6/16.
 */
public class Gearbox {
    private boolean clutchIsIn;

    public void operateClutch(String inOrOut) {
        this.clutchIsIn = inOrOut.equalsIgnoreCase("in");
    }
}
