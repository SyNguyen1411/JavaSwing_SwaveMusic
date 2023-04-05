package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JSlider;
import javax.swing.plaf.SliderUI;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 *
 * @author NGUYEN VAN SI
 */
public class Slidebar extends JSlider {

    public Slidebar() {
        setOpaque(false);
        this.setUI(new BasicSliderUI(this) {
            @Override
            public void paintThumb(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(165, 43, 168));
                g2.fillOval(thumbRect.x, thumbRect.y + 5, 11, 11);
            }

            @Override
            public void paintTrack(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(165, 43, 168));
                g2.fillRect(0, getHeight() / 2 - 2, thumbRect.x, 4);
                g2.setColor(Color.white);
                g2.fillRect(thumbRect.x, getHeight() / 2 - 2, getWidth(), 4);

            }

            @Override
            public void paintFocus(Graphics g) {

            }

        });

    }

}
