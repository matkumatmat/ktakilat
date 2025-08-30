package com.trustdecision.mobrisk;

public class TDAPISignResult {
    private int code;
    private String msg;
    private String sign;

    public TDAPISignResult(String str, int i, String str2) {
        this.sign = str;
        this.code = i;
        this.msg = str2;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.msg;
    }

    public String signature() {
        return this.sign;
    }
}
