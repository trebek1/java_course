package com.company;

public class Main {

    public static void main(String[] args) {
//	Player player = new Player();
//        // with no constructor a base class is established and you must add fields
//
//        player.name = "Alex"; // can forget to instantiate or update names everywhere in program might want validation as well (health < 100)
//        player.health = 20; // no validation here
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("remaining health = " + player.healthRemaining());
//
//        damage = 11;
//        player.health = 200; // could override this and would be bad, encapsulation keeps this from happening
//        player.loseHealth(damage);
//        System.out.println("remaining health = " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("Alex ", 200, "Sword"); // have more control and validation than before
        // this will result in 100 health since 200 fails validation


        System.out.println("Initial health is " + player.getHealth());

    }
}
