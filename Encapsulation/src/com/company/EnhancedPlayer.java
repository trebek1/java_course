package com.company;

/**
 * Created by Trebek on 11/1/16.
 */
public class EnhancedPlayer {

    private String name;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int hitPoints, String weapon) {
        this.name = name;
        if(hitPoints > 0 && hitPoints <=100){
            this.hitPoints = hitPoints;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        this.hitPoints = this.hitPoints - damage;
        if(this.hitPoints <=0){
            System.out.println("Player killed ");
            // reduce number of lives remaining for player
        }
    }
    public int getHealth(){
        return this.hitPoints;
    }
}
