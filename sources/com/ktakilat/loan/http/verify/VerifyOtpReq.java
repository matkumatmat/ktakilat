package com.ktakilat.loan.http.verify;

public class VerifyOtpReq {
    public String code;
    public double loginLat;
    public double loginLng;
    public int scene;
    public String token;

    public VerifyOtpReq(int i, String str, String str2, double d, double d2) {
        this.scene = i;
        this.token = str;
        this.code = str2;
        this.loginLat = d;
        this.loginLng = d2;
    }
}
