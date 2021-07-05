

package me.mahdiyar;



// Referenced classes of package v10.mos_2:
//            MosOperation_2, MosNorthControl, OutputIV, MosSouthControl_2

public class Mos_2 extends Panel
{

    public Mos_2()
    {
        setLayout(new BorderLayout());
        setBackground(Color.white);
        OutputIV outputiv = new OutputIV();
        MosOperation_2 mosoperation_2 = new MosOperation_2(outputiv);
        add("Center", mosoperation_2);
        add("North", new MosSouthControl_2(mosoperation_2));
        add("South", new MosNorthControl(mosoperation_2));
    }
}
