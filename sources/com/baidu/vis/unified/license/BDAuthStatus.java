package com.baidu.vis.unified.license;

public class BDAuthStatus {
    public int dataType;
    public int errorID;
    public String msg;

    public BDAuthStatus(int i, int i2, String str) {
        this.errorID = i;
        this.dataType = i2;
        this.msg = str;
    }
}
