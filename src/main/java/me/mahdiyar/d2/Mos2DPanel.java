package me.mahdiyar.d2;

import java.awt.*;

public class Mos2DPanel extends Panel {

    public Mos2DPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        OutputIV outputiv = new OutputIV();
        MosOperation2D mosoperation_2D = new MosOperation2D(outputiv);
        add("Center", mosoperation_2D);
        add("North", new MosSouthControl2D(mosoperation_2D));
        add("South", new MosNorthControl(mosoperation_2D));
    }
}
