package com.company;

/**
 * Created by Trebek on 11/10/16.
 */
public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, int pagesPrinted, boolean duplex) {

        if(this.tonerLevel > -1 && this.tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        }else{
            this.tonerLevel = -1;
        }

        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public void fillToner(){
        System.out.println("This is the toner level " + this.tonerLevel);
        if(this.tonerLevel < 100){
            this.tonerLevel = 100;
        }

        System.out.println("This is the toner level after filling " + this.tonerLevel);
    }

    public void printPage(){

        this.pagesPrinted++;
        this.tonerLevel -= 1;

        System.out.println("this is the number of pages printed " + this.pagesPrinted);
        System.out.println("This is the toner level "  + this.tonerLevel);
    }
}
