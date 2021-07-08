package me.mahdiyar;

import java.awt.*;

// Referenced classes of package v10.mos_2:
//            VisualElement

public class GroundSymbol
        implements VisualElement {

    private final int WIDE = 4;
    private final int SPACE = 3;
    private Point position;
    private int wide;
    private int space;
    private int scale;

    public GroundSymbol() {
        scale = 2;
        position = new Point(0, 0);
    }

    public GroundSymbol(int i) {
        this();
        scale = i;
    }

    public GroundSymbol(Point point) {
        this();
        position = point;
    }

    public void draw(Graphics g) {
        adjustSize();
        int i = position.x;
        int j = position.y;
        g.drawLine(i - wide, j, i + wide, j);
        j += space;
        g.drawLine(i - (wide * 2) / 3, j, i + (wide * 2) / 3, j);
        j += space;
        g.drawLine(i - wide / 3, j, i + wide / 3, j);
    }

    public void setLocation(int i, int j) {
        position.x = i;
        position.y = j;
    }

    public Point getLocation() {
        return position;
    }

    public int getScale() {
        if (scale > 4 || scale < 0)
            return 2;
        else
            return scale;
    }

    public void setScale(int i) {
        scale = i;
    }

    public int getHeight() {
        return 2 * space + 2;
    }

    private void adjustSize() {
        if (scale < 0 || scale > 4)
            scale = 2;
        switch (scale) {
            case 0: // '\0'
                wide = 1;
                space = 1;
                return;

            case 1: // '\001'
                wide = 2;
                space = 2;
                return;

            case 2: // '\002'
                wide = 4;
                space = 3;
                return;

            case 3: // '\003'
                wide = 6;
                space = 4;
                return;

            case 4: // '\004'
                wide = 8;
                space = 6;
                return;
        }
    }
}
