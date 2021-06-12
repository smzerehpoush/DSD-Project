
package me.mahdiyar;

import java.awt.Point;

public interface VisualElement
{

    public abstract void setScale(int i);

    public abstract int getScale();

    public abstract void setLocation(int i, int j);

    public abstract Point getLocation();

    public static final int SMALL = 0;
    public static final int MEDSMALL = 1;
    public static final int MEDIUM = 2;
    public static final int MEDLARGE = 3;
    public static final int LARGE = 4;
}
