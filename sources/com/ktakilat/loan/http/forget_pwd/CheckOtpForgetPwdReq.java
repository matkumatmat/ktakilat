package com.ktakilat.loan.http.forget_pwd;

public class CheckOtpForgetPwdReq {
    public String code;
    public String verifyToken;

    public CheckOtpForgetPwdReq(String str, String str2) {
        this.verifyToken = str;
        this.code = str2;
    }
}
