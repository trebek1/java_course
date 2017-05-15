package com.example.mypackage;

public class Main {

    // Producer and Consumer example
    //Methods that can only be used in synchronized code (wait, notify and notifyAll methods)

    public static void main(String[] args) {
	// write your code here
    }
}

class Messages {
    private String message;
    private boolean empty = true;

    // consumer to read a message
    public synchronized String read(){
        while(empty){

        }
        empty = true;
        return message;
    }

    // producer to write a message
    public synchronized void write(String message){
        while(!empty){

        }
        empty = false;
        this.message = message;
    }
}


