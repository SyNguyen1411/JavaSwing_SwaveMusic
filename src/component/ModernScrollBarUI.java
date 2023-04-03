/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import swing.utilcomponent.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Phan Qui Duc
 */
public class ModernScrollBarUI extends BasicScrollBarUI {
    
    private final int THUMB_SIZE = 150;

    @Override
    protected Dimension getMaximumThumbSize () {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0,THUMB_SIZE);
        }
        else{
            return new Dimension(THUMB_SIZE,0);
        }
        
    }

    @Override
    protected JButton createDecreaseButton (int orientation) {
        return new ScrollBarButton();
    }

    @Override
    protected JButton createIncreaseButton (int orientation) {
        return new ScrollBarButton();
    }

    
    @Override
    protected Dimension getMinimumThumbSize () {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0,THUMB_SIZE);
        }
        else{
            return new Dimension(THUMB_SIZE,0);
        }
    }
    
    
    @Override
    protected void paintTrack (Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int orientation = scrollbar.getOrientation();
        int size;
        int x;
        int y;
        int width;
        int height;
        if (orientation == JScrollBar.VERTICAL) {
            size = trackBounds.width / 2;
            x = trackBounds.x + (trackBounds.width - size) / 2;
            y = trackBounds.y;
            width = size;
            height = trackBounds.height;
        }
        else {
            size = trackBounds.height / 2;
            y = trackBounds.y + (trackBounds.height - size) / 2;
            x = trackBounds.x;
            width = trackBounds.width;
            height = size;
        }
        g2.setColor(new Color(0, 0 , 0,255));
        g2.fillRect(x, y, width, height);
    }

    @Override
    protected void paintThumb (Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = thumbBounds.x;
        int y =thumbBounds.y;
        int width = thumbBounds.width;
        int height = thumbBounds.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 8;
            height -= 16;
        }else{
            x += 8;
            width -= 16;
        }
        //new Color(165,43,168)
        g2.setColor(new Color(165,43,168));
        g2.fillRoundRect(x, y, width, height,10,10);
    }

    
    private class ScrollBarButton extends JButton{
        public ScrollBarButton(){
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint (Graphics g) {
            
        }
        
        
    }
    
}
