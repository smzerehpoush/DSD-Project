package me.mahdiyar.d3;

import java.applet.Applet;
import java.awt.*;

public class MosApplet2 extends Applet {

    public MosApplet2() {
    }

    public void init() {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        Mos3DPanel mos2 = new Mos3DPanel();
        mos2.setSize(410, 370);
        add("Center", mos2);
        resize(410, 370);
    }
}
