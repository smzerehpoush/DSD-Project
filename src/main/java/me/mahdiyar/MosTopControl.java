package me.mahdiyar;

class MosTopControl extends MosSouthControl {

    public MosTopControl(MosOperation mosoperation) {
        super(mosoperation);
    }

    protected String getVdLabel() {
        return "Vds";
    }
}
