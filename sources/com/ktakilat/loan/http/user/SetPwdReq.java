package com.ktakilat.loan.http.user;

public class SetPwdReq {
    public String password;
    public String verifyToken;

    public SetPwdReq(String str) {
        this.password = str;
    }

    public SetPwdReq(String str, String str2) {
        this.verifyToken = str;
        this.password = str2;
    }
}
