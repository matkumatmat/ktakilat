package com.trustdecision.android.shell.common;

public class TDDeviceAPIStatus {
    private String o0O00o00OOoOo0oooOoo00;
    private int o0Oo0OO00O0O000ooOO0;

    public TDDeviceAPIStatus(int i, String str) {
        this.o0Oo0OO00O0O000ooOO0 = i;
        this.o0O00o00OOoOo0oooOoo00 = str;
    }

    public int getCode() {
        return this.o0Oo0OO00O0O000ooOO0;
    }

    public String getMessage() {
        return this.o0O00o00OOoOo0oooOoo00;
    }
}
