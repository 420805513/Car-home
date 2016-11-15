package com.example.dllo.carhome.myself;

/**
 * Created by dllo on 16/11/15.
 */
public class LogEvent {
    private String userName;
    private String userPassword;

    public LogEvent(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
