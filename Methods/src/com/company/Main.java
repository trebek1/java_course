package com.company;

public class Main {

    public static void main(String[] args) {

        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("your final score is " + highScore);

        highScore = calculateScore(true, 10000, 8, 200);
        System.out.println("your final score is " + highScore);

        displayHighScorePosition("Alex", 1);

        int one = calculateHighScorePosition(1500);
        int two = calculateHighScorePosition(900);
        int three = calculateHighScorePosition(400);
        int four = calculateHighScorePosition(50);

        System.out.println(one + " " + two + " " + three + " " + four);

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            return finalScore;
        }

        return -1;
    }

    public static void displayHighScorePosition(String name, int position){
        System.out.println(name + " managed to get to position " + position + " on the high score table ");
    }

    public static int calculateHighScorePosition(int score){
        int pos;

        if(score >= 1000){
            pos = 1;
        }else if(score >= 500 && score < 1000){
            pos = 2;
        }else if(score >= 100 && score < 500){
            pos = 3;
        }else{
            pos = 4;
        }

        return pos;
    }


}
