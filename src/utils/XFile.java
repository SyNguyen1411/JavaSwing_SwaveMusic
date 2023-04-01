/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JTextArea;

/**
 *
 * @author CAMERA VIET PHAT
 */
public class XFile {
    public static void read (String nameFile, JTextArea content) {
        String path = "file\\" + nameFile;
        try {
            BufferedReader br = new BufferedReader (new FileReader(path));
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
}
