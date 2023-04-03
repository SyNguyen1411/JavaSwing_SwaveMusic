package component;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8,8));
        setForeground(new Color(48,144,216));
        setBackground(new Color(0,0,0,255));
        setUnitIncrement(20);
    }
}
