package me.mahdiyar;

import java.awt.*;

// Referenced classes of package v10.mos_2:
//            MosDevCircuit, BatterySymbol

class MosDevCircuit2 extends MosDevCircuit {

    MosDevCircuit2() {
    }

    protected int getVgsY() {
        return getMosY() / 2;
    }

    protected int getVdY() {
        return getMosY() / 4;
    }

    protected String getVdName() {
        super.Vd.reverse();
        return "Vds";
    }

    protected void drawChannel(Graphics g) {
        drawChannel(g, super.vgs - super.vd);
    }
}
