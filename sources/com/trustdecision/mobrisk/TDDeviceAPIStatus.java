package com.trustdecision.mobrisk;

public class TDDeviceAPIStatus {
    private int code;
    private String message;

    public TDDeviceAPIStatus(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
