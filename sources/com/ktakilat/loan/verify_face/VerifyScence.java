package com.ktakilat.loan.verify_face;

public enum VerifyScence {
    FORGOT_PWD(1),
    CHANGE_PWD(2),
    FORGOT_GESTURE(3),
    CHANGE_GESTURE(4),
    SAFE_DEVICE(5),
    SAFE_PHONE(5),
    SAFE_LOAN(6);
    
    public int scence;

    /* access modifiers changed from: public */
    VerifyScence(int i) {
        this.scence = i;
    }
}
