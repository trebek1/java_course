package com.example.awtSample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// awt is abstract window toolkit
// star imports all from that class
// command + click package name jumps into the installed package in external libraries for easy searching!

/**
 * Created by Alex on 12/20/16.
 */
public class MyWindow extends Frame {

    public MyWindow(String title) throws HeadlessException {
        super(title);
        setSize(500,140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SanSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("By Tim ", 60, 100);




    }
}
