
package me.mahdiyar;

import java.applet.Applet;
.*;

// Referenced classes of package v10.mos_2:
//            Mos_2

public class MosApplet_2 extends Applet
{

    public void init()
    {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        Mos_2 mos_2 = new Mos_2();
        mos_2.resize(410, 370);
        add("Center", mos_2);
        resize(410, 370);
    }

    public MosApplet_2()
    {
    }
}
