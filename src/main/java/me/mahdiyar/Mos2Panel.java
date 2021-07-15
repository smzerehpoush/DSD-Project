package me.mahdiyar;

import java.awt.*;

public class Mos2Panel extends Panel {

    public Mos2Panel() {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        OutputIV outputiv = new OutputIV();
        MosOperation2 mosoperation2 = new MosOperation2(outputiv);
        add("Center", mosoperation2);
        add("North", new MosTopControl(mosoperation2));
        add("South", new MosBottomControl(mosoperation2));
    }
}