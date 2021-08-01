package v10.mos_2;


public class UpControl extends MosSouthControl {

    public UpControl(MosOperationPanel mosOperationPanel) {
        super(mosOperationPanel);
    }

    protected String getVdLabel() {
        return "Vds";
    }
}
