package com.ktakilat.loan.http.user;

public class PwdCheckReq {
    public String mobileNo;
    public String password;

    public PwdCheckReq(String str) {
        this.password = str;
    }

    public PwdCheckReq(String str, String str2) {
        this.password = str2;
        this.mobileNo = str;
    }
}
