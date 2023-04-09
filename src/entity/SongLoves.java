/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;import java.util.Date;

/**
 *
 * @author HP
 */
public class SongLoves {
    private int songID;
    private int userID;
    private Date lovesDate;

    public SongLoves() {
    }

    public SongLoves(int songID, int userID, Date lovesDate) {
        this.songID = songID;
        this.userID = userID;
        this.lovesDate = lovesDate;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getlovesDate() {
        return lovesDate;
    }

    public void setlovesDate(Date lovesDate) {
        this.lovesDate = lovesDate;
    }

    @Override
    public String toString() {
        return "LovesSong{" + "songID=" + songID + ", userID=" + userID + ", lovesDate=" + lovesDate + '}';
    }
    
}
