/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Phan Qui Duc
 */
public class Comment {
    private int commentID;
    private int position;
    private String content;
    private Timestamp commentDate;
    private int songID;
    private int userID;

    public Comment () {
    }

    public Comment (int commentID, int position, String content, Timestamp commentDate, int songID, int userID) {
        this.commentID = commentID;
        this.position = position;
        this.content = content;
        this.commentDate = commentDate;
        this.songID = songID;
        this.userID = userID;
    }

    public int getUserID () {
        return userID;
    }

    public void setUserID (int userID) {
        this.userID = userID;
    }

    public int getCommentID () {
        return commentID;
    }

    public void setCommentID (int commentID) {
        this.commentID = commentID;
    }

    public int getPosition () {
        return position;
    }

    public void setPosition (int position) {
        this.position = position;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Timestamp getCommentDate () {
        return commentDate;
    }

    public void setCommentDate (Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public int getSongID () {
        return songID;
    }

    public void setSongID (int songID) {
        this.songID = songID;
    }

    @Override
    public String toString () {
        return "Comment{" + "commentID=" + commentID + ", position=" + position + ", content=" + content + ", commentDate=" + commentDate + ", songID=" + songID + ", userID=" + userID + '}';
    }
    
    
}
