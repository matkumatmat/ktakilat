package com.ktakilat.loan.http.phone_code;

public class PhoneCodeReq {
    public String mobileNo;
    public int smsType;

    public PhoneCodeReq(String str, PhoneCodeType phoneCodeType) {
        this.mobileNo = str;
        this.smsType = phoneCodeType.getValue();
    }
}
