/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tien.ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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
public class Button extends JButton {

    /**
     * @return the sizeSpeed
     */
    public float getSizeSpeed() {
        return sizeSpeed;
    }

    /**
     * @param sizeSpeed the sizeSpeed to set
     */
    public void setSizeSpeed(float sizeSpeed) {
        this.sizeSpeed = sizeSpeed;
    }

    /**
     * @return the color1
     */
    public Color getColor1() {
        return color1;
    }

    /**
     * @param color1 the color1 to set
     */
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    /**
     * @return the color2
     */
    public Color getColor2() {
        return color2;
    }

    /**
     * @param color2 the color2 to set
     */
    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1 = Color.decode("#a936ff");
    private Color color2 = Color.decode("#e983ff");
    private final Timer timer;
    private final Timer timerPressed;
    private float alpha = 0.1f;
    private boolean mouseOver;
    private boolean pressed;
    private Point pressedLocation;
    private float pressedSize;
    private float sizeSpeed = 1f;
    private float alphaPressed = 0.5f;

    public Button() {
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(10, 20, 10, 20));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressedSize = 0;
                alphaPressed = 0.5f;
                pressed = true;
                pressedLocation = e.getPoint();
                timerPressed.setDelay(0);
                timerPressed.start();
            }

        });
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mouseOver) {
                    if (alpha < 0.9f) {
                        alpha += 0.05f;
                        repaint();
                    } else {
                        alpha = 0.9f;
                        timer.stop();
                        repaint();
                    }
                } else {
                    if (alpha > 0.1f) {
                        alpha -= 0.05f;
                        repaint();
                    } else {
                        alpha = 0.1f;
                        timer.stop();
                        repaint();
                    }
                }
            }
        });

        timerPressed = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressedSize += getSizeSpeed();
                if (alphaPressed <= 0) {
                    pressed = false;
                    timerPressed.stop();
                } else {
                    repaint();
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

        //  Create color gradient
        GradientPaint gra = new GradientPaint(0, 0, getColor1(), width, 0, getColor2());
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, width, height, height, height);

        //  add style
        createStyle(g2);
        if (pressed) {
            paintPressed(g2);
        }
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }

    private void createStyle(Graphics2D g2) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        int width = getWidth();
        int height = getHeight();
        GradientPaint gra = new GradientPaint(0, 0, Color.decode("#9200b4"), 0, 0, getColor2());
        g2.setPaint(gra);
        Path2D.Float f = new Path2D.Float();
        f.moveTo(0, 0);
        int controll = height + height + height / 4;
        f.curveTo(0, 0, width / 2, controll, width, 0);
        g2.fill(f.getBounds());
    }

    private void paintPressed(Graphics2D g2) {
        if (pressedLocation.x - (pressedSize / 2) < 0 && pressedLocation.x + (pressedSize / 2) > getWidth()) {
            timerPressed.setDelay(20);
            alphaPressed -= 0.05f;
            if (alphaPressed < 0) {
                alphaPressed = 0;
            }
        }
        g2.setColor(getColor2());
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alphaPressed));
        float x = pressedLocation.x - pressedSize / 2;
        float y = pressedLocation.y - pressedSize / 2;
        g2.fillOval((int) x, (int) y, (int) pressedSize, (int) pressedSize);
    }
}
