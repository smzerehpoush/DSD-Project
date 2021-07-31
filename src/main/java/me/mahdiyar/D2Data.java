package me.mahdiyar;

import java.awt.*;

public abstract class D2Data {

    private static final D2Format FORMAT = new D2Format(2, 1.0D);
    private D2FloatRange xRange;
    private D2FloatRange yRange;

    protected D2Data() {
        init();
        setRange();
    }

    public abstract double[] getX();

    public abstract double[][] getY();

    public double[] getParam() {
        return null;
    }

    public D2FloatRange getRangeX() {
        return xRange;
    }

    public D2FloatRange getRangeY() {
        return yRange;
    }

    public String getNameX() {
        return "x-axis";
    }

    public String getNameY() {
        return "y-axis";
    }

    public String getNameP() {
        return "param";
    }

    public D2Format getFormatX() {
        return FORMAT;
    }

    public D2Format getFormatY() {
        return FORMAT;
    }

    public D2Format getFormatP() {
        return FORMAT;
    }

    public Color getColor() {
        return Color.blue;
    }

    protected void init() {
    }

    protected void setRange() {
        double ad[] = getX();
        double d = ad[0];
        double d1 = ad[0];
        for (int i = 0; i < ad.length; i++) {
            if (ad[i] < d)
                d = ad[i];
            if (ad[i] > d1)
                d1 = ad[i];
        }

        xRange = new D2FloatRange(d, d1);
        double ad1[][] = getY();
        d = ad1[0][0];
        d1 = d;
        for (int j = 0; j < ad1.length; j++) {
            for (int k = 0; k < ad1[0].length; k++) {
                if (ad1[j][k] < d)
                    d = ad1[j][k];
                if (ad1[j][k] > d1)
                    d1 = ad1[j][k];
            }

        }

        yRange = new D2FloatRange(d, d1);
    }

}
