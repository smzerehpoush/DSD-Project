

package me.mahdiyar.d2;


// Referenced classes of package v10.mos_2:
//            FunctionData, Data, Format

class IdsVgs extends FunctionData
{

    public boolean isCurrentDrawable()
    {
        return false;
    }

    public String getNameX()
    {
        return "Vgs";
    }

    public String getNameY()
    {
        return "Ids";
    }

    protected void init()
    {
        Vt = 1.0D;
        K = 0.00025000000000000001D;
        isNChannel = true;
    }

    public void setBooleanParam(boolean flag)
    {
        if(isNChannel != flag)
        {
            isNChannel = flag;
            K = -K;
            if(isNChannel)
                Vt = 1.0D;
            else
                Vt = -1D;
            setRange();
        }
    }

    public void setDoubleParam(double d)
    {
        if(Vt != d)
        {
            if(Vt * d < 0.0D)
                return;
            Vt = d;
            setRange();
        }
    }

    protected double f(double d, double d1)
    {
        if(Math.abs(d) < Math.abs(Vt))
            return 0.0D;
        else
            return K * (d - Vt) * (d - Vt);
    }

    public double[] getX()
    {
        double ad[] = new double[80];
        double d;
        double d1;
        if(isNChannel)
        {
            d = 0.0D;
            d1 = Vt + 5D;
        } else
        {
            d = Vt - 5D;
            d1 = 0.0D;
        }
        double d2 = (d1 - d) / (double)ad.length;
        ad[0] = d;
        for(int i = 1; i < ad.length; i++)
            ad[i] = ad[i - 1] + d2;

        return ad;
    }

    public Format getFormatY()
    {
        return new Format(2, 1000D);
    }

    IdsVgs()
    {
    }

    private double K;
    private double Vt;
    private boolean isNChannel;
}
