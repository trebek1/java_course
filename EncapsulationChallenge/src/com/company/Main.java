package com.company;

public class Main {

    public static void main(String[] args) {

        Printer epson = new Printer(75,10,false);

        epson.fillToner();

        epson.isDuplex();

        epson.printPage();
        epson.printPage();
        epson.printPage();

        epson.getPagesPrinted();




    }
}
