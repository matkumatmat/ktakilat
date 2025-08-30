package com.ktakilat.loan.verify_face;

public enum VerifyType {
    OTP(1),
    FACE(2);
    
    public int type;

    /* access modifiers changed from: public */
    VerifyType(int i) {
        this.type = i;
    }
}
