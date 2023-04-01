package model;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import swing.PlaylistItem;

/**
 *
 * @author NGUYEN VAN SI
 */
public class borderImage extends JComponent {

    String image = "playlist.png";
    Icon icon;
    int sizeImage[] = {220, 220};
    int border[] = {20, 20};

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int[] getSizeImage() {
        return sizeImage;
    }

    public void setSizeImage(int[] sizeImage) {
        this.sizeImage = sizeImage;
    }

    public void setBorder(int[] border) {
        this.border = border;
    }

    public borderImage() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        BufferedImage img = new BufferedImage(sizeImage[0], sizeImage[1], BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2_img = img.createGraphics();
        g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2_img.fillRoundRect(0, 0, sizeImage[0], sizeImage[1], border[0], border[1]);
        g2_img.setComposite(AlphaComposite.SrcIn);
        g2_img.drawImage(toImage(icon), 0, 0, sizeImage[0], sizeImage[1], null);

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, 0, 0, sizeImage[0], sizeImage[1], null);
        super.paintComponent(g);
    }

}
