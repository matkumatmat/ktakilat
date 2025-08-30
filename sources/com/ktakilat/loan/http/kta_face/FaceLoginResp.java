package com.ktakilat.loan.http.kta_face;

import com.ktakilat.loan.http.user.UserLoginResp;

public class FaceLoginResp {
    private String ektp;
    private int faceLoginResult;
    private UserLoginResp loginResp;
    private String twoFactorVerificationToken;

    public String getEktp() {
        return this.ektp;
    }

    public int getFaceLoginResult() {
        return this.faceLoginResult;
    }

    public UserLoginResp getLoginResp() {
        return this.loginResp;
    }

    public String getTwoFactorVerificationToken() {
        return this.twoFactorVerificationToken;
    }

    public void setEktp(String str) {
        this.ektp = str;
    }

    public void setFaceLoginResult(int i) {
        this.faceLoginResult = i;
    }

    public void setLoginResp(UserLoginResp userLoginResp) {
        this.loginResp = userLoginResp;
    }

    public void setTwoFactorVerificationToken(String str) {
        this.twoFactorVerificationToken = str;
    }
}
