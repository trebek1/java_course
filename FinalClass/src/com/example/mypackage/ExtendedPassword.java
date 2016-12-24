package com.example.mypackage;

import java.util.Scanner;

/**
 * Created by Alex on 12/22/16.
 */
public class ExtendedPassword extends Password {
    private int decryptedPassword;
    Scanner scanner;
    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    //@Override
//    public void storePassword() { // why you should make things final -- so they arent overwritten
//        System.out.println("saving password as " + this.decryptedPassword);
//    }
    // static initialization block
    // only done once when file loads
    // static final variable, static constructor

}
