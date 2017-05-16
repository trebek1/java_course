package com.example.mypackage;

import java.util.Random;

public class Main {

    // Producer and Consumer example
    //Methods that can only be used in synchronized code (wait, notify and notifyAll methods)

    // thread cant be suspended while doing atomic operations
    // setting a value to a variable for instance
    // reading and writing reference variables
    // reading and writing primitive vars except long and doubles
    // read and write all variables declared volatile

    // some collections arent thread safe (arrayList)
    // we must synchronize code that uses arrayList
     

    public static void main(String[] args) {
        // causes a deadlock without wait and notify, Writer holds lock for message object
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    // consumer to read a message
    public synchronized String read(){
        // loop until there is a message to read. Then we return each message
        while(empty){
            try{
                wait();
            }catch(InterruptedException e){

            }
        }
        empty = true;
        // waiting threads can now be executed  T?his is no longer waiting here
        notifyAll();
        return message;
    }

    // producer to write a message
    public synchronized void write(String message){
        // want consumer to read all messages before writing more so we loop until empty
        while(!empty){
            try{
                wait();
            }catch(InterruptedException e){

            }
        }
        empty = false;
        this.message = message;
       notifyAll();
    }
}

class Writer implements Runnable{
    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    public void run(){
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the kings horses and all the kings men",
                "couldnt put humpty together again"
        };
        Random random = new Random();

        for(int i =0; i<messages.length; i++){
            message.write(messages[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            } catch(InterruptedException e){

            }
        }
        message.write("Finished");
    }
}

class Reader implements Runnable{
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished");latestMessage = message.read()){
            System.out.println(latestMessage);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch(InterruptedException e ){

            }
        };
    }
}


