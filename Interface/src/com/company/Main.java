package com.company;

public class Main {
        // static methods do not need an instantiated class to be called
    public static void main(String[] args) {
        // interface specifies methods that a particular class that implements the interface must implement (abstract)
        // common behavior for several classes

        ITelephone alexPhone; // abstract methods that must override
        //DeskPhone alexPhone; // can do this
        alexPhone = new DeskPhone(23453); // always instantiate a class

        alexPhone.powerOn();
        alexPhone.callPhone(33423432);
        alexPhone.answer();

        alexPhone = new MobilePhone(13435); // mobile phone class not desk phone
        alexPhone.powerOn();
        alexPhone.callPhone(13435);
        alexPhone.answer();

	// write your code here
    }
}
