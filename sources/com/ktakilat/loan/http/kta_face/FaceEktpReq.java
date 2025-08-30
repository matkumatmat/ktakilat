package com.ktakilat.loan.http.kta_face;

public class FaceEktpReq {
    public String ektp;
    public String token;

    public FaceEktpReq(String str, String str2) {
        this.token = str;
        this.ektp = str2;
    }
}
