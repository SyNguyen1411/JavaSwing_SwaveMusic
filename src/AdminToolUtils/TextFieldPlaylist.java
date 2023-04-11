/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminToolUtils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Admin
 */
public class TextFieldPlaylist extends JTextField {
    private String placeHolder = "Email hoặc tên đăng nhập";

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    public TextFieldPlaylist() {
        setOpaque(false);
        setBackground(new Color(0,0,0,1)); 
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setMargin(new Insets(0, 30, 0, 0)); 
        setForeground(Color.white);
    }


    @Override
    protected void paintComponent(Graphics g) {
        // Draw Border
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // For smooth line
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); // For smooth image
        g2.setColor(Color.decode("#585858"));
        g2.fillRoundRect(0, 0, width-1, height-1, 30, 30);
        super.paintComponent(g);
//        g2.dispose();
    }


    @Override
    public void paint(Graphics g) {
        // Set place holder
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            g.setColor(Color.WHITE);
            g.drawString(placeHolder, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
//        setOpaque(false);
//        g.dispose();
    }
}
