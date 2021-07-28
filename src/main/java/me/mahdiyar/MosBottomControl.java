package me.mahdiyar;

import java.awt.*;

class MosBottomControl extends Panel {

    MosOperation mos;
    Button id;
    Button ids;
    Button info;

    public MosBottomControl(MosOperation mosoperation) {
        mos = mosoperation;
        id = new Button("Id vs. Vds");
        add(id);
        add(new Label("   "));
        ids = new Button("Ids vs. Vgs");
        add(ids);
        add(new Label("   "));
        info = new Button("Discussion");
        add(info);
        add(new Label("   "));
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
}
