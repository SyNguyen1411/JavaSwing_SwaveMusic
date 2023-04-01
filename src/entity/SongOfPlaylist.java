/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Qui Duc
 */
public class SongOfPlaylist {
    private int position;
    private int playlistID;
    private int songID;

    public SongOfPlaylist () {
    }

    public SongOfPlaylist (int position, int playlistID, int songID) {
        this.position = position;
        this.playlistID = playlistID;
        this.songID = songID;
    }

    public int getPosition () {
        return position;
    }

    public void setPosition (int position) {
        this.position = position;
    }

    public int getPlaylistID () {
        return playlistID;
    }

    public void setPlaylistID (int playlistID) {
        this.playlistID = playlistID;
    }

    public int getSongID () {
        return songID;
    }

    public void setSongID (int songID) {
        this.songID = songID;
    }

    @Override
    public String toString () {
        return "SongOfPlaylist{" + "position=" + position + ", playlistID=" + playlistID + ", songID=" + songID + '}';
    }
    
}
