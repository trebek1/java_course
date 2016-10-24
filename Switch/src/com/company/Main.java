package com.company;

public class Main {

    public static void main(String[] args) {
//        int value = 1;
//        if(value == 1){
//            System.out.println("the value = 1");
//        }else{
//            System.out.println("not 1");
//        }

        int switchValue = 4;

        switch(switchValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3:case 4:case 5:
                System.out.println("was 3 4 or 5");
                System.out.println(switchValue);
                break;
            default:
                System.out.println("was not 1 or 2 ");
                break;
        }
        char switchChar = 'A';
        switch(switchChar){
            case 'A':
                System.out.println("return " + switchChar);
                break;
            case 'B':
                System.out.println("Return B ");
                break;
            case 'C':
                System.out.println("Return C ");
                break;
            case 'D':
                System.out.println("Return D");
                break;
            case 'E':
                System.out.println("Return E ");
                break;
            default:
                System.out.println("None found ");
        }

        // more code here
    }
}
