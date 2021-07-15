package me.mahdiyar;

import java.applet.Applet;
import java.awt.*;

// Referenced classes of package v10.mos_2:
//            Mos_2

public class MosApplet_2 extends Applet {

    public MosApplet_2() {
    }

    public void init() {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        Mos2Panel mos_2 = new Mos2Panel();
        mos_2.setSize(410, 370);
        add("Center", mos_2);
        resize(410, 370);
    }
}
