package me.mahdiyar.d3;

import java.applet.Applet;
import java.awt.*;

public class MosApplet2 extends Applet {

    public MosApplet2() throws HeadlessException {
    }

    public void init() {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        Mos2Frame mos2 = new Mos2Frame();
        mos2.setSize(800, 600);
        this.add("Center", mos2);
        setSize(800, 600);
    }
}
