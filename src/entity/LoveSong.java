/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class LoveSong {
    private int position;
    private int songID;
    private int userID;

    public LoveSong() {
    }

    public LoveSong(int position, int songID, int userID) {
        this.position = position;
        this.songID = songID;
        this.userID = userID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    @Override
    public String toString() {
        return "LoveSong{" + "position=" + position + ", songID=" + songID + ", userID=" + userID + '}';
    }
    
}
