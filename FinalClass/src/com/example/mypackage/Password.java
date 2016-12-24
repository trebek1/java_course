package com.example.mypackage;

/**
 * Created by Alex on 12/22/16.
 */
public class Password {
    private static final int key = 35144012;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password){
        return password ^ key;
    }

    public final void storePassword(){
        System.out.println("saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password){
        if(encryptDecrypt(password) == this.encryptedPassword){
            System.out.println("welcome password is " + this.encryptedPassword );
            return true;
        }else{
            System.out.println("sorry cant come in");
            return false;
        }
    }
}
