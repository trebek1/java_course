package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // equals and plus
        int result = 1 + 2;

        int previousResult = result;

        result = result -1;

        System.out.println(result + "  " + previousResult);

        result = result/5;

        System.out.println(result);

        System.out.println(previousResult%2);

        result++; // add one to result

        System.out.println(result*=10);

        boolean isAlien = false;

        if(isAlien == true){
            System.out.println("it is not an alien!");
        }

        int topScore = 99;

        int secondScore = 60;
        if(topScore >= 100){
            System.out.println("You got the high score ");
        }

        if((topScore > secondScore) && (topScore < 100)){
            System.out.println("hi");
        }

        boolean isCar = false; // will return true;

        if(isCar = true ){
            System.out.println("not supposed to happen ");
        }

        boolean wasCar = isCar ? true: false;



    }
}
