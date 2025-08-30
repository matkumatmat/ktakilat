package com.ktakilat.loan.http.user;

public class VerifyPhoneCodeNoLoginReq {
    public String code;
    public double loginLat;
    public double loginLng;
    public String oldMobileNo;
    public String verifyToken;

    public VerifyPhoneCodeNoLoginReq(String str, String str2, String str3, double d, double d2) {
        this.verifyToken = str;
        this.code = str2;
        this.oldMobileNo = str3;
        this.loginLat = d;
        this.loginLng = d2;
    }

    public VerifyPhoneCodeNoLoginReq(String str, String str2, double d, double d2) {
        this.verifyToken = str;
        this.code = str2;
        this.loginLat = d;
        this.loginLng = d2;
    }
}
