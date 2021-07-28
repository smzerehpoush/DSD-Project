

package me.mahdiyar.d2;


public class FloatRange
{

    public FloatRange()
    {
        min = 0.0D;
        max = 0.0D;
    }

    public FloatRange(double d, double d1)
    {
        min = d;
        max = d1;
    }

    public FloatRange(FloatRange floatrange)
    {
        min = floatrange.min;
        max = floatrange.max;
    }

    public void setOrder()
    {
        if(min > max)
        {
            double d = min;
            min = max;
            max = d;
        }
    }

    public void union(FloatRange floatrange)
    {
        min = floatrange.min >= min ? min : floatrange.min;
        max = floatrange.max <= max ? max : floatrange.max;
    }

    public double min;
    public double max;
}
