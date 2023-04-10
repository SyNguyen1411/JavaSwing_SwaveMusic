package entity;

import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author NGUYEN VAN SI
 */
public class Song {

    private int songID;
    private String nameSong;
    private String musician;
    private String singer;
    private String category;
    private String fileLyrics;
    private String AVT;
    private String fileSong;
    private boolean status;
    private int userID;
    public int minutetotalLength;
    public int secondTotalLength;

    public Song() throws UnsupportedAudioFileException, IOException {
        this(0, "", "", "", "", "", "", "", true, 0);
    }
    
    public Song(int songID, String nameSong, String musician, String singer, String category, String fileLyrics, String AVT, String fileSong, boolean status, int userID) throws UnsupportedAudioFileException, IOException {
        this.songID = songID;
        this.nameSong = nameSong;
        this.musician = musician;
        this.singer = singer;
        this.category = category;
        this.fileLyrics = fileLyrics;
        this.AVT = AVT;
        this.fileSong = fileSong;
        this.status = status;
        this.userID = userID;

    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFileLyrics() {
        return fileLyrics;
    }

    public void setFileLyrics(String fileLyrics) {
        this.fileLyrics = fileLyrics;
    }

    public String getAVT() {
        return AVT;
    }

    public void setAVT(String AVT) {
        this.AVT = AVT;
    }

    public String getFileSong() {
        return fileSong;
    }

    public void setFileSong(String fileSong) {
        this.fileSong = fileSong;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/img/song/" + AVT));
    }


}
