package com.google.zxing.common.reedsolomon;

final class GenericGFPoly {

    /* renamed from: a  reason: collision with root package name */
    public final GenericGF f413a;
    public final int[] b;

    public GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length != 0) {
            this.f413a = genericGF;
            int length = iArr.length;
            int i = 1;
            if (length <= 1 || iArr[0] != 0) {
                this.b = iArr;
                return;
            }
            while (i < length && iArr[i] == 0) {
                i++;
            }
            if (i == length) {
                this.b = new int[]{0};
                return;
            }
            int i2 = length - i;
            int[] iArr2 = new int[i2];
            this.b = iArr2;
            System.arraycopy(iArr, i, iArr2, 0, i2);
            return;
        }
        throw new IllegalArgumentException();
    }

    public final GenericGFPoly a(GenericGFPoly genericGFPoly) {
        GenericGF genericGF = genericGFPoly.f413a;
        GenericGF genericGF2 = this.f413a;
        if (!genericGF2.equals(genericGF)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (c()) {
            return genericGFPoly;
        } else {
            if (genericGFPoly.c()) {
                return this;
            }
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = genericGFPoly.b;
            if (length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length2 = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length2);
            for (int i = length2; i < iArr.length; i++) {
                iArr4[i] = iArr2[i - length2] ^ iArr[i];
            }
            return new GenericGFPoly(genericGF2, iArr4);
        }
    }

    public final int b() {
        return this.b.length - 1;
    }

    public final boolean c() {
        if (this.b[0] == 0) {
            return true;
        }
        return false;
    }

    public final GenericGFPoly d(int i, int i2) {
        if (i >= 0) {
            GenericGF genericGF = this.f413a;
            if (i2 == 0) {
                return genericGF.c;
            }
            int[] iArr = this.b;
            int length = iArr.length;
            int[] iArr2 = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr2[i3] = genericGF.a(iArr[i3], i2);
            }
            return new GenericGFPoly(genericGF, iArr2);
        }
        throw new IllegalArgumentException();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b2 = b(); b2 >= 0; b2--) {
            int[] iArr = this.b;
            int i = iArr[(iArr.length - 1) - b2];
            if (i != 0) {
                if (i < 0) {
                    sb.append(" - ");
                    i = -i;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b2 == 0 || i != 1) {
                    GenericGF genericGF = this.f413a;
                    if (i != 0) {
                        int i2 = genericGF.b[i];
                        if (i2 == 0) {
                            sb.append('1');
                        } else if (i2 == 1) {
                            sb.append('a');
                        } else {
                            sb.append("a^");
                            sb.append(i2);
                        }
                    } else {
                        genericGF.getClass();
                        throw new IllegalArgumentException();
                    }
                }
                if (b2 != 0) {
                    if (b2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b2);
                    }
                }
            }
        }
        return sb.toString();
    }
}
