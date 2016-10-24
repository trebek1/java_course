package com.company;

public class Main {

    public static void main(String[] args) {

        boolean test1 = isEvenNumber(77);
        boolean test2 = isEvenNumber(78);

        System.out.println(test1);
        System.out.println(test2);

        int number = 5;
        int evens = 0;

        int finishNumber = 20;

        while(number <= finishNumber){
            if(!isEvenNumber(number)){
                if(number == finishNumber){
                    System.out.println("The number of evens found is " + evens);
                    break;
                }
                number++;
                continue; // will finish the loop without executing any more code and start at next number
            }
            evens++;

            System.out.println("even number " + number);
            number++;
            if(evens == 5){
                System.out.println("5 evens found");
                break;
            }
            if(number == finishNumber){
                System.out.println("The number of evens found is " + evens);
                break;
            }
        }



//        int count = 1;
//
//        while(count != 6){
//            System.out.println("Count value is " + count);
//            count++;
//        }
//
//        count = 1;
//
//        while(true){
//            if(count == 6){
//                break;
//            }
//            System.out.println("Count value is " + count);
//            count++;
//        }
//
//
//        do{
//            System.out.println("Count value is " + count);
//            count++;
//
//            if(count > 100){
//                break;
//            }
//        } while(count !=6);
    }

    public static boolean isEvenNumber(int number){
        boolean bin = false;

        if(number % 2 == 0){
            bin = true;
        }

        return bin;

    }
}
