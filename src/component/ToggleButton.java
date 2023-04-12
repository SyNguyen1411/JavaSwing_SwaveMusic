/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

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
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author CAMERA VIET PHAT
 */
public class ToggleButton extends JToggleButton {

    public int[] getRadious() {
        return radious;
    }

    public void setRadious(int[] radious) {
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

    public Color getColor3() {
        return color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    private Color color1 = Color.decode("#FFFFFF"); //White
    private Color color2 = Color.decode("#000000"); //Black
    private Color color3 = Color.decode("#C7C7C7"); //Gray
    private int[] radious = {40, 40};

    public ToggleButton() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setForeground(getColor2());
        setFont(new Font("Roboto", Font.BOLD, 16));
        setBackground(new Color(255, 255, 255, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, getColor1(), width, 0, getColor1());
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, width, height, radious[0], radious[1]);
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
    }
}
