

package me.mahdiyar.d2;

import java.awt.Graphics;

// Referenced classes of package v10.mos_2:
//            MosDevCircuit, BatterySymbol

class MosDevCircuit_2 extends MosDevCircuit
{

    protected int getVgsY()
    {
        return getMosY() / 2;
    }

    protected int getVdY()
    {
        return getMosY() / 4;
    }

    protected String getVdName()
    {
        super.Vd.reverse();
        return "Vds";
    }

    protected void drawChannel(Graphics g)
    {
        drawChannel(g, super.vgs - super.vd);
    }

    MosDevCircuit_2()
    {
    }
}