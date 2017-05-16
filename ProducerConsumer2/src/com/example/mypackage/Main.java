package com.example.mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.mypackage.Main.EOF;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
	    List<String> buffer = new ArrayList<String>();
	    MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
	    MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
	    MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

	    new Thread(producer).start();
	    new Thread(consumer1).start();
	    new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4","5"};

        for(String num : nums){
            try{
                System.out.println( color + "adding..." + num);
                synchronized(buffer){
                    buffer.add(num);
                }

                Thread.sleep(random.nextInt(1000));
            }catch(InterruptedException e){
                System.out.println("producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        synchronized(buffer){
            buffer.add("EOF");
        }

    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run(){
        while(true){

            synchronized(buffer){
                if(buffer.isEmpty()){
                    continue;
                }
                if(buffer.get(0).equals(EOF)){
                    System.out.println( color + "Exiting");
                    break;
                }else{
                    System.out.println( color + "removed " + buffer.remove(0));
                }
            }


        }
    }
}

// doing this type of synchronization not all threads get the same opportunity
// 1st one to be blocked may be the last to be unblocked
//-- blocked cant be interrupted
//-- stuck until getting lock that it is synchronizing on
//
//-- synchronized block must be in same method
//
//-- cant test to see if objects intrinsic lock is available
//
//-- cant timeout after waiting for lock for a while
//
//-- not first come first served if multiple threads are trying to use lock

//-- Lock instance does not have these problems

