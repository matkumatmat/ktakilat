package com.ktakilat.loan.http.login;

public class LoginFaceLicenseResp {
    private Long expiryTimestamp;
    private String license;

    public Long getExpiryTimestamp() {
        return this.expiryTimestamp;
    }

    public String getLicense() {
        return this.license;
    }
}
