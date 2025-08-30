package com.ktakilat.loan.http.user;

import com.ktakilat.cbase.checkvalue.NotEmpty;
import java.io.Serializable;

public class UserLoginResp implements Serializable {
    private static final long serialVersionUID = 4179078463652364106L;
    @NotEmpty
    private String mobileNo;
    @NotEmpty
    private String token;
    @NotEmpty
    private String userId;

    public String getMobileNo() {
        return this.mobileNo;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
