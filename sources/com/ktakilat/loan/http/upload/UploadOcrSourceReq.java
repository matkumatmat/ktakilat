package com.ktakilat.loan.http.upload;

public class UploadOcrSourceReq {
    public String ocrFileUrl;
    public String sourceUrl;

    public UploadOcrSourceReq(String str, String str2) {
        this.ocrFileUrl = str;
        this.sourceUrl = str2;
    }
}
