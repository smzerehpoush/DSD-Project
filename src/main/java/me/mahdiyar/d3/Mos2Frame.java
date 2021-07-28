package me.mahdiyar.d3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class Mos2Frame extends Frame implements Printable, ActionListener {

    private final Mos2Panel mos2Panel;

    public Mos2Frame() throws HeadlessException {
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        mos2Panel = new Mos2Panel();
        mos2Panel.setSize(800, 600);
        add("Center", mos2Panel);
        setSize(800, 600);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Button printButton = new Button("Print This Window");
        printButton.addActionListener(this);
        add("South", printButton);
    }

    public static void main(String[] args) {
        Frame frame = new Mos2Frame();
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        mos2Panel.printAll(g);
        return PAGE_EXISTS;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                /* The job did not successfully complete */
            }
        }
    }

}
