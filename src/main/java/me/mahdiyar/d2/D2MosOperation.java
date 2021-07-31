package me.mahdiyar.d2;

import java.awt.*;

abstract class D2MosOperation extends Panel
        implements D2CustomAWT {

    protected double Vgs;
    protected double Vd;
    protected double Vt;
    protected boolean isNChannel;
    protected D2UpDown udVgs;
    protected D2UpDown udVd;
    protected D2PlotCanvas outputPlot;
    protected D2PlotCanvas transferPlot;
    protected D2FunctionData outputIV;
    protected D2FunctionData transferIV;
    protected D2DataWrapper outputWrap;
    protected D2DataWrapper transferWrap;
    protected D2MosDevCircuit mosCkt;
    protected D2MosInfo info;
    private int width;
    private int height;

    protected D2MosOperation(D2FunctionData functiondata, D2MosDevCircuit mosdevcircuit) {
        setLayout(null);
        mosCkt = mosdevcircuit;
        outputPlot = new D2PlotCanvas();
        transferPlot = new D2PlotCanvas();
        outputIV = functiondata;
        transferIV = new D2IdsVgs();
        outputPlot.addData(outputIV);
        transferPlot.addData(transferIV);
        outputWrap = outputPlot.getData();
        transferWrap = transferPlot.getData();
        outputWrap.showCurrentSpot(true);
        add(mosCkt);
        add(outputPlot);
        add(transferPlot);
        setInfo();
        add(info);
        isNChannel = true;
        Vgs = 3D;
        Vd = 0.90000000000000002D;
        Vt = 1.0D;
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        checkSize();
        setVgs();
        setVd();
        repaintComps();
    }

    public void setVt(double d) {
        Vt = d;
        setVt();
    }

    public void setVgs(double d) {
        Vgs = d;
    }

    public void setVd(double d) {
        Vd = d;
    }

    public void infoVisible() {
        info.setVisible(!info.isVisible());
    }

    public void outVisible() {
        outputPlot.setVisible(!outputPlot.isVisible());
    }

    public void transVisible() {
        transferPlot.setVisible(!transferPlot.isVisible());
    }

    public void setVgsControl(D2UpDown updown) {
        udVgs = updown;
    }

    public void setVdControl(D2UpDown updown) {
        udVd = updown;
    }

    public boolean isNChannel() {
        return isNChannel;
    }

    public void setNChannel(boolean flag) {
        if (isNChannel != flag) {
            isNChannel = flag;
            setChannelType();
        }
    }

    protected abstract void setVd();

    protected abstract void setInfo();

    private void setChannelType() {
        mosCkt.setNChannel(isNChannel);
        info.setNChannel(isNChannel);
        outputIV.setBooleanParam(isNChannel);
        outputWrap.setRange();
        outputPlot.setChanged(true);
        transferIV.setBooleanParam(isNChannel);
        transferWrap.setRange();
        transferPlot.setChanged(true);
    }

    protected void setVgs() {
        mosCkt.setVgs(Vgs);
        info.setVgs(Vgs);
        outputWrap.setCurrentP(Vgs);
        transferWrap.setCurrentX(Vgs);
    }

    private void setVt() {
        mosCkt.setVt(Vt);
        info.setVt(Vt);
        outputIV.setDoubleParam(Vt);
        outputWrap.setRange();
        outputPlot.setChanged(true);
        transferIV.setDoubleParam(Vt);
        transferWrap.setRange();
        transferPlot.setChanged(true);
    }

    private void checkSize() {
        Dimension dimension = getSize();
        if (dimension.width != width || dimension.height != height) {
            width = dimension.width;
            height = dimension.height;
            sizeAndPlace();
        }
    }

    private void sizeAndPlace() {
        int i = (width * 2) / 3;
        int j = (height * 4) / 5;
        int k = height - j - 2;
        int l = width - i;
        int i1 = j / 2;
        outputPlot.setSize(l, i1);
        transferPlot.setSize(l, j - i1);
        mosCkt.setSize(i, j);
        info.setSize(width, k);
        mosCkt.setLocation(0, 0);
        outputPlot.setLocation(i, 0);
        transferPlot.setLocation(i, i1);
        info.setLocation(0, j);
    }

    private void repaintComps() {
        mosCkt.repaint();
        outputPlot.repaint();
        transferPlot.repaint();
        info.repaint();
    }
}
