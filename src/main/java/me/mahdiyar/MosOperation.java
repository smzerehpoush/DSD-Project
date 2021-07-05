

package me.mahdiyar;



// Referenced classes of package v10.mos_2:
//            PlotCanvas, MosDevCircuit, IdsVgs, MosInfo, 
//            DataWrapper, CustomAWT, FunctionData, UpDown

abstract class MosOperation extends Panel
    implements CustomAWT
{

    public MosOperation(FunctionData functiondata, MosDevCircuit mosdevcircuit)
    {
        setLayout(null);
        mosCkt = mosdevcircuit;
        outputPlot = new PlotCanvas();
        transferPlot = new PlotCanvas();
        outputIV = functiondata;
        transferIV = new IdsVgs();
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

    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {
        checkSize();
        setVgs();
        setVd();
        repaintComps();
    }

    public void setNChannel(boolean flag)
    {
        if(isNChannel != flag)
        {
            isNChannel = flag;
            setChannelType();
        }
    }

    public void setVt(double d)
    {
        Vt = d;
        setVt();
    }

    public void setVgs(double d)
    {
        Vgs = d;
    }

    public void setVd(double d)
    {
        Vd = d;
    }

    public void infoVisible()
    {
        if(info.isVisible())
        {
            info.hide();
            return;
        } else
        {
            info.show();
            return;
        }
    }

    public void outVisible()
    {
        if(outputPlot.isVisible())
        {
            outputPlot.hide();
            return;
        } else
        {
            outputPlot.show();
            return;
        }
    }

    public void transVisible()
    {
        if(transferPlot.isVisible())
        {
            transferPlot.hide();
            return;
        } else
        {
            transferPlot.show();
            return;
        }
    }

    public void setVgsControl(UpDown updown)
    {
        udVgs = updown;
    }

    public void setVdControl(UpDown updown)
    {
        udVd = updown;
    }

    public boolean isNChannel()
    {
        return isNChannel;
    }

    public void start()
    {
        if(kicker == null)
            kicker = new Thread(this);
        kicker.start();
    }

    public void stop()
    {
        if(kicker != null)
            kicker.stop();
        kicker = null;
    }

    protected abstract void setVd();

    protected abstract void setInfo();

    private void setChannelType()
    {
        mosCkt.setNChannel(isNChannel);
        info.setNChannel(isNChannel);
        outputIV.setBooleanParam(isNChannel);
        outputWrap.setRange();
        outputPlot.setChanged(true);
        transferIV.setBooleanParam(isNChannel);
        transferWrap.setRange();
        transferPlot.setChanged(true);
    }

    protected void setVgs()
    {
        mosCkt.setVgs(Vgs);
        info.setVgs(Vgs);
        outputWrap.setCurrentP(Vgs);
        transferWrap.setCurrentX(Vgs);
    }

    private void setVt()
    {
        mosCkt.setVt(Vt);
        info.setVt(Vt);
        outputIV.setDoubleParam(Vt);
        outputWrap.setRange();
        outputPlot.setChanged(true);
        transferIV.setDoubleParam(Vt);
        transferWrap.setRange();
        transferPlot.setChanged(true);
    }

    private void checkSize()
    {
        Dimension dimension = size();
        if(dimension.width != width || dimension.height != height)
        {
            width = dimension.width;
            height = dimension.height;
            sizeAndPlace();
        }
    }

    private void sizeAndPlace()
    {
        int i = (width * 2) / 3;
        int j = (height * 4) / 5;
        int k = height - j - 2;
        int l = width - i;
        int i1 = j / 2;
        outputPlot.resize(l, i1);
        transferPlot.resize(l, j - i1);
        mosCkt.resize(i, j);
        info.resize(width, k);
        mosCkt.move(0, 0);
        outputPlot.move(i, 0);
        transferPlot.move(i, i1);
        info.move(0, j);
    }

    private void repaintComps()
    {
        mosCkt.repaint();
        outputPlot.repaint();
        transferPlot.repaint();
        info.repaint();
    }

    public abstract void run();

    private int width;
    private int height;
    protected double Vgs;
    protected double Vd;
    protected double Vt;
    protected boolean isNChannel;
    protected Thread kicker;
    protected UpDown udVgs;
    protected UpDown udVd;
    protected PlotCanvas outputPlot;
    protected PlotCanvas transferPlot;
    protected FunctionData outputIV;
    protected FunctionData transferIV;
    protected DataWrapper outputWrap;
    protected DataWrapper transferWrap;
    protected MosDevCircuit mosCkt;
    protected MosInfo info;
}
