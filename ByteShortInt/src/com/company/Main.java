package com.company;

public class Main {

    public static void main(String[] args) {

        //Integer (width of 32)
        int myMinValue = -2_147_483_648;
        int myMaxValue = 2_147_483_647;
        int myTotal = (myMinValue/2);
        System.out.println("myTotal = " + myTotal);

        //Byte (width of 8)
        byte myByteValue = 124; // quarter amount of space than an int
        byte myNewByteValue = (byte)(myByteValue/2);
        System.out.println("myNewByte = " + myNewByteValue);

        // short has width of 16
        short myShortValue = 32_767; // half an int, twice a byte
        short myNewShort = (short) (myShortValue * 2);

        // long has width of 64
        long myLongValue = 100L;

    }
}
