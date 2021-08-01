package v10.mos_2;

import java.awt.*;
import java.awt.event.MouseEvent;

public class UpDownCanvas10 extends UpDownCanvas {

    public UpDownCanvas10(int i, int j, Color color, Color color1) {
        super(i, j, color, color1);
    }

    @Override
    protected void processMouseMotionEvent(MouseEvent e) {
        int i = e.getX();
        int j = e.getY();

        if (i >= 0 && i <= super.width && j >= 0 && j <= super.dyArrow) {
            if (super.listener != null)
                super.listener.start();
            super.topPressed = true;
            repaint();
            return;
        }
        if (i >= 0 && i <= super.width && super.dyArrow < j && j <= super.height) {
            if (super.listener != null)
                super.listener.start();
            super.bottomPressed = true;
            repaint();
        }
        if (super.topPressed && (i < 0 || i > super.width || j < 0 || j > super.dyArrow)) {
            if (super.listener != null)
                super.listener.stop();
            super.topPressed = false;
            repaint();
        }
        if (super.bottomPressed && (i < 0 || i > super.width || j < super.dyArrow || j > super.height)) {
            if (super.listener != null)
                super.listener.stop();
            super.bottomPressed = false;
            repaint();

        }
        if (super.listener != null)
            super.listener.stop();
        if (super.topPressed) {
            super.topPressed = false;
            repaint();
        }
        if (super.bottomPressed) {
            super.bottomPressed = false;
            repaint();
        }
    }
}
