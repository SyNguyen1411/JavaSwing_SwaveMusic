/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.utilcomponent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Phan Qui Duc
 */
public class FindTextField extends JTextField {

    private Color color1 = Color.decode("#a936ff");
    private Color color2 = Color.decode("#e983ff");
    private Color backgroundColor = Color.white;
    private int leftBorder = 20;
    private int rightBorder = 20;
    private Icon prefixIcon;
    private Icon suffixIcon;
    private String hintText = "Bạn muốn nghe bài nào?";

    
    public Icon getPrefixIcon () {
        return prefixIcon;
    }
    
    public void setPrefixIcon (Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();   
    }

    public Icon getSuffixIcon () {
        return suffixIcon;
    }

    public void setSuffixIcon (Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
        initBorder();
    }
    
    /**
     * @return the color1
     */
    public Color getColor1 () {
        return color1;
    }

    /**
     * @param color1 the color1 to set
     */
    public void setColor1 (Color color1) {
        this.color1 = color1;
    }

    /**
     * @return the color2
     */
    public Color getColor2 () {
        return color2;
    }

    /**
     * @param color2 the color2 to set
     */
    public void setColor2 (Color color2) {
        this.color2 = color2;
    }

    public FindTextField () {
        setBackground(new Color(0, 0, 0, 1)); // Remove background
        setOpaque(false);
        prefixIcon = new ImageIcon(getClass().getResource("/icons/search.png"));
        suffixIcon = new ImageIcon(getClass().getResource("/icons/clear.png"));
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        initBorder();
        setBorder(new EmptyBorder(10, leftBorder, 10, rightBorder));
        setMargin(new Insets(0, 30, 0, 0));
        // Create and check if mouse over button
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e){
                if (checkMouseOver(e.getPoint())) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                else{
                    setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
            }
        });
        
        //  Create mouse click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (checkMouseOver(e.getPoint())) {
                        System.out.println("Mouse Pressed");
                        setText("");
                    }
                }
            }
        });
        
    }
    
    private void initBorder(){
        if(prefixIcon!=null){
            leftBorder = 50;
        }else{
            leftBorder = 20;
        }
        if(suffixIcon!=null){
            rightBorder = 30;
        }else{
            rightBorder = 20;
        }
    }

    @Override
    protected void paintComponent (Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // For smooth line
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); // For smooth image
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, width, height, height, height);
        super.paintComponent(g);
        
        //  Create color gradient 
        int marginButton = 5;
        int buttonSize = height-marginButton*2;
        GradientPaint gra = new GradientPaint(0, 0, getColor1(), width, 0, getColor2());
        g2.setPaint(gra);
        g2.fillOval(width-height+3, marginButton, buttonSize, buttonSize);

        //  Create button icon
        int marginImage = 5;
        int imageSize = buttonSize - marginImage*2;
        Image image;
        if (!getText().isEmpty()) {
            image = ((ImageIcon) suffixIcon).getImage();
        }else{
            image = null;
        }
        g2.drawImage(image, width-height+marginImage+3, marginButton+marginImage,imageSize,imageSize,null);

        Image prefixImage = ((ImageIcon) prefixIcon).getImage();
        g2.drawImage(prefixImage, 8, marginButton+marginImage,imageSize,imageSize,null);
        //g2.dispose();
        //g.dispose();
    }
    
    private boolean checkMouseOver(Point mouse){
        int width = getWidth();
        int height = getHeight();
        int marginButton = 5;
        int buttonSize = height -marginButton*2;
        Point point = new Point(width - height+3,marginButton);
        Ellipse2D.Double circle = new Ellipse2D.Double(point.x, point.y, buttonSize, buttonSize);
        return circle.contains(mouse);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            int c0 = getBackground().getRGB();
            int c1 = getForeground().getRGB();
            int m = 0xfefefefe;
            int c2 = ((c0 & m) >>> 1) + ((c1 & m) >>> 1);
            g.setColor(new Color(c2, true));
            g.drawString(hintText, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
        //g.dispose();
    }
}
