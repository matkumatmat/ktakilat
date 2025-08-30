package com.ktakilat.loan.http.change_phone;

public class CheckPwdReq {
    public String mobileNo;
    public String password;

    public CheckPwdReq(String str, String str2) {
        this.mobileNo = str;
        this.password = str2;
    }
}
