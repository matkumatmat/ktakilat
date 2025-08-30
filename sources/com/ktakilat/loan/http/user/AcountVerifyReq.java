package com.ktakilat.loan.http.user;

public class AcountVerifyReq {
    public String channel;
    public String code;
    public String countryName;
    public String deviceNo;
    public double loginLat;
    public double loginLng;
    public String mobileNo;
    public String regChannel;
    public String stauts;
    public String token;

    public AcountVerifyReq(String str, String str2, String str3, String str4, double d, double d2, String str5, String str6, String str7) {
        this.mobileNo = str;
        this.countryName = str2;
        this.code = str3;
        this.token = str4;
        this.loginLat = d;
        this.loginLng = d2;
        this.deviceNo = str5;
        this.channel = str6;
        this.regChannel = str7;
    }
}
