package com.ktakilat.loan.http.verify;

public class VerifyMethodReq {
    public String mobileNo;
    public int scene;

    public VerifyMethodReq(String str, int i) {
        this.mobileNo = str;
        this.scene = i;
    }
}
