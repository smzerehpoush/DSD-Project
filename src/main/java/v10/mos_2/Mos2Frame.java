package v10.mos_2;

import java.awt.*;

public class Mos2Frame extends Frame {

    public Mos2Frame() throws HeadlessException {
        Mos2Panel mos2Panel = new Mos2Panel();
        mos2Panel.setSize(800, 600);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        add("Center", mos2Panel);
        setSize(800, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        Mos2Frame frame = new Mos2Frame();
        frame.setVisible(true);
        frame.pack();
    }

}
