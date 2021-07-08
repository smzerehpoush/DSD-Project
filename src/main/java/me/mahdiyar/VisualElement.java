package me.mahdiyar;

import java.awt.*;

public interface VisualElement {

    int SMALL = 0;
    int MEDSMALL = 1;
    int MEDIUM = 2;
    int MEDLARGE = 3;
    int LARGE = 4;

    int getScale();

    void setScale(int i);

    void setLocation(int i, int j);

    Point getLocation();
}
