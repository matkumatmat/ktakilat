package com.ktakilat.loan.weiget;

public enum TongDunEnum {
    USER_LOGIN_SUC("LOGIN"),
    USER_REGISTER_SUC("SIGNUP"),
    APPLY_LOAN("LOAN");
    
    public String type;

    /* access modifiers changed from: public */
    TongDunEnum(String str) {
        this.type = str;
    }
}
