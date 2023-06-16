package com.solvd.laba.database.model;
/*
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "UserAccount")
@XmlAccessorType(XmlAccessType.FIELD)*/
public class UserAccountModel {
   // @XmlElement(name = "Id")
    private int userId;

    //@XmlElement(name = "Name")
    private String userName;

    //@XmlElement(name = "Email")
    private String userEmail;

    //@XmlElement(name = "Comment")
    private String userComment;

    public UserAccountModel(int userId, String userName, String userEmail, String userComment) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userComment = userComment;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }
}
