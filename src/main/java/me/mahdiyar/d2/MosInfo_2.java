

package me.mahdiyar.d2;


// Referenced classes of package v10.mos_2:
//            MosInfo

class MosInfo_2 extends MosInfo
{

    protected void setVd(double d)
    {
        double d1 = super.Vgs - super.Vt;
        if(super.nChannel && d < 0.0D)
            d = 0.0D;
        else
        if(!super.nChannel && d > 0.0D)
            d = 0.0D;
        if(super.Vd >= d1 && d < d1 || super.Vd <= d1 && d > d1)
            super.changed = true;
        super.Vd = d;
    }

    public void setVgs(double d)
    {
        double d1 = super.Vgs - super.Vt;
        double d2 = d - super.Vt;
        if(super.Vgs >= super.Vt && d < super.Vt || super.Vgs <= super.Vt && d > super.Vt || super.Vd >= d1 && super.Vd < d2 || super.Vd <= d1 && super.Vd > d2)
            super.changed = true;
        super.Vgs = d;
    }

    protected void setDescrB()
    {
        if(super.nChannel)
        {
            if(super.Vgs < super.Vt)
            {
                super.info[1] = "";
                super.info[2] = "";
                super.info[3] = "";
                return;
            }
            if(super.Vd >= super.Vgs - super.Vt)
            {
                super.info[1] = "Vds > Vds(sat) = Vgs - Vt : Drain-side of channel is pinched-off.";
                super.info[2] = "Id is saturated : Ids = 0.5k (Vgs - Vt)^2 ";
                super.info[3] = "The MOS Transistor is now 'ON'.";
                return;
            } else
            {
                super.info[1] = "Vds < Vds(sat) = Vgs - Vt : Drain-side of channel is continuous.";
                super.info[2] = "Id varies with Vds : Id = k [(Vgs - Vt)*Vds - Vds*Vds/2] ";
                super.info[3] = "The MOS Transistor acts as a Triode.";
                return;
            }
        }
        if(super.Vgs > super.Vt)
        {
            super.info[1] = "";
            super.info[2] = "";
            super.info[3] = "";
            return;
        }
        if(super.Vd <= super.Vgs - super.Vt)
        {
            super.info[1] = "Vds < Vds(sat) = Vgs - Vt : Drain-side of channel is pinched-off.";
            super.info[2] = "Id is saturated : Ids = 0.5k (Vgs - Vt)^2 ";
            super.info[3] = "The MOS Transistor is now 'ON'.";
            return;
        } else
        {
            super.info[1] = "Vds > Vds(sat) = Vgs - Vt : Drain-side of channel is continuous.";
            super.info[2] = "Id varies with Vds : Id = k [(Vgs - Vt)*Vds - Vds*Vds/2] ";
            super.info[3] = "The MOS Transistor acts as a Triode.";
            return;
        }
    }

    MosInfo_2()
    {
    }

    private static final String BLANK = "";
    private static final String SAT = "Id is saturated : Ids = 0.5k (Vgs - Vt)^2 ";
    private static final String LIN = "Id varies with Vds : Id = k [(Vgs - Vt)*Vds - Vds*Vds/2] ";
    private static final String ON = "The MOS Transistor is now 'ON'.";
    private static final String TRI = "The MOS Transistor acts as a Triode.";
}
