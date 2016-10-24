package com.company;

public class Main {

    public static void main(String[] args) {
	    Car porsche = new Car(); // must initialize classes with the new keyword
        Car holden = new Car();

        porsche.setModel("911");

        System.out.println(porsche.getModel());

    }
}
