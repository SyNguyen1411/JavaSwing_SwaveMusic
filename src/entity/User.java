/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Phan Qui Duc
 */
public class User {

    private int userID;
    private String fullname;
    private Date birthDate;
    private boolean gender;
    private String email;
    private String avt;
    private String account;

    public User(int userID, String fullname, Date birthDate, boolean gender, String email, String avt, String account) {
        this.userID = userID;
        this.fullname = fullname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.avt = avt;
        this.account = account;
    }

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Icon toIcon() {
        return new ImageIcon("../Swave/src/img/avt/" + avt);
    }

}
