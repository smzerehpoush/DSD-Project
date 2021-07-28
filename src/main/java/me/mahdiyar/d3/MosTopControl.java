package me.mahdiyar.d3;

class MosTopControl extends MosSouthControl {
    public MosTopControl(MosOperation mosoperation) {
        super(mosoperation);
    }

    @Override
    protected String getVdLabel() {
        return "Vds";
    }
}
