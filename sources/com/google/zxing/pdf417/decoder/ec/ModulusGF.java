package com.google.zxing.pdf417.decoder.ec;

public final class ModulusGF {
    public static final /* synthetic */ int c = 0;

    /* renamed from: a  reason: collision with root package name */
    public final int[] f437a = new int[929];
    public final int[] b = new int[929];

    static {
        new ModulusGF();
    }

    public ModulusGF() {
        int i = 1;
        for (int i2 = 0; i2 < 929; i2++) {
            this.f437a[i2] = i;
            i = (i * 3) % 929;
        }
        for (int i3 = 0; i3 < 928; i3++) {
            this.b[this.f437a[i3]] = i3;
        }
        new ModulusPoly(new int[]{0});
        new ModulusPoly(new int[]{1});
    }
}
