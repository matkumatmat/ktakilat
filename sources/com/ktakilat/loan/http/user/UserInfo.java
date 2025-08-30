package com.ktakilat.loan.http.user;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = -3777765966772833346L;
    private String mobileNo;
    private String token;
    private String userId;

    public UserInfo() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public UserInfo(String str, String str2, String str3) {
        this.token = str;
        this.userId = str2;
        this.mobileNo = str3;
    }
}
