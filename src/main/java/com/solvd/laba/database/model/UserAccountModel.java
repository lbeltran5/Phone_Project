package com.solvd.laba.database.model;

public class UserAccountModel {
    private int userId;
    private String userName;
    private String userEmail;
    private String userComment;

    public UserAccountModel(int userId, String userName, String userEmail, String userComment) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userComment = userComment;
    }

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
