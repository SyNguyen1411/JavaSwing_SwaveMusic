/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Phan Qui Duc
 */
public class Account {
    private String userID;
    private String password;
    private boolean role; // true là người dùng, false là manager
    private boolean status;

    public Account () {
    }

    public Account (String userID, String password, boolean role, boolean status) {
        this.userID = userID;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String getUserID () {
        return userID;
    }

    public void setUserID (String userID) {
        this.userID = userID;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public boolean isRole () {
        return role;
    }

    public void setRole (boolean role) {
        this.role = role;
    }

    public boolean isStatus () {
        return status;
    }

    public void setStatus (boolean status) {
        this.status = status;
    }

    @Override
    public String toString () {
        return "Account{" + "userID=" + userID + ", password=" + password + ", role=" + role + ", status=" + status + '}';
    }
    
}
