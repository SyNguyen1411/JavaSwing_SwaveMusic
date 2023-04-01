package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author NGUYEN VAN SI
 */
public class input extends JTextField {

    public input() {
        setBackground(new Color(255, 255, 255, 0));
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setOpaque(false);
    }
}
