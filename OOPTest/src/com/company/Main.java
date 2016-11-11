package com.company;

class Hamburger {
    private String bread;
    private String meat;
    private boolean lettuce;
    private boolean tomato;
    private boolean pickle;
    private boolean ketchup;
    private float price;
    private float base;
    private String name;


    public Hamburger(boolean lettuce, boolean tomato, boolean pickle, boolean ketchup, String name) {
        this.name = name;
        this.bread = "sesame";
        this.meat = "cow";
        this.lettuce = lettuce;
        this.tomato = tomato;
        this.pickle = pickle;
        this.ketchup = ketchup;
        this.base = (float) (3.00);

        int counter = 0;
        if (this.lettuce) {
            counter++;
        }
        if (this.tomato) {
            counter++;
        }
        if (this.pickle) {
            counter++;
        }
        if (this.ketchup) {
            counter++;
        }
        this.price = (counter * (float) (0.5)) + base;
    }
}

class Healthy extends Hamburger{
    private boolean kale;
    private boolean egg;
    private float base;
    private float price;

    public Healthy(boolean lettuce, boolean tomato, boolean pickle, boolean ketchup, boolean kale, boolean egg) {
        // here in super you fill in values that you know for that specific type
        super(lettuce, tomato, pickle, ketchup);
        this.kale = kale;
        this.egg = egg;
        this.base = (float)3.5;

        int counter = 0;
        if(this.egg){
            counter++;
        }
        if(this.kale){
            counter++;
        }
        this.price = base + (float)(0.5) * counter;
    }
}

class Deluxe extends Hamburger{
    private boolean chips;
    private boolean drink;
    public Deluxe(boolean lettuce, boolean tomato, boolean pickle, boolean ketchup){
        super(lettuce, tomato, pickle, ketchup);
        this.chips = true;
        this.drink = true;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
