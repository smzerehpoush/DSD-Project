package me.mahdiyar;

import java.awt.*;
import java.util.Enumeration;
import java.util.Vector;

// Referenced classes of package v10.mos_2:
//            FloatRange

public class Conversion {

    private double xToScr;
    private double yToScr;
    private double xToPhys;
    private double yToPhys;
    private double xFillFactor;
    private double yFillFactor;

    public Conversion() {
        xFillFactor = 0.94999999999999996D;
        yFillFactor = 0.94999999999999996D;
        setPhysToScr(1.0D, 1.0D);
    }

    public Conversion(double d, double d1) {
        xFillFactor = 0.94999999999999996D;
        yFillFactor = 0.94999999999999996D;
        setPhysToScr(d, d1);
    }

    public int toScrX(double d) {
        return (int) (xToScr * d + 0.5D);
    }

    public int[] toScrX(double[] ad) {
        int[] ai = new int[ad.length];
        for (int i = 0; i < ad.length; i++)
            ai[i] = (int) (xToScr * ad[i] + 0.5D);

        return ai;
    }

    public Vector toScrX(Vector vector) {
        if (vector == null)
            return null;
        Vector vector1 = new Vector(vector.size());
        int i;
        for (Enumeration enumeration = vector.elements(); enumeration.hasMoreElements(); vector1.addElement(new Integer(i)))
            i = toScrX(((Double) enumeration.nextElement()).doubleValue());

        return vector1;
    }

    public int toScrX(int i) {
        return (int) (xToScr * (double) i + 0.5D);
    }

    public int toScrY(double d) {
        return (int) (yToScr * d + 0.5D);
    }

    public int toScrY(int i) {
        return (int) (yToScr * (double) i + 0.5D);
    }

    public int[][] toScrY(double[][] ad) {
        int[][] ai = new int[ad.length][];
        for (int i = 0; i < ad.length; i++)
            ai[i] = toScrY(ad[i]);

        return ai;
    }

    public int[] toScrY(double[] ad) {
        int[] ai = new int[ad.length];
        for (int i = 0; i < ad.length; i++)
            ai[i] = (int) (yToScr * ad[i]);

        return ai;
    }

    public void toScrY(Vector vector, Vector vector1) {
        if (vector == null) {
            System.out.println("Physical Vector is null in Conversion.toScrY()");
            return;
        }
        Enumeration enumeration = vector.elements();
        vector1.removeAllElements();
        int i;
        for (; enumeration.hasMoreElements(); vector1.addElement(new Integer(i))) {
            Double double1 = (Double) enumeration.nextElement();
            i = (int) (yToScr * double1.doubleValue() + 0.5D);
        }

    }

    public double toPhysX(int i) {
        return xToPhys * (double) i;
    }

    public double toPhysY(int i) {
        return yToPhys * (double) i;
    }

    public void setPhysToScr(double d, double d1) {
        xToScr = d;
        xToPhys = 1.0D / d;
        yToScr = d1;
        yToPhys = 1.0D / d1;
    }

    public void setPhysToScrX(double d) {
        xToScr = d;
        xToPhys = 1.0D / d;
    }

    public void setPhysToScrY(double d) {
        yToScr = d;
        yToPhys = 1.0D / d;
    }

    public void setX(int i, double d) {
        xToScr = (xFillFactor * (double) i) / d;
        xToPhys = 1.0D / xToScr;
    }

    public void setY(int i, double d) {
        yToScr = (yFillFactor * (double) i) / d;
        yToPhys = 1.0D / yToScr;
    }

    public void set(Dimension dimension, FloatRange floatrange, FloatRange floatrange1) {
        setX(dimension.width, floatrange.max - floatrange.min);
        setY(dimension.height, floatrange1.max - floatrange1.min);
    }

    public double getXFillFactor() {
        return xFillFactor;
    }

    public void setXFillFactor(double d) {
        if (d > 0.0D && d <= 1.0D) {
            if (xToScr > 0.0D) {
                double d1 = d / xFillFactor;
                xToScr = d1 * xToScr;
                xToPhys = 1.0D / xToScr;
            }
            xFillFactor = d;
        }
    }

    public double getYFillFactor() {
        return yFillFactor;
    }

    public void setYFillFactor(double d) {
        if (d > 0.0D && d <= 1.0D) {
            if (yToScr > 0.0D) {
                double d1 = d / yFillFactor;
                yToScr = d1 * yToScr;
                yToPhys = 1.0D / yToScr;
            }
            yFillFactor = d;
        }
    }
}
