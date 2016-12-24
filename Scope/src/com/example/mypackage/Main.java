package com.example.mypackage;

public class Main {

    // visibility is connected to scope
    // inner class has access to all members of containing class. Containing class can access all methods and fields of subclasas even if private
    public static void main(String[] args) {
	    // scope is visibility of variable or class
        // scope of various objects

        String varFour = "this is private to main";

        ScopeCheck scopeInstance = new ScopeCheck();

        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());
        System.out.println(varFour);
        scopeInstance.timesTwo();

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();

        scopeInstance.userInner();

        ScopeCheck.InnerClass exClass = scopeInstance.new InnerClass();
        //System.out.println(" var 3 is not accessable here " + exClass.varThree);
        // varThree is not available here bc its private. Can't bve called outside outer or inner class without getter
        // it has no visibility at this level w

    }
}
