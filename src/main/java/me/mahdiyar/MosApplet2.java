package me.mahdiyar;

import java.applet.Applet;
import java.awt.*;


public class MosApplet2 extends Applet {

    @Override
    public void init() {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        Mos2Panel mos2 = new Mos2Panel();
        mos2.setSize(410, 370);
        add("Center", mos2);
        resize(410, 370);
    }
}
