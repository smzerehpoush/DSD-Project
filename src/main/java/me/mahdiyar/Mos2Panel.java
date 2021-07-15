package me.mahdiyar;

import java.awt.*;

public class Mos2Panel extends Panel {

    public Mos2Panel() {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        OutputIV outputiv = new OutputIV();
        MosOperation2Panel mosoperation2 = new MosOperation2Panel(outputiv);
        add("Center", mosoperation2);
        add("North", new TopControlBar(mosoperation2));
        add("South", new BottomControlBarControl(mosoperation2));
    }
}
