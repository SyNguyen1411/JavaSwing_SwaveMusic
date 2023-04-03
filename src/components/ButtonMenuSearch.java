/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Phan Qui Duc
 */
public class ButtonMenuSearch extends JButton {

    public int[] getRadious () {
        return radious;
    }

    public void setRadious (int[] radious) {
        this.radious = radious;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public boolean isCheckClick() {
        return checkClick;
    }

    public void setCheckClick(boolean checkClick) {
        this.checkClick = checkClick;
    }
    
    private Color color1 = Color.decode("#C7C7C7"); //White
    private Color color2 = Color.decode("#434343"); //Black
    private float alpha = 0.1f;
    private int [] radious = {0,0};
    private final Timer timer;
    private boolean mouseOver;
    private boolean checkClick = false;

    public ButtonMenuSearch() {
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(5, 10, 5, 10));
        setForeground(getColor1());
        setFont(new Font("Roboto", Font.BOLD, 16));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (isCheckClick() == false) {
                    mouseOver = true;
                    timer.start();
                    changePaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isCheckClick() == false) {
                    mouseOver = false;
                    timer.start();
                    rePaint();
                }
            }
        });
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mouseOver) {
                    setForeground(color2);
                    if (alpha < 0.9f) {
                        alpha += 0.1f;
                        repaint();
                    } else {
                        alpha = 0.9f;
                        timer.stop();
                        repaint();
                    }
                } else {
                    setForeground(color1);
                    if (alpha > 0.1f) {
                        alpha -= 0.1f;
                        repaint();
                    } else {
                        alpha = 0.1f;
                        timer.stop();
                        repaint();
                    }
                }
            }
        });
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, getColor2(), width, 0, getColor2());
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, width, height, radious[0], radious[1]);
        createStyle(g2);
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }
    
    private void createStyle(Graphics2D g2) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        setForeground(color1);
        int width = getWidth();
        int height = getHeight();
        GradientPaint gra = new GradientPaint(0, 0, color2, 0, 0, color2);
        g2.setPaint(gra);
        Path2D.Float f = new Path2D.Float();
        f.moveTo(0, 0);
        int controll = height + height + height / 4;
        f.curveTo(0, 0, width / 2, controll, width, 0);
        g2.fill(f.getBounds());
    }
    
    public void changePaint() {
        setColor1(Color.decode("#434343"));
        setColor2(Color.decode("#C7C7C7"));
        repaint();
    }
    
    public void rePaint() {
        setColor1(Color.decode("#C7C7C7"));
        setColor2(Color.decode("#434343"));
        repaint();
    }    
}
