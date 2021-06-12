

package me.mahdiyar;

import java.awt.Graphics;

public class Plot
{

    public static void drawArrowRight(int i, int j, int k, Graphics g)
    {
        g.drawLine(i, j, i - k, j - k);
        g.drawLine(i, j, i - k, j + k);
    }

    public static void drawArrowLeft(int i, int j, int k, Graphics g)
    {
        g.drawLine(i, j, i + k, j - k);
        g.drawLine(i, j, i + k, j + k);
    }

    public static void drawArrowUp(int i, int j, int k, Graphics g)
    {
        g.drawLine(i, j, i - k, j + k);
        g.drawLine(i, j, i + k, j + k);
    }

    public static void drawArrowDown(int i, int j, int k, Graphics g)
    {
        g.drawLine(i, j, i - k, j - k);
        g.drawLine(i, j, i + k, j - k);
    }

    public static void drawVStrikeLine(int i, int j, int k, Graphics g)
    {
        drawVStrikeLine(i, j, k, g, 0.25D);
    }

    public static void drawVStrikeLine(int i, int j, int k, Graphics g, double d)
    {
        drawVStrikeLine(i, j, k, g, d, 2);
    }

    public static void drawVStrikeLine(int i, int j, int k, Graphics g, double d, int l)
    {
        g.drawLine(i, j, i, k);
        int i1 = (int)((1.0D - d) * (double)j + d * (double)k);
        g.drawLine(i - l, i1 + l, i + l, i1 - l);
        i1 += l;
        g.drawLine(i - l, i1 + l, i + l, i1 - l);
    }

    public static void drawVStrikeArrow(int i, int j, int k, Graphics g, double d, int l, int i1)
    {
        drawVStrikeLine(i, j, k, g, d, l);
        int j1;
        int k1;
        if(j > k)
        {
            j1 = k;
            k1 = j;
        } else
        {
            j1 = j;
            k1 = k;
        }
        g.drawLine(i - i1, j1 + i1, i, j1);
        g.drawLine(i, j1, i + i1, j1 + i1);
        g.drawLine(i - i1, k1 - i1, i, k1);
        g.drawLine(i, k1, i + i1, k1 - i1);
    }

    public static void drawVStrikeArrow(int i, int j, int k, Graphics g)
    {
        drawVStrikeArrow(i, j, k, g, 0.25D, 3, 3);
    }

    public static void drawHDashedLine(int i, int j, int k, Graphics g, int l)
    {
        for(int i1 = i; i1 < j; i1 += l)
            g.drawLine(i1, k, i1 += l, k);

    }

    public static void drawHDashedLine(int i, int j, int k, Graphics g)
    {
        drawHDashedLine(i, j, k, g, 3);
    }

    public Plot()
    {
    }
}
