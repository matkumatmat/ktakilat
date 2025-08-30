package com.google.zxing.pdf417.decoder.ec;

final class ModulusPoly {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f438a;

    public ModulusPoly(int[] iArr) {
        if (iArr.length != 0) {
            int length = iArr.length;
            int i = 1;
            if (length <= 1 || iArr[0] != 0) {
                this.f438a = iArr;
                return;
            }
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.f438a = new int[]{0};
                return;
            }
            int i2 = length - i;
            int[] iArr2 = new int[i2];
            this.f438a = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, i2);
            return;
        }
        throw new IllegalArgumentException();
    }

    public final String toString() {
        int[] iArr = this.f438a;
        StringBuilder sb = new StringBuilder((iArr.length - 1) * 8);
        for (int length = iArr.length - 1; length >= 0; length--) {
            int i = iArr[(iArr.length - 1) - length];
            if (i != 0) {
                if (i < 0) {
                    sb.append(" - ");
                    i = -i;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (length == 0 || i != 1) {
                    sb.append(i);
                }
                if (length != 0) {
                    if (length == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(length);
                    }
                }
            }
        }
        return sb.toString();
    }
}
