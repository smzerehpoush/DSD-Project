

package me.mahdiyar.d2;

import java.awt.*;

// Referenced classes of package v10.mos_2:
//            Conversion, Axis, DataWrapper, Data

public class PlotCanvas extends Canvas
{

    public PlotCanvas()
    {
        conv = new Conversion();
        axis = new Axis(this);
        data = new DataWrapper(this);
        showFullData = true;
        dataChanged = false;
    }

    public void addNotify()
    {
        super.addNotify();
        axis.init();
    }

    public void addData(Data data1)
    {
        data.add(data1);
        dataChanged = true;
    }

    public void removeAllData()
    {
        if(!data.isEmpty())
        {
            data.removeAll();
            dataChanged = true;
        }
    }

    public void removeData(Data data1)
    {
        if(data.remove(data1))
            dataChanged = true;
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {
        Dimension dimension = size();
        if(dimension.width != width || dimension.height != height)
        {
            width = dimension.width;
            height = dimension.height;
            imgBkgd = createImage(width, height);
            repaintImg();
        } else
        if(dataChanged)
            repaintImg();
        g.drawImage(imgBkgd, 0, 0, null);
        data.drawCurrent(g, Color.magenta);
        data.drawSpot(g, Color.red);
    }

    public void setBkgd(boolean flag)
    {
        if(showFullData != flag)
        {
            showFullData = flag;
            dataChanged = true;
        }
    }

    public DataWrapper getData()
    {
        return data;
    }

    public Axis getAxis()
    {
        return axis;
    }

    public Conversion getConversion()
    {
        return conv;
    }

    public void setChanged(boolean flag)
    {
        dataChanged = flag;
    }

    private void repaintImg()
    {
        Graphics g = imgBkgd.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.black);
        axis.draw(g);
        if(showFullData)
            data.drawFull(g);
        g.dispose();
        dataChanged = false;
    }

    private Axis axis;
    private DataWrapper data;
    private Conversion conv;
    private int width;
    private int height;
    private Image imgBkgd;
    private boolean showFullData;
    private boolean dataChanged;
}
