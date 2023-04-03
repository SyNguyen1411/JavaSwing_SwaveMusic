/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.utilcomponent;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author Phan Qui Duc
 */
public class ScrollBarCustom extends JScrollBar {
    public ScrollBarCustom(){
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8,8));
        setForeground(new Color(48,144,216));
        setBackground(new Color(0,0,0,255));
        setUnitIncrement(20);
    }
    
}
