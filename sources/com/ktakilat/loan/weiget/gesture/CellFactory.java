package com.ktakilat.loan.weiget.gesture;

import java.util.ArrayList;

public class CellFactory {
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Object, com.ktakilat.loan.weiget.gesture.CellBean] */
    public static ArrayList a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        float f = ((float) i) / 8.0f;
        float f2 = ((float) i2) / 8.0f;
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = i3 % 3;
            int i5 = i3 / 3;
            ? obj = new Object();
            obj.f606a = i3;
            obj.b = i4;
            obj.c = i5;
            obj.d = ((float) ((i4 * 3) + 1)) * f;
            obj.e = ((float) ((i5 * 3) + 1)) * f2;
            obj.f = f;
            arrayList.add(obj);
        }
        return arrayList;
    }
}
