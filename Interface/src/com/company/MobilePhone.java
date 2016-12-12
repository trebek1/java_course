package com.company;

/**
 * Created by Trebek on 12/6/16.
 */
public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false;

    MobilePhone(int myNumber){
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile phone powered up ");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn){
            System.out.println("now ringing " + phoneNumber + "on mobile phone");
        }else{
            System.out.println("Phone is off");
        }

    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Answering mobile phone");
            isRinging = false;
        }

    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber && isOn){
            isRinging = true;
            System.out.println("melody ring");
        }else{
            isRinging = false;
            System.out.println("mobile phone not on or power different ");
        }
        return isRinging;
    }


    @Override
    public boolean isRinging() {
        return false;
    }
}
