package me.mahdiyar;

import java.awt.*;

public class MOSFET {

    private int x;
    private int y;
    private int width;
    private int height;
    private int shift;
    private boolean nChannel;
    private int yContactTop;
    private int ySemiTop;
    private int yNeutralTop;
    private int ySemiBottom;
    private int yBulkElectrode;
    private int hContact;
    private int hOxide;
    private int hChannel;
    private int hNeutral;
    private int hBulkContact;
    private int hNeutralCenter;
    private int hNeutralSide;
    private int xS;
    private int xD;
    private int xG;
    private int xBulkElectrode;
    private int xSEnd;
    private int xDEnd;
    private int xNeutralCenter;
    private int wContactTop;
    private int wContactBottom;
    private int wChannel;
    private int wSource;
    private int wNeutralCenter;
    private int wNeutralSide;

    public MOSFET() {
        nChannel = true;
    }

    public void draw(Graphics g) {
        clear(g);
        g.setColor(Color.black);
        g.drawRect(x, y, width - 1, height - 1);
        drawSecondLayer(g);
        drawFirstLayer(g);
    }

    public void clear(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    public void setNChannel(boolean flag) {
        nChannel = flag;
    }


    public void setRect(int x, int y, int width, int height, int shift) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.shift = shift;
        setParameters();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getSourceX() {
        return xS;
    }

    public int getContactY() {
        return yContactTop;
    }

    public int getGateX() {
        return xG;
    }

    public int getDrainX() {
        return xD;
    }

    public int getChannelX() {
        return xSEnd;
    }

    public int getChannelY() {
        return ySemiTop;
    }

    public int getChannelLength() {
        return wChannel;
    }

    public int getChannelHeight() {
        return hChannel;
    }

    public int getBulkX() {
        return xBulkElectrode;
    }

    public int getBulkY() {
        return yBulkElectrode;
    }

    private void drawFirstLayer(Graphics g) {
        drawOxide(g);
        drawBulkContact(g);
    }

    private void drawSecondLayer(Graphics g) {
        drawBulkNeutral(g);
        drawSDRegions(g);
        drawContacts(g);
    }

    private void drawContacts(Graphics g) {
        g.setColor(Color.gray);
        int i = yContactTop;
        int j = wContactTop / 2;
        int k = wContactBottom / 2;
        g.fillRect(xS - j, i, wContactTop, hContact);
        g.fillRect(xS - k, y, wContactBottom, hOxide);
        g.fillRect(xG - wChannel / 2, i, wChannel, hContact + hOxide / 3);
        g.fillRect(xD - j, i, wContactTop, hContact);
        g.fillRect(xD - k, y, wContactBottom, hOxide);
    }

    private void drawBulkContact(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, ySemiBottom, width, hBulkContact);
    }

    private void drawSDRegions(Graphics g) {
        Color color = nChannel ? Color.blue : Color.red;
        Color lightColor = nChannel ? new Color(114, 188, 212) : new Color(255, 127, 127);
        g.setColor(color);
        int i = wSource / 2;
        //1
        g.fillRect(xS - i, ySemiTop, wSource, hChannel);
        drawTop(g, xS - i, ySemiTop, wSource, shift, color);
        drawRightSide(g, xS - i, ySemiTop, wSource, hChannel, shift, color);
        //2
        g.fillRect(xD - i, ySemiTop, wSource, hChannel);
        drawTop(g, xD - i, ySemiTop, wSource, shift, color);
        drawRightSide(g, xD - i, ySemiTop, wSource, hChannel, shift, lightColor);
        drawTop(g, xS - i + wSource, ySemiTop, xD - xS, shift, color);
    }

    private void drawOxide(Graphics g) {
        Color color = Color.LIGHT_GRAY;
        g.setColor(color);
//        int i = wSource / 2;
//        drawTop(g, x, y, width, shift, color);
        g.fillRect(x, y, width, hOxide);
    }

    private void drawBulkNeutral(Graphics g) {
        drawBulkNeutral2(g);
        Color color = nChannel ? Color.RED : Color.blue;
        Color lightColor = nChannel ? new Color(255, 127, 127) : new Color(114, 188, 212);
        //1 - red
        g.setColor(color);
        g.fillRect(x, ySemiTop, wNeutralSide, hNeutralSide);
        drawRightSide(g, x, ySemiTop, wNeutralSide, hNeutralSide, shift, lightColor);
        //2 - green
        g.fillRect(x, yNeutralTop, width, hNeutral);
        //3 - blue
        g.fillRect((x + width) - wNeutralSide, ySemiTop, wNeutralSide, hNeutralSide);
        drawTop(g, x, ySemiTop, wNeutralSide, shift, color);
        drawTop(g, (x + width) - wNeutralSide, ySemiTop, wNeutralSide, shift, color);
        drawRightSide(g, x, y, width, height, shift, lightColor);
    }

    private void drawTop(Graphics g, int x, int y, int width, int d, Color color) {
        Color tmp = g.getColor();
        g.setColor(color);
        int[] xPoints = new int[]{x, x + d, x + width + d, x + width};
        int[] yPoints = new int[]{y, y - d, y - d, y};
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(tmp);
    }

    private void drawRightSide(Graphics g, int x, int y, int width, int height, int d, Color color) {
        Color tmp = g.getColor();
        g.setColor(color);
        int[] xPoints = new int[]{x + width, x + width + d, x + width + d, x + width};
        int[] yPoints = new int[]{y, y - d, y + height - d, y + height};
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(tmp);
    }

    private void drawBulkNeutral2(Graphics g) {
        g.setColor(nChannel ? Color.red : Color.blue);
        g.fillRect(xNeutralCenter, yNeutralTop - hNeutralCenter, wNeutralCenter, hNeutralCenter);
    }

    private void setParameters() {
        hOxide = height / 10;
        hContact = height / 15;
        hBulkContact = hContact;
        int i = height - hOxide - hBulkContact;
        hChannel = i / 3;
        int j = i / 5;
        hNeutralSide = hChannel + j;
        hNeutral = i - hNeutralSide;
        hNeutralCenter = j;
        yContactTop = y - hContact;
        ySemiTop = y + hOxide;
        ySemiBottom = ySemiTop + i;
        yNeutralTop = ySemiTop + hNeutralSide;
        yBulkElectrode = ySemiBottom + hBulkContact;
        wChannel = width / 3;
        wSource = width / 8;
        wContactBottom = wSource / 3;
        wContactTop = 2 * wContactBottom;
        wNeutralCenter = (wChannel * 3) / 4;
        xG = x + width / 2;
        xSEnd = xG - wChannel / 2;
        xDEnd = xSEnd + wChannel;
        xS = xSEnd - wSource / 2;
        xD = xDEnd + wSource / 2;
        xBulkElectrode = x + width / 5;
        xNeutralCenter = xG - wNeutralCenter / 2;
        int k = hNeutralSide - hChannel;
        wNeutralSide = xS - wSource / 2 - k - x;
    }
}
