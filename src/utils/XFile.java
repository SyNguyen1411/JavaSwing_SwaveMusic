/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.swing.JTextArea;

/**
 *
 * @author CAMERA VIET PHAT
 */
public class XFile {

    public static void read(String nameFile, JTextArea content) {
        String path = "file\\" + nameFile;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    content.append(line);
                    content.append("\r\n");
                }
            }
            br.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyFileUsingStream(File source, File dest) throws IOException {
        if (source.equals(dest)) {
            return;
        }
        boolean result = Files.deleteIfExists(dest.toPath());
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
