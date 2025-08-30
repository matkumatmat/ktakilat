package com.ktakilat.loan.http.upload;

import com.ktakilat.cbase.checkvalue.NotEmpty;

public class UploadFileResp {
    private String filename;
    private String ossFilePath;
    private String status;
    @NotEmpty
    private String uploadUrl;

    public String getFilename() {
        return this.filename;
    }

    public String getOssFilePath() {
        return this.ossFilePath;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUploadUrl() {
        return this.uploadUrl;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setOssFilePath(String str) {
        this.ossFilePath = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUploadUrl(String str) {
        this.uploadUrl = str;
    }
}
