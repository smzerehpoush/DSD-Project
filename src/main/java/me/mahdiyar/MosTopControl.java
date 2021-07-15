package me.mahdiyar;


// Referenced classes of package v10.mos_2:
//            MosSouthControl, MosOperation

class MosTopControl extends MosSouthControl {

    public MosTopControl(MosOperation mosoperation) {
        super(mosoperation);
    }

    protected String getVdLabel() {
        return "Vds";
    }
}
