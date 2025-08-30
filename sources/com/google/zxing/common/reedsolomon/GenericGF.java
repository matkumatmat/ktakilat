package com.google.zxing.common.reedsolomon;

public final class GenericGF {
    public static final GenericGF g = new GenericGF(4201, 4096, 1);
    public static final GenericGF h = new GenericGF(1033, 1024, 1);
    public static final GenericGF i = new GenericGF(67, 64, 1);
    public static final GenericGF j = new GenericGF(19, 16, 1);
    public static final GenericGF k = new GenericGF(285, 256, 0);
    public static final GenericGF l = new GenericGF(301, 256, 1);

    /* renamed from: a  reason: collision with root package name */
    public final int[] f412a;
    public final int[] b;
    public final GenericGFPoly c;
    public final int d;
    public final int e;
    public final int f;

    public GenericGF(int i2, int i3, int i4) {
        this.e = i2;
        this.d = i3;
        this.f = i4;
        this.f412a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f412a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.f412a[i7]] = i7;
        }
        this.c = new GenericGFPoly(this, new int[]{0});
        new GenericGFPoly(this, new int[]{1});
    }

    public final int a(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.b;
        return this.f412a[(iArr[i2] + iArr[i3]) % (this.d - 1)];
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.e) + ',' + this.d + ')';
    }
}
