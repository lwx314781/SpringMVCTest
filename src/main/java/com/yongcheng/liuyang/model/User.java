package com.yongcheng.liuyang.model;

import java.io.Serializable;

public class User implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 3548786401194627777L;

    private String userName;
    
    private String password;
    
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
