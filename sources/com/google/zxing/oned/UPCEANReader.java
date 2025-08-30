package com.google.zxing.oned;

public abstract class UPCEANReader extends OneDReader {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f431a = {1, 1, 1};
    public static final int[] b = {1, 1, 1, 1, 1};
    public static final int[] c = {1, 1, 1, 1, 1, 1};
    public static final int[][] d;
    public static final int[][] e;

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        d = iArr;
        int[][] iArr2 = new int[20][];
        e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = d[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            e[i] = iArr4;
        }
    }
}
