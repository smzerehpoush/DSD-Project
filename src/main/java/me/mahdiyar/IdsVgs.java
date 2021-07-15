package me.mahdiyar;

class IdsVgs extends FunctionData {

    private double k;
    private double vt;
    private boolean isNChannel;

    IdsVgs() {
    }

    public boolean isCurrentDrawable() {
        return false;
    }

    @Override
    public String getNameX() {
        return "Vgs";
    }

    @Override
    public String getNameY() {
        return "Ids";
    }

    @Override
    protected void init() {
        vt = 1.0D;
        k = 0.00025000000000000001D;
        isNChannel = true;
    }

    @Override
    public void setBooleanParam(boolean flag) {
        if (isNChannel != flag) {
            isNChannel = flag;
            k = -k;
            if (isNChannel)
                vt = 1.0D;
            else
                vt = -1D;
            setRange();
        }
    }

    @Override
    public void setDoubleParam(double d) {
        if (vt != d) {
            if (vt * d < 0.0D)
                return;
            vt = d;
            setRange();
        }
    }

    protected double f(double d, double d1) {
        if (Math.abs(d) < Math.abs(vt))
            return 0.0D;
        else
            return k * (d - vt) * (d - vt);
    }

    public double[] getX() {
        double[] ad = new double[80];
        double d;
        double d1;
        if (isNChannel) {
            d = 0.0D;
            d1 = vt + 5D;
        } else {
            d = vt - 5D;
            d1 = 0.0D;
        }
        double d2 = (d1 - d) / (double) ad.length;
        ad[0] = d;
        for (int i = 1; i < ad.length; i++)
            ad[i] = ad[i - 1] + d2;

        return ad;
    }

    @Override
    public Format getFormatY() {
        return new Format(2, 1000D);
    }
}
