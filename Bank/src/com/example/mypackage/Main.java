package com.example.mypackage;

public class Main {

    public static void main(String[] args) {
	final BankAccount account = new BankAccount("12345-678", 1000);

	// first way
//	Thread trThread1 = new Thread(){
//	    public void run(){
//	        account.deposit(300);
//            account.withdraw(50);
//            // use an anonymous class
//            // doesn't makes sense to have BankAccount class implement Runnable or Thread
//        }
//    };
//
//    Thread trThread2 = new Thread(){
//        public void run(){
//            account.deposit(203.75);
//            account.withdraw(100);
//        }
//    };

        // Method 2
        // using runnable

    Thread trThread1 = new Thread(new Runnable(){
       @Override
        public void run(){
           account.deposit(300);
           account.withdraw(50);
       }
    });

        Thread trThread2 = new Thread(new Runnable(){
            @Override
            public void run(){
                account.deposit(203.75);
                account.withdraw(100);
            }
        });

    trThread1.start();
    trThread2.start();

    }
}
