package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] values = getIntegers(5);

        printArray(values);
        int[] sorted = sortArray(values);

        for(int i = 0; i<sorted.length; i++){
            System.out.println("Sorted "+ i + " value " + sorted[i]);
        }

    }

    public static int[] getIntegers(int n){
        int[] list = new int[n];
        System.out.println("Enter " + n + " integer values \r");
        for(int i = 0; i<n; i++){
            list[i] = scanner.nextInt();
        }

        return list;
    }

    public static void printArray(int[] array){
        int length = array.length;

        for(int i = 0; i<length; i++){
            System.out.println("Index " + i + " value " + array[i]);
        }
    }

    public static int[] sortArray(int[] array){
//        int[] sortedArray = new int[array.length];
//
//            for(int i =0; i<array.length; i++){
//                sortedArray[i] = array[i];
//            }
            int[] sortedArray = Arrays.copyOf(array, array.length);
            boolean flag = true;
            int temp;

            while(flag){
                flag = false;

                for(int i = 0; i<sortedArray.length - 1; i++) {
                    if (sortedArray[i] < sortedArray[i + 1]) {
                        temp = sortedArray[i];
                        sortedArray[i] = sortedArray[i + 1];
                        sortedArray[i + 1] = temp;
                        flag = true;
                    }
                }
            }

        return sortedArray;
    }
}
