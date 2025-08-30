package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;

public final class ReedSolomonEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final GenericGF f414a;
    public final ArrayList b;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.f414a = genericGF;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    public final void a(int i, int[] iArr) {
        GenericGFPoly genericGFPoly;
        int i2;
        GenericGFPoly genericGFPoly2;
        int i3 = i;
        int[] iArr2 = iArr;
        int i4 = 1;
        if (i3 != 0) {
            int length = iArr2.length - i3;
            if (length > 0) {
                ArrayList arrayList = this.b;
                int size = arrayList.size();
                GenericGF genericGF = this.f414a;
                if (i3 >= size) {
                    GenericGFPoly genericGFPoly3 = (GenericGFPoly) arrayList.get(arrayList.size() - 1);
                    int size2 = arrayList.size();
                    while (size2 <= i3) {
                        GenericGFPoly genericGFPoly4 = new GenericGFPoly(genericGF, new int[]{i4, genericGF.f412a[(size2 - 1) + genericGF.f]});
                        genericGFPoly3.getClass();
                        GenericGF genericGF2 = genericGFPoly3.f413a;
                        if (genericGF2.equals(genericGF)) {
                            if (genericGFPoly3.c() || genericGFPoly4.c()) {
                                i2 = 1;
                                genericGFPoly2 = genericGF2.c;
                            } else {
                                int[] iArr3 = genericGFPoly3.b;
                                int length2 = iArr3.length;
                                int[] iArr4 = genericGFPoly4.b;
                                int length3 = iArr4.length;
                                int[] iArr5 = new int[((length2 + length3) - i4)];
                                int i5 = 0;
                                while (i5 < length2) {
                                    int i6 = iArr3[i5];
                                    int i7 = 0;
                                    while (i7 < length3) {
                                        int i8 = i5 + i7;
                                        iArr5[i8] = iArr5[i8] ^ genericGF2.a(i6, iArr4[i7]);
                                        i7++;
                                        iArr3 = iArr3;
                                    }
                                    i5++;
                                    iArr3 = iArr3;
                                }
                                i2 = 1;
                                genericGFPoly2 = new GenericGFPoly(genericGF2, iArr5);
                            }
                            arrayList.add(genericGFPoly2);
                            size2 += i2;
                            genericGFPoly3 = genericGFPoly2;
                            i4 = 1;
                        } else {
                            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                        }
                    }
                }
                GenericGFPoly genericGFPoly5 = (GenericGFPoly) arrayList.get(i3);
                int[] iArr6 = new int[length];
                System.arraycopy(iArr2, 0, iArr6, 0, length);
                GenericGFPoly d = new GenericGFPoly(genericGF, iArr6).d(i3, 1);
                d.getClass();
                GenericGF genericGF3 = genericGFPoly5.f413a;
                GenericGF genericGF4 = d.f413a;
                if (!genericGF4.equals(genericGF3)) {
                    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                } else if (!genericGFPoly5.c()) {
                    int b2 = genericGFPoly5.b();
                    int[] iArr7 = genericGFPoly5.b;
                    int i9 = iArr7[(iArr7.length - 1) - b2];
                    if (i9 != 0) {
                        int i10 = genericGF4.b[i9];
                        int i11 = genericGF4.f412a[(genericGF4.d - i10) - 1];
                        GenericGFPoly genericGFPoly6 = genericGF4.c;
                        GenericGFPoly genericGFPoly7 = genericGFPoly6;
                        while (d.b() >= genericGFPoly5.b() && !d.c()) {
                            int b3 = d.b() - genericGFPoly5.b();
                            int b4 = d.b();
                            int[] iArr8 = d.b;
                            int a2 = genericGF4.a(iArr8[(iArr8.length - 1) - b4], i11);
                            GenericGFPoly d2 = genericGFPoly5.d(b3, a2);
                            if (b3 >= 0) {
                                if (a2 == 0) {
                                    genericGFPoly = genericGFPoly6;
                                } else {
                                    int[] iArr9 = new int[(b3 + 1)];
                                    iArr9[0] = a2;
                                    genericGFPoly = new GenericGFPoly(genericGF4, iArr9);
                                }
                                genericGFPoly7 = genericGFPoly7.a(genericGFPoly);
                                d = d.a(d2);
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                        int[] iArr10 = new GenericGFPoly[]{genericGFPoly7, d}[1].b;
                        int length4 = i3 - iArr10.length;
                        for (int i12 = 0; i12 < length4; i12++) {
                            iArr2[length + i12] = 0;
                        }
                        System.arraycopy(iArr10, 0, iArr2, length + length4, iArr10.length);
                        return;
                    }
                    throw new ArithmeticException();
                } else {
                    throw new IllegalArgumentException("Divide by 0");
                }
            } else {
                throw new IllegalArgumentException("No data bytes provided");
            }
        } else {
            throw new IllegalArgumentException("No error correction bytes");
        }
    }
}
