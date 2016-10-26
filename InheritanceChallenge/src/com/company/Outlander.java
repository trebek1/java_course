package com.company;

/**
 * Created by Trebek on 10/25/16.
 */
public class Outlander extends Car {

    private int roadServiceMonths;

    public Outlander(int roadServiceMonths) {
        super("Outlander", true, true, false, 5, 5, 6, false, 1);
        this.roadServiceMonths = roadServiceMonths;
    }

    public void accelerate(int rate){
        int newVelocity = getCurrentVelocity() + rate;

        if(newVelocity == 0){
            stop();
            changeGear(1);
        }else if(newVelocity > 0 && newVelocity <=10){
            changeGear(1);
        }else if(newVelocity > 10 && newVelocity <=20){
            changeGear(2);
        }else {
            changeGear(3);
        }
        if(newVelocity > 0){
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }

}
