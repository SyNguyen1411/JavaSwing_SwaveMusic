package entity;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author NGUYEN VAN SI
 */
public class PlayList {

    private int playlistID;
    private String playlistName;
    private int userID;
    private boolean status;
    private String icon;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    
    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public PlayList() {
    }

    public PlayList(int playlistID, String playlistName, int userID, boolean status, String icon) {
        this.playlistID = playlistID;
        this.playlistName = playlistName;
        this.userID = userID;
        this.status = status;
        this.icon = icon;
    }
    

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/img/" + icon));
    }
}
