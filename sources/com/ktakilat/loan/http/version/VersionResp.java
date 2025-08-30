package com.ktakilat.loan.http.version;

public class VersionResp {
    private String appName;
    private String content;
    private String downloadLink;
    private String endVersion;
    private String popUpsCode;
    private String startVersion;
    private String status;
    private String updateType;

    public String getAppName() {
        return this.appName;
    }

    public String getContent() {
        return this.content;
    }

    public String getDownloadLink() {
        return this.downloadLink;
    }

    public String getEndVersion() {
        return this.endVersion;
    }

    public String getPopUpsCode() {
        return this.popUpsCode;
    }

    public String getStartVersion() {
        return this.startVersion;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUpdateType() {
        return this.updateType;
    }

    public boolean isCurForce() {
        return "Force".equals(this.updateType);
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDownloadLink(String str) {
        this.downloadLink = str;
    }

    public void setEndVersion(String str) {
        this.endVersion = str;
    }

    public void setPopUpsCode(String str) {
        this.popUpsCode = str;
    }

    public void setStartVersion(String str) {
        this.startVersion = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUpdateType(String str) {
        this.updateType = str;
    }
}
