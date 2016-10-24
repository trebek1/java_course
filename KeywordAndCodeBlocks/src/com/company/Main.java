package com.company;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

//        if(score == 5001){
//            System.out.println("your score was 5000"); // one line you can delete the brackets
//        }else if(score == 5000){
//            System.out.printf("got here");
//        }else {
//            System.out.println("hey");
//        }

        if(gameOver){
            int finalScore = score + (levelCompleted * bonus);
            System.out.printf(" your finalscore was " + finalScore);
            // once section of code is done, cannot access finalScore outside the if statement
            // this is called scope
        }

        // int savedFinal = finalScore; // this will not work

    }
}
