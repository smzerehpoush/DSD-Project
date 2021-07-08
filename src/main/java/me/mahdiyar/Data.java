package me.mahdiyar;

import java.awt.*;

// Referenced classes of package v10.mos_2:
//            Format, FloatRange

public abstract class Data {

    private static final Format FORMAT = new Format(2, 1.0D);
    private FloatRange xRange;
    private FloatRange yRange;

    protected Data() {
        init();
        setRange();
    }

    public abstract double[] getX();

    public abstract double[][] getY();

    public double[] getParam() {
        return null;
    }

    public FloatRange getRangeX() {
        return xRange;
    }

    public FloatRange getRangeY() {
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

    public Format getFormatX() {
        return FORMAT;
    }

    public Format getFormatY() {
        return FORMAT;
    }

    public Format getFormatP() {
        return FORMAT;
    }

    public Color getColor() {
        return Color.blue;
    }

    protected void init() {
    }

    protected void setRange() {
        double[] ad = getX();
        double d = ad[0];
        double d1 = ad[0];
        for (int i = 0; i < ad.length; i++) {
            if (ad[i] < d)
                d = ad[i];
            if (ad[i] > d1)
                d1 = ad[i];
        }

        xRange = new FloatRange(d, d1);
        double[][] ad1 = getY();
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

        yRange = new FloatRange(d, d1);
    }

}
