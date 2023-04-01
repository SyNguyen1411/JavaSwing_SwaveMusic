package utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Nguyễn Văn Sĩ
 */
public class XImage {

    public static ImageIcon getAppIcon() {
        URL url = XImage.class.getResource("/icons/play.png");
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return new ImageIcon(url);
    }
    
    public static boolean save(File src) {
        File dst = new File("src\\icon", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();//Tạo thư mục
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ImageIcon read(String fileName) {
        File path = new File("src\\icon", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
