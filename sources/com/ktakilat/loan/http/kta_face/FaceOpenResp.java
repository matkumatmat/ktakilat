package com.ktakilat.loan.http.kta_face;

public class FaceOpenResp {
    private String ektp;
    private int enableFaceLoginResult;
    private String twoFactorVerificationToken;

    public String getEktp() {
        return this.ektp;
    }

    public int getEnableFaceLoginResult() {
        return this.enableFaceLoginResult;
    }

    public String getTwoFactorVerificationToken() {
        return this.twoFactorVerificationToken;
    }

    public void setEktp(String str) {
        this.ektp = str;
    }

    public void setEnableFaceLoginResult(int i) {
        this.enableFaceLoginResult = i;
    }

    public void setTwoFactorVerificationToken(String str) {
        this.twoFactorVerificationToken = str;
    }
}
