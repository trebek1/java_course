package com.example.mypackage;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {

//        StaticTest firstInstance = new StaticTest("1st instance");
       System.out.println(firstInstance.getName() + " is instance of " + StaticTest.getNumInstances());
       // making function static lets me call from the class name;

       StaticTest secondInstance = new StaticTest("2nd instance");
       System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());

       StaticTest thirdInstance = new StaticTest("3rd instance");
       System.out.println(secondInstance.getName() + " is instance number " + secondInstance.getNumInstances());

        // all instances share the same copy in memory
        // static makes unique copies

        // static field is known as a class variable is associated with class and not particular instance of it

        int answer = multiply(6);
        System.out.println("multiplier is " + multiplier);
        System.out.println("answer is " + answer);
        // non-class methods dont exist until an instance of the class is there
    }

    public static int multiply(int number){
        return number * multiplier;
    };  
}
