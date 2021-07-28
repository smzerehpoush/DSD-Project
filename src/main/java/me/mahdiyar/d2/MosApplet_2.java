
package me.mahdiyar.d2;

import java.applet.Applet;
import java.awt.*;

// Referenced classes of package v10.mos_2:
//            Mos_2

public class MosApplet_2 extends Applet
{

    public void init()
    {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        Mos2DPanel mos_2DPanel = new Mos2DPanel();
        mos_2DPanel.resize(410, 370);
        add("Center", mos_2DPanel);
        resize(410, 370);
    }

    public MosApplet_2()
    {
    }
}
