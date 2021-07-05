

package me.mahdiyar;


// Referenced classes of package v10.mos_2:
//            MosOperation

import javax.swing

class MosNorthControl extends JPanel {

    public MosNorthControl(MosOperation mosoperation) {
        mos = mosoperation;
        id = new JButton("Id vs. Vds");
        add(id);
        add(new JLabel("   "));
        ids = new JButton("Ids vs. Vgs");
        add(ids);
        add(new JLabel("   "));
        info = new JButton("Discussion");
        add(info);
        add(new JLabel("   "));
    }

    public boolean action(Event event, Object obj) {
        if (event.target == id) {
            mos.outVisible();
            return true;
        }
        if (event.target == ids) {
            mos.transVisible();
            return true;
        }
        if (event.target == info) {
            mos.infoVisible();
            return true;
        } else {
            return false;
        }
    }

    MosOperation mos;
    JButton id;
    JButton ids;
    JButton info;
}
