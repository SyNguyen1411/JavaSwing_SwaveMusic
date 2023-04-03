/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Qui Duc
 */
public class CommentReaction {
    private int commentID;
    private int userID;
    private boolean liked;
    private boolean reported;

    public CommentReaction () {
    }

    public CommentReaction (int commentID, int userID, boolean liked, boolean reported) {
        this.commentID = commentID;
        this.userID = userID;
        this.liked = liked;
        this.reported = reported;
    }

    public boolean isReported () {
        return reported;
    }

    public void setReported (boolean reported) {
        this.reported = reported;
    }

    public int getCommentID () {
        return commentID;
    }

    public void setCommentID (int commentID) {
        this.commentID = commentID;
    }

    public int getUserID () {
        return userID;
    }

    public void setUserID (int userID) {
        this.userID = userID;
    }

    public boolean isLiked () {
        return liked;
    }

    public void setLiked (boolean liked) {
        this.liked = liked;
    }
    
    
}
