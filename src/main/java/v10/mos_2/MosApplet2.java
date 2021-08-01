package v10.mos_2;

import java.applet.Applet;
import java.awt.*;

public class MosApplet2 extends Applet {

    public MosApplet2() throws HeadlessException {
        Mos2Panel mos2Panel = new Mos2Panel();

        mos2Panel.setSize(800, 600);

        setLayout(new BorderLayout());
        setBackground(Color.white);

        add("Center", mos2Panel);
        setSize(800, 600);
        setVisible(true);
    }

    @Override
    public void init() {
        new MosApplet2();
    }
}
