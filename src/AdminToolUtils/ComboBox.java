package AdminToolUtils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

public class ComboBox extends JComboBox{
            public ComboBox() {
                setOpaque(false);
                setForeground(Color.WHITE);
                setCursor(new Cursor( Cursor.HAND_CURSOR));
                setBorder(new EmptyBorder(10, 10, 10, 10));      
            }
            
            @Override
            protected void paintComponent(Graphics g){
                        int width = getWidth();
                        int height = getHeight();
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // For smooth line
                        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); // For smooth image
                        g2.setColor(getBackground());
                        g2.fillRoundRect(0, 0, width-1, height-1, 10, 10);
//                       g2.fill(new RoundRectangle2D.Double(0,0, width-1, height-1, 10,10));
//                        g2.dispose();
                        super.paintComponent(g);
    }
}
