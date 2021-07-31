package me.mahdiyar.d2;

import java.awt.*;

public class D2Mos2DPanel extends Panel {

    public D2Mos2DPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        D2OutputIV outputiv = new D2OutputIV();
        D2MosOperation2D mosoperation_2D = new D2MosOperation2D(outputiv);
        add("Center", mosoperation_2D);
        add("North", new D2MosSouthControl2D(mosoperation_2D));
        add("South", new D2MosNorthControl(mosoperation_2D));
    }
}
