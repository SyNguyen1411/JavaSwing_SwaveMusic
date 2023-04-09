/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author HP
 */
public class PlaylistLoves {
    private int playlistID;
    private int userID;
    private Date lovesDate;

    public PlaylistLoves() {
    }

    public PlaylistLoves(int playlistID, int userID, Date lovesDate) {
        this.playlistID = playlistID;
        this.userID = userID;
        this.lovesDate = lovesDate;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getLovesDate() {
        return lovesDate;
    }

    public void setLovesDate(Date lovesDate) {
        this.lovesDate = lovesDate;
    }

    @Override
    public String toString() {
        return "LovesPlaylist{" + "playlistID=" + playlistID + ", userID=" + userID + ", lovesDate=" + lovesDate + '}';
    }
    
}
