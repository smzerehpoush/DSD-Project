

package me.mahdiyar;



abstract class MosInfo extends Canvas
{

    public MosInfo()
    {
        nChannel = true;
        changed = true;
        info = new String[4];
        gImg = null;
        Vt = 1.0D;
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {
        checkSize();
        if(changed)
            drawDescr();
        g.drawImage(img, 0, 0, null);
    }

    public void setVgs(double d)
    {
        if(Vgs >= Vt && d < Vt || Vgs <= Vt && d > Vt)
            changed = true;
        Vgs = d;
    }

    public void setVt(double d)
    {
        if(Vt != d)
        {
            changed = true;
            Vt = d;
        }
    }

    public void setNChannel(boolean flag)
    {
        if(nChannel != flag)
        {
            changed = true;
            nChannel = flag;
        }
    }

    protected abstract void setDescrB();

    protected abstract void setVd(double d);

    private void checkSize()
    {
        Dimension dimension = size();
        if(width != dimension.width || height != dimension.height)
        {
            width = dimension.width;
            height = dimension.height;
            if(gImg != null)
                gImg.dispose();
            img = createImage(width, height);
            gImg = img.getGraphics();
            changed = true;
        }
    }

    private void drawDescr()
    {
        gImg.setColor(Color.white);
        gImg.fillRect(0, 0, width, height);
        gImg.drawRect(0, 0, width - 1, height - 1);
        FontMetrics fontmetrics = gImg.getFontMetrics();
        int i = fontmetrics.getHeight();
        int j = fontmetrics.getAscent() + fontmetrics.getLeading();
        setDescrA();
        setDescrB();
        gImg.setColor(Color.black);
        for(int k = 0; k < info.length; k++)
        {
            if(k == 0)
            {
                if(nChannel)
                    gImg.setColor(Color.blue);
                else
                    gImg.setColor(Color.red);
            } else
            if(k == 1)
                if(counter++ % 2 == 0)
                    gImg.setColor(Color.magenta);
                else
                    gImg.setColor(Color.black);
            gImg.drawString(info[k], 2, j);
            j += i;
        }

        changed = false;
    }

    private void setDescrA()
    {
        if(nChannel)
            if(Vgs >= Vt)
            {
                info[0] = "Vgs > Vt : n-channel is induced.";
                return;
            } else
            {
                info[0] = "Vgs < Vt : the n-channel is cutoff.";
                return;
            }
        if(Vgs <= Vt)
        {
            info[0] = "Vgs < Vt : p-channel is induced.";
            return;
        } else
        {
            info[0] = "Vgs > Vt : the p-channel is cutoff.";
            return;
        }
    }

    private int width;
    private int height;
    private Image img;
    private Graphics gImg;
    protected String info[];
    protected boolean nChannel;
    protected double Vt;
    protected double Vgs;
    protected double Vd;
    protected boolean changed;
    private int counter;
}
