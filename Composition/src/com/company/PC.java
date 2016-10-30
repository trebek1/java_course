package com.company;

/**
 * Created by Trebek on 10/26/16.
 */


// This PC is created through Composition
// extends only allows inheritance from one class, using composition can use several classes

public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        // usually use composition before inheritance
        // fancy graphics
        monitor.drawPixelAt(1200,1500,"red");


    }


}
