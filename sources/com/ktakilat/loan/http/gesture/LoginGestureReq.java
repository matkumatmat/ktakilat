package com.ktakilat.loan.http.gesture;

public class LoginGestureReq {
    public double loginLat;
    public double loginLng;
    public String mobileNo;
    public String password;

    public LoginGestureReq(String str, String str2, double d, double d2) {
        this.mobileNo = str;
        this.password = str2;
        this.loginLat = d;
        this.loginLng = d2;
    }
}
