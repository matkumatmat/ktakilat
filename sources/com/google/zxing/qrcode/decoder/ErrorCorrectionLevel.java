package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    public static final ErrorCorrectionLevel[] d = null;
    public final int c;

    static {
        ErrorCorrectionLevel errorCorrectionLevel;
        ErrorCorrectionLevel errorCorrectionLevel2;
        ErrorCorrectionLevel errorCorrectionLevel3;
        ErrorCorrectionLevel errorCorrectionLevel4;
        d = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4, errorCorrectionLevel3};
    }

    /* access modifiers changed from: public */
    ErrorCorrectionLevel(int i) {
        this.c = i;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        if (i >= 0 && i < 4) {
            return d[i];
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.c;
    }
}
