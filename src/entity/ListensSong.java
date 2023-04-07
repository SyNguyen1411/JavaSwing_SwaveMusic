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
public class ListensSong {
    private int position;
    private int songID;
    private int userID;
    private Date ListenDate;

    public ListensSong() {
    }

    public ListensSong(int position, int songID, int userID, Date ListenDate) {
        this.position = position;
        this.songID = songID;
        this.userID = userID;
        this.ListenDate = ListenDate;
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

    public Date getListenDate() {
        return ListenDate;
    }

    public void setListenDate(Date ListenDate) {
        this.ListenDate = ListenDate;
    }

    @Override
    public String toString() {
        return "ListensSong{" + "position=" + position + ", songID=" + songID + ", userID=" + userID + ", ListenDate=" + ListenDate + '}';
    }
   
}
