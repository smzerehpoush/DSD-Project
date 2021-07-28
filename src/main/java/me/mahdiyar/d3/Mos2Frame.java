package me.mahdiyar.d3;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Mos2Frame extends Frame {

    private Button printButton;
    private Mos2Panel mos2Panel;

    public Mos2Frame() throws HeadlessException {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        printButton = new Button("print me!");
        mos2Panel = new Mos2Panel();
        mos2Panel.setSize(800, 600);
        add("Center", mos2Panel);
        add("North", printButton);
        setSize(800, 600);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public boolean action(Event event, Object what) {
        if (event.target == printButton) {
            printComponent(mos2Panel);
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
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        new Mos2Frame();
    }
}
