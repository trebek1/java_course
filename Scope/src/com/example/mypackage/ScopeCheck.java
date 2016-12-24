package com.example.mypackage;

/**
 * Created by Alex on 12/21/16.
 */
public class ScopeCheck {
    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("Scopecheck created! public var " + publicVar + " privatevar " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo(){
        // narrowest scope is used
        // check current block of code to see if declared there
        // if no such declaration, checks blocks backwards until it finds a scope with the variable

        int varTwo = 2;
        for( int i = 0; i<10; i++){
            // this keyword tells java to use class definition instead of variable defined in the function block
            System.out.println(i + " times two is " + i * varTwo);
        }
        // i is only defined on for block
    }

    public void userInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println(" var 3 from inner class is " + innerClass.varThree);
    }

    public class InnerClass{
        private int varThree = 3;

        public InnerClass(){
            System.out.println("Inner class created varThree is " + varThree + " varOne is " + varOne);
        }

        public void timesTwo(){
            System.out.println("var one is stil available here " + varOne);
            // narrowest scope is used
            // check current block of code to see if declared there
            // if no such declaration, checks blocks backwards until it finds a scope with the variable

            for( int i = 0; i<10; i++){
                // this keyword tells java to use class definition instead of variable defined in the function block
                System.out.println(i + " times two is " + i * this.varThree);
            }
            // i is only defined on for block

        }




    }
}
