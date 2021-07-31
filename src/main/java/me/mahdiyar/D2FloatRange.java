package me.mahdiyar;


public class D2FloatRange {


    public double min;
    public double max;

    public D2FloatRange(double d, double d1) {
        min = d;
        max = d1;
    }

    public D2FloatRange(D2FloatRange floatrange) {
        min = floatrange.min;
        max = floatrange.max;
    }

    public void union(D2FloatRange floatrange) {
        min = Math.min(floatrange.min, min);
        max = Math.max(floatrange.max, max);
    }
}
