/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Qui Duc
 */
public class LikedSong {
    private int id;
    private int songID;
    private int userID;

    public LikedSong (int id, int songID, int userID) {
        this.id = id;
        this.songID = songID;
        this.userID = userID;
    }

    public LikedSong () {
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getSongID () {
        return songID;
    }

    public void setSongID (int songID) {
        this.songID = songID;
    }

    public int getUserID () {
        return userID;
    }

    public void setUserID (int userID) {
        this.userID = userID;
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("LikedSong{");
        sb.append("id=").append(id);
        sb.append(", songID=").append(songID);
        sb.append(", userID=").append(userID);
        sb.append('}');
        return sb.toString();
    }
    
}
