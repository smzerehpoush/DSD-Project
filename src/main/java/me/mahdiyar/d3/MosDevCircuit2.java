package me.mahdiyar.d3;

import java.awt.*;

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
