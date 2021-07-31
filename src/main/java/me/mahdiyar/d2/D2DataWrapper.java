package me.mahdiyar.d2;

import java.awt.*;
import java.util.Enumeration;
import java.util.Vector;

public class D2DataWrapper {

    private final D2PlotCanvas canvas;
    private final D2Axis axis;
    private final D2Conversion conv;
    private final Vector dataset;
    private final D2FloatPoint origin;
    private D2FloatRange xRange;
    private D2FloatRange yRange;
    private double pCurrent;
    private double xCurrent;
    private boolean showSpot;

    public D2DataWrapper(D2PlotCanvas plotcanvas) {
        canvas = plotcanvas;
        axis = plotcanvas.getAxis();
        conv = plotcanvas.getConversion();
        dataset = new Vector();
        xRange = null;
        yRange = null;
        showSpot = false;
        origin = new D2FloatPoint();
    }

    public void removeAll() {
        dataset.removeAllElements();
    }

    public boolean remove(D2Data data) {
        return dataset.removeElement(data);
    }

    public void add(D2Data data) {
        if (dataset.isEmpty()) {
            xRange = new D2FloatRange(data.getRangeX());
            yRange = new D2FloatRange(data.getRangeY());
        } else {
            xRange.union(data.getRangeX());
            yRange.union(data.getRangeY());
        }
        dataset.addElement(data);
    }

    public void setRange() {
        if (dataset.isEmpty())
            return;
        D2Data data = (D2Data) dataset.firstElement();
        xRange = new D2FloatRange(data.getRangeX());
        yRange = new D2FloatRange(data.getRangeY());
        D2Data data1;
        for (Enumeration enumeration = dataset.elements(); enumeration.hasMoreElements(); yRange.union(data1.getRangeY())) {
            data1 = (D2Data) enumeration.nextElement();
            xRange.union(data1.getRangeX());
        }

    }

    public void drawFull(Graphics g) {
        if (dataset.isEmpty())
            return;
        Point point = axis.getOrigin();
        Enumeration enumeration = dataset.elements();
        int i = canvas.getSize().width / 2;
        FontMetrics fontmetrics = g.getFontMetrics();
        int k = fontmetrics.getDescent();
        while (enumeration.hasMoreElements()) {
            D2Data data = (D2Data) enumeration.nextElement();
            int ai[] = conv.toScrX(data.getX());
            int ai1[][] = conv.toScrY(data.getY());
            g.setColor(data.getColor());
            for (int l = 0; l < ai1.length; l++) {
                for (int i1 = 1; i1 < ai.length; i1++)
                    g.drawLine(point.x + ai[i1], point.y - ai1[l][i1], point.x + ai[i1 - 1], point.y - ai1[l][i1 - 1]);

            }

            double ad[] = data.getParam();
            if (ai1.length > 1 && ad != null && ad.length > 1) {
                int j = point.x + ai[ai.length - 1];
                String s = data.getNameP();
                D2Format format = data.getFormatP();
                if (j > i)
                    j -= fontmetrics.stringWidth(s + "=" + format.formE(ad[0]));
                for (int j1 = 0; j1 < ad.length; j1++)
                    g.drawString(s + "=" + format.formE(ad[j1]), j, point.y - ai1[j1][ai.length - 1] - k);

            }
        }
    }

    public void drawCurrent(Graphics g, Color color) {
        g.setColor(color);
        for (Enumeration enumeration = dataset.elements(); enumeration.hasMoreElements(); ) {
            Object obj = enumeration.nextElement();
            if (obj instanceof D2FunctionData) {
                D2FunctionData functiondata = (D2FunctionData) obj;
                if (functiondata.isCurrentDrawable()) {
                    int ai[] = conv.toScrX(functiondata.getX());
                    int ai1[] = conv.toScrY(functiondata.getCurrentY(pCurrent));
                    Point point = axis.getOrigin();
                    for (int i = 1; i < ai.length; i++)
                        g.drawLine(point.x + ai[i], point.y - ai1[i], point.x + ai[i - 1], point.y - ai1[i - 1]);

                    int j = point.x + ai[ai.length - 1];
                    int k = canvas.getSize().width / 2;
                    String s = functiondata.getNameP();
                    D2Format format = functiondata.getFormatP();
                    s += "=" + format.formE(pCurrent);
                    FontMetrics fontmetrics = g.getFontMetrics();
                    int l = fontmetrics.getDescent();
                    if (j > k)
                        j -= fontmetrics.stringWidth(s);
                    g.drawString(s, j, point.y - ai1[ai.length - 1] - l);
                }
            }
        }

    }

    public void showCurrentSpot(boolean flag) {
        showSpot = flag;
    }

    public void drawSpot(Graphics g, Color color) {
        if (!showSpot)
            return;
        g.setColor(color);
        int i = conv.toScrX(xCurrent);
        Point point = axis.getOrigin();
        for (Enumeration enumeration = dataset.elements(); enumeration.hasMoreElements(); ) {
            Object obj = enumeration.nextElement();
            if (obj instanceof D2FunctionData) {
                D2FunctionData functiondata = (D2FunctionData) obj;
                int j = conv.toScrY(functiondata.getY(xCurrent, pCurrent));
                g.fillOval((point.x + i) - 2, point.y - j - 2, 4, 4);
            }
        }

    }

    public void setCurrentP(double d) {
        pCurrent = d;
    }

    public void setCurrentX(double d) {
        xCurrent = d;
    }

    public boolean isEmpty() {
        return dataset.isEmpty();
    }

    public D2FloatRange getRangeX() {
        return xRange;
    }

    public D2FloatRange getRangeY() {
        return yRange;
    }

    public D2FloatPoint getOrigin() {
        return origin;
    }

    public D2Format getFormatX() {
        return ((D2Data) dataset.firstElement()).getFormatX();
    }

    public D2Format getFormatY() {
        return ((D2Data) dataset.firstElement()).getFormatY();
    }

    public String getNameX() {
        String s = null;
        for (Enumeration enumeration = dataset.elements(); enumeration.hasMoreElements(); ) {
            s = ((D2Data) enumeration.nextElement()).getNameX();
            if (s != null)
                break;
        }

        return s;
    }

    public String getNameY() {
        String s = null;
        for (Enumeration enumeration = dataset.elements(); enumeration.hasMoreElements(); ) {
            s = ((D2Data) enumeration.nextElement()).getNameY();
            if (s != null)
                break;
        }

        return s;
    }
}
