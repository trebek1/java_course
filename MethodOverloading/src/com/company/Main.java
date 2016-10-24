package com.company;

public class Main {

    public static void main(String[] args) {
//	 int newScore = calculateScore("Tim ", 500);
//        System.out.println("newscore is " + newScore);
//        calculateScore(777);
//        calculateScore();


       double inches = calcFeetAndInchesToCentimeters(500);
        System.out.println(inches);

    }
    // must create a unique method signature to method overload
    // changing parameters makes it unique, not changing return type

    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if(feet < 0 || inches < 0 || inches > 12){
            return -1;
        }

        double in = 12 * feet + inches;
        double cm = in * 2.54;

        return cm;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        if( inches < 0){
            return -1;
        }

        double ft = inches /12;
        double in = 0;

        return calcFeetAndInchesToCentimeters(ft, in);
    }



    public static int calculateScore(String playerName, int score){
        System.out.println("player " + playerName + " scored " + score + " points" );
        return score*1000;
    }

    public static int calculateScore(int score){
        System.out.println("unnamed player scored " + score + " points" );
        return score*1000;
    }

    public static int calculateScore(){
        System.out.println("unnamed player scored unknown points" );
        return 0;
    }
}
