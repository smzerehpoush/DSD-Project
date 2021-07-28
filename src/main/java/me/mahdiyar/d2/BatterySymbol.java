

package me.mahdiyar.d2;

import java.awt.*;

// Referenced classes of package v10.mos_2:
//            VisualElement

public class BatterySymbol
        implements VisualElement {

    public BatterySymbol() {
        scale = 2;
        plusToMinus = 4;
        plusHalfWidth = 4;
        plus = new Point(0, 0);
        minus = new Point(0, 0);
        align = "horizontal";
        plusSide = "right";
        setScale();
    }

    public BatterySymbol(int i) {
        scale = 2;
        plusToMinus = 4;
        plusHalfWidth = 4;
        plus = new Point(0, 0);
        minus = new Point(0, 0);
        align = "horizontal";
        plusSide = "right";
        if (i >= 0 || i <= 4)
            scale = i;
        setScale();
    }

    public BatterySymbol(Point point) {
        scale = 2;
        plusToMinus = 4;
        plusHalfWidth = 4;
        plus = new Point(0, 0);
        minus = new Point(0, 0);
        align = "horizontal";
        plusSide = "right";
        plus = point;
        setMinus();
        setScale();
    }

    public BatterySymbol(String s, String s1) {
        scale = 2;
        plusToMinus = 4;
        plusHalfWidth = 4;
        plus = new Point(0, 0);
        minus = new Point(0, 0);
        align = "horizontal";
        plusSide = "right";
        setAlign(s, s1);
        setScale();
    }

    public void setLocation(int i, int j) {
        plus.x = i;
        plus.y = j;
        setMinus();
    }

    public void draw(Graphics g) {
        if (align.equals("vertical")) {
            drawVertical(g);
            return;
        } else {
            drawHorizontal(g);
            return;
        }
    }

    public void erase(Graphics g, Color color) {
        g.setXORMode(color);
        draw(g);
        g.setPaintMode();
    }

    public void setAlign(String s, String s1) {
        if (s.equals("horizontal") || s.equals("vertical"))
            align = s;
        else
            return;
        if (align.equals("horizontal"))
            if (s1.equals("right") || s1.equals("left")) {
                plusSide = s1;
                return;
            } else {
                return;
            }
        if (s1.equals("up") || s1.equals("down")) {
            plusSide = s1;
            return;
        } else {
            return;
        }
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int i) {
        if (i > 4 || i < 0)
            scale = 2;
        else
            scale = i;
        setScale();
    }

    public Point getLocation() {
        return plus;
    }

    public Point getMinus() {
        return minus;
    }

    public void reverse() {
        if (plus.y == minus.y) {
            int i = plus.x;
            plus.x = minus.x;
            minus.x = i;
            if (plus.x > minus.x) {
                plusSide = "right";
                return;
            } else {
                plusSide = "left";
                return;
            }
        }
        if (plus.x == minus.x) {
            int j = plus.y;
            plus.y = minus.y;
            minus.y = j;
            if (plus.y < minus.y) {
                plusSide = "up";
                return;
            }
            plusSide = "down";
        }
    }

    public int getLeftX() {
        if (align.equals("vertical"))
            return plus.x - plusHalfWidth;
        if (plus.x < minus.x)
            return plus.x;
        else
            return minus.x;
    }

    public int getRightX() {
        if (align.equals("vertical"))
            return plus.x + plusHalfWidth;
        if (plus.x > minus.x)
            return plus.x;
        else
            return minus.x;
    }

    public int getHiY() {
        if (align.equals("vertical")) {
            if (plus.y < minus.y)
                return plus.y;
            else
                return minus.y;
        } else {
            return plus.y - plusHalfWidth;
        }
    }

    public int getLowY() {
        if (align.equals("vertical")) {
            if (plus.y > minus.y)
                return plus.y;
            else
                return minus.y;
        } else {
            return plus.y + plusHalfWidth;
        }
    }

    private void setScale() {
        switch (scale) {
            case 0: // '\0'
                plusToMinus = 2;
                plusHalfWidth = 2;
                return;

            case 1: // '\001'
                plusToMinus = 3;
                plusHalfWidth = 3;
                return;

            case 2: // '\002'
                plusToMinus = 4;
                plusHalfWidth = 4;
                return;

            case 3: // '\003'
                plusToMinus = 5;
                plusHalfWidth = 6;
                return;

            case 4: // '\004'
                plusToMinus = 6;
                plusHalfWidth = 8;
                return;
        }
    }

    private void drawVertical(Graphics g) {
        g.drawLine(plus.x - plusHalfWidth, plus.y, plus.x + plusHalfWidth, plus.y);
        g.drawLine(minus.x - minusHalfWidth, minus.y, minus.x + minusHalfWidth, minus.y);
        if (scale >= 2 && scale <= 4) {
            g.drawLine(plus.x - plusHalfWidth, plus.y - 1, plus.x + plusHalfWidth, plus.y - 1);
            g.drawLine(minus.x - minusHalfWidth, minus.y - 1, minus.x + minusHalfWidth, minus.y - 1);
        }
    }

    private void drawHorizontal(Graphics g) {
        g.drawLine(plus.x, plus.y + plusHalfWidth, plus.x, plus.y - plusHalfWidth);
        g.drawLine(minus.x, minus.y + minusHalfWidth, minus.x, minus.y - minusHalfWidth);
        if (scale >= 2 && scale <= 4) {
            g.drawLine(plus.x + 1, plus.y + plusHalfWidth, plus.x + 1, plus.y - plusHalfWidth);
            g.drawLine(minus.x + 1, minus.y + minusHalfWidth, minus.x + 1, minus.y - minusHalfWidth);
        }
    }

    private void setMinus() {
        minusHalfWidth = plusHalfWidth / 2;
        if (align.equals("vertical")) {
            setVerticalMinus();
            return;
        } else {
            setHorizontalMinus();
            return;
        }
    }

    private void setVerticalMinus() {
        minus.x = plus.x;
        if (plusSide.equals("down")) {
            minus.y = plus.y - plusToMinus;
            return;
        } else {
            minus.y = plus.y + plusToMinus;
            return;
        }
    }

    private void setHorizontalMinus() {
        minus.y = plus.y;
        if (plusSide.equals("left")) {
            minus.x = plus.x + plusToMinus;
            return;
        } else {
            minus.x = plus.x - plusToMinus;
            return;
        }
    }

    private static final int POSTONEG = 4;
    private static final int HALFWIDTH = 4;
    private int scale;
    private int plusToMinus;
    private int plusHalfWidth;
    private int minusHalfWidth;
    private Point plus;
    private Point minus;
    private String align;
    private String plusSide;
}
