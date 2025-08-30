package com.ktakilat.loan.http.phone_code;

public class PhoneCodeVerifyReq {
    public String code;
    public String verifyToken;

    public PhoneCodeVerifyReq(String str, String str2) {
        this.verifyToken = str;
        this.code = str2;
    }
}
