package com.example.volleydemo.bean;

import java.io.Serializable;


public class AppUser implements Serializable{


  
	private static final long serialVersionUID = 5725484926116734050L;
	private int userid;
    private long lastlogin;
    private long unlocktime;
    private String username;
    private String token;
    private int trytimes;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public long getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(long lastlogin) {
        this.lastlogin = lastlogin;
    }

    public long getUnlocktime() {
        return unlocktime;
    }

    public void setUnlocktime(long unlocktime) {
        this.unlocktime = unlocktime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTrytimes() {
        return trytimes;
    }

    public void setTrytimes(int trytimes) {
        this.trytimes = trytimes;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userid=" + userid +
                ", lastlogin=" + lastlogin +
                ", unlocktime=" + unlocktime +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", trytimes=" + trytimes +
                '}';
    }
}
