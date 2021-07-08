package me.mahdiyar;


// Referenced classes of package v10.mos_2:
//            MosSouthControl, MosOperation

class MosSouthControl_2 extends MosSouthControl {

    public MosSouthControl_2(MosOperation mosoperation) {
        super(mosoperation);
    }

    protected String getVdLabel() {
        return "Vds";
    }
}
