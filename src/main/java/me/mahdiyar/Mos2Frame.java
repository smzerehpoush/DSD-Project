package me.mahdiyar;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mos2Frame extends Frame {

    public Mos2Frame() throws HeadlessException {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        Mos2Panel mos2Panel = new Mos2Panel();
        mos2Panel.setSize(800, 600);
        add("Center", mos2Panel);
        setSize(800, 600);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Mos2Frame();
    }
}
