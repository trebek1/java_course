package com.company;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Lab");
        dog.eat();
        dog.breathe();

        // cant instantiate an absract class
        //Bird bird = new Bird("Parrot");
        Parrot parrot = new Parrot("King");
        parrot.eat();
        parrot.breathe();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
        penguin.breathe(); 

    }
}


























