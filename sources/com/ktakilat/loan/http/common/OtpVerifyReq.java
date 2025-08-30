package com.ktakilat.loan.http.common;

public class OtpVerifyReq {
    public String code;
    public String token;

    public OtpVerifyReq(String str, String str2) {
        this.code = str;
        this.token = str2;
    }
}
