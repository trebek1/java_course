package com.company;

class BMW extends Car{
    public BMW(){
        super(8,"M5");
        this.nickname = "Dad's Car";
    }

    @Override
    public void startEngine(){
        System.out.println("BMW ---> Start Engine");
    }
}

class Ferrari extends Car{
    public Ferrari(){
        super(8, "Enzo");
        this.nickname = "Big Red";
    }

    @Override
    public void startEngine(){
        // all classes are extended from object class
        //getClass().getSimpleName() comes from object class

        System.out.println(getClass().getSimpleName() +" ---> Start Engine");
    }
}


class Lamborgini extends Car{
    public Lamborgini(){
        super(8,"Aventador");
        this.nickname = "The bat";
    }
    @Override
    public void startEngine(){
        System.out.println("Lambo ---> Start Engine");
    }
}

class Generic extends Car{
    public Generic(){
        super(4,"Ford");
    }
}


class Car{
    private String name;
    private boolean engine;
    int cylinders;
    int wheels;
    int speed;
    String nickname;

    Car(int cylinders, String name){

        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
        this.speed = 0;
        this.nickname = "unknown";
    }


    public void startEngine(){
        System.out.println("Car ---> Start Engine");
    }

    public String getName(){
        return this.name;
    }

    public boolean getEngine(){
        return this.engine;
    }

    public int getSpeed(){
        return this.speed;
    }

    public String getNickname(){
        return this.nickname;
    }

    public void accelerate(int speed){
        this.speed += speed;
        System.out.println("This is your new speed " + this.speed);
    }

    public void brake(){
        if(this.speed > 0){
            this.speed = 0;
        }
        System.out.println("your speed is now " + this.speed);

    }
}



public class Main {

    public static void main(String[] args) {

        BMW cool = new BMW();
        Lamborgini fast = new Lamborgini();
        Generic boring = new Generic();



        System.out.println("This is the bmw " + cool.nickname);
        System.out.println("This is the lambo " + fast.nickname);
        System.out.println("This is the generic " + boring.nickname);

        // if you return a string with the functions you can System.out.println each of these as well
        cool.startEngine();
        fast.startEngine();
        boring.startEngine();
    }
}
