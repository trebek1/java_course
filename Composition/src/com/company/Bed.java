package com.company;

/**
 * Created by Trebek on 10/30/16.
 */
public class Bed {

    private String style;
    private int pillows;
    private int sheets;
    private int height;

    public Bed(String style, int pillows, int sheets, int height) {
        this.style = style;
        this.pillows = pillows;
        this.sheets = sheets;
        this.height = height;
    }

    public void make(){
        System.out.println("The bed has been made");
    }

    public String getStyle() {
        return style;
    }

    public int getPillows() {
        return pillows;
    }

    public int getSheets() {
        return sheets;
    }

    public int getHeight() {
        return height;
    }
}

