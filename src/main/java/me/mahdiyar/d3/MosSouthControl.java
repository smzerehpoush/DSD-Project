package me.mahdiyar.d3;

import java.awt.*;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.StringTokenizer;

abstract class MosSouthControl extends Panel {

    private final MosOperation mos;
    private Label Vgs;
    private Label Vd;
    private UpDown10 vgs;
    private UpDown10 vd;
    private Choice choice;
    private Choice nVt;
    private Choice pVt;
    private Choice channelType;
    private Checkbox checkbox;
    private Choice dimension;
    private boolean nChannel;
    private Button printButton;


    public MosSouthControl(MosOperation mosoperation) {
        mos = mosoperation;
        initComps();
        add(Vgs);
        add(vgs);
        mosoperation.setVgsControl(vgs);
        vgs.addListener(mosoperation);
        add(Vd);
        add(vd);
        mosoperation.setVdControl(vd);
        vd.addListener(mosoperation);
        add(new Label("   "));
        add(choice);
        add(channelType);
        add(checkbox);
        add(dimension);
        add(printButton);
        nChannel = true;
    }

    public boolean action(Event event, Object obj) {
        if (event.target == channelType) {
            String s = channelType.getSelectedItem();
            nChannel = mos.isNChannel();
            if (s.equals("N-channel"))
                nChannel = true;
            else if (s.equals("P-channel"))
                nChannel = false;
            if (nChannel != mos.isNChannel()) {
                setChoice();
                mos.setNChannel(nChannel);
                double d2 = 0.0D;
                double d3 = 0.0D;
                double d = nChannel ? 1.0D : -1D;
                mos.setVgs(d2);
                mos.setVd(d3);
                mos.setVt(d);
                mos.repaint();
                return true;
            }
        } else if (event.target == choice) {
            String s1 = choice.getSelectedItem();
            try {
                double d1 = getVt(s1);
                mos.setVt(d1);
                mos.repaint();
                return true;
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        } else if (event.target == checkbox) {
            mos.setLabelsVisibility(checkbox.getState());
            mos.repaint();
            return true;
        } else if (event.target == dimension) {
            mos.setDimension(dimension.getSelectedItem());
            mos.repaint();
            return true;

        } else if (event.target == printButton) {
            printComponent(mos);
            return true;
        }
        return false;
    }

    public void printComponent(Component component) {

        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");

        pj.setPrintable((pg, pf, pageNum) -> {
            if (pageNum > 0) return Printable.NO_SUCH_PAGE;

            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            component.paint(g2);
            return Printable.PAGE_EXISTS;
        });

        if (!pj.printDialog()) return;

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }

    protected abstract String getVdLabel();

    private double getVt(String s)
            throws NumberFormatException {
        double d = 0.0D;
        StringTokenizer stringtokenizer = new StringTokenizer(s);
        int i;
        for (i = 0; stringtokenizer.hasMoreElements() && i < 3; i++) {
            String s1 = stringtokenizer.nextToken();
            if (i == 2)
                d = new Double(s1);
        }

        if (i < 2)
            throw new NumberFormatException();
        else
            return d;
    }

    private void initComps() {
        Vgs = new Label("Vgs");
        Vgs.setAlignment(Label.RIGHT);
        Vd = new Label(getVdLabel());
        Vd.setAlignment(Label.RIGHT);
        vgs = new UpDown10(12, 25, Color.black, Color.lightGray);
        vd = new UpDown10(12, 25, Color.black, Color.lightGray);
        nVt = new Choice();
        nVt.addItem("Vt = 0.5 V");
        nVt.addItem("Vt = 1.0 V");
        nVt.addItem("Vt = 1.5 V");
        nVt.addItem("Vt = 2.0 V");
        nVt.addItem("Vt = 3.0 V");
        nVt.addItem("Vt = 4.0 V");
        pVt = new Choice();
        pVt.addItem("Vt = -0.5 V");
        pVt.addItem("Vt = -1.0 V");
        pVt.addItem("Vt = -1.5 V");
        pVt.addItem("Vt = -2.0 V");
        pVt.addItem("Vt = -3.0 V");
        pVt.addItem("Vt = -4.0 V");
        choice = nVt;
        choice.select(1);
        channelType = new Choice();
        channelType.addItem("N-channel");
        channelType.addItem("P-channel");
        channelType.select("N-channel");
        checkbox = new Checkbox("show labels");
        checkbox.setState(true);
        dimension = new Choice();
        dimension.addItem("3D");
        dimension.addItem("2D");
        dimension.select("3D");
        printButton = new Button("print");
    }

    private void setChoice() {
        remove(choice);
        choice = nChannel ? nVt : pVt;
        add(choice, 5);
        validate();
        choice.select(1);
    }
}