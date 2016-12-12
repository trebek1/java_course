package com.company;

/**
 * Created by Trebek on 12/6/16.
 */
public interface ITelephone {
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();

    // return type, function name


}
