package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;

public class SymbolInfo {
    public static final SymbolInfo[] i = {new SymbolInfo(false, 3, 5, 8, 8, 1, 3, 5), new SymbolInfo(false, 5, 7, 10, 10, 1, 5, 7), new SymbolInfo(true, 5, 7, 16, 6, 1, 5, 7), new SymbolInfo(false, 8, 10, 12, 12, 1, 8, 10), new SymbolInfo(true, 10, 11, 14, 6, 2, 10, 11), new SymbolInfo(false, 12, 12, 14, 14, 1, 12, 12), new SymbolInfo(true, 16, 14, 24, 10, 1, 16, 14), new SymbolInfo(false, 18, 14, 16, 16, 1, 18, 14), new SymbolInfo(false, 22, 18, 18, 18, 1, 22, 18), new SymbolInfo(true, 22, 18, 16, 10, 2, 22, 18), new SymbolInfo(false, 30, 20, 20, 20, 1, 30, 20), new SymbolInfo(true, 32, 24, 16, 14, 2, 32, 24), new SymbolInfo(false, 36, 24, 22, 22, 1, 36, 24), new SymbolInfo(false, 44, 28, 24, 24, 1, 44, 28), new SymbolInfo(true, 49, 28, 22, 14, 2, 49, 28), new SymbolInfo(false, 62, 36, 14, 14, 4, 62, 36), new SymbolInfo(false, 86, 42, 16, 16, 4, 86, 42), new SymbolInfo(false, 114, 48, 18, 18, 4, 114, 48), new SymbolInfo(false, 144, 56, 20, 20, 4, 144, 56), new SymbolInfo(false, 174, 68, 22, 22, 4, 174, 68), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new SymbolInfo(false, 1558, 620, 22, 22, 36, -1, 62)};

    /* renamed from: a  reason: collision with root package name */
    public final boolean f422a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public SymbolInfo(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f422a = z;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }

    public static SymbolInfo f(int i2, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        SymbolInfo[] symbolInfoArr = i;
        for (int i3 = 0; i3 < 30; i3++) {
            SymbolInfo symbolInfo = symbolInfoArr[i3];
            if ((symbolShapeHint != SymbolShapeHint.FORCE_SQUARE || !symbolInfo.f422a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.f422a) && ((dimension == null || (symbolInfo.d() >= 0 && (symbolInfo.e() * symbolInfo.e) + (symbolInfo.e() << 1) >= 0)) && ((dimension2 == null || (symbolInfo.d() <= 0 && (symbolInfo.e() * symbolInfo.e) + (symbolInfo.e() << 1) <= 0)) && i2 <= symbolInfo.b)))) {
                return symbolInfo;
            }
        }
        throw new IllegalArgumentException(ba.k(i2, "Can't find a symbol arrangement that matches the message. Data codewords: "));
    }

    public int a(int i2) {
        return this.g;
    }

    public final int b() {
        int i2 = 1;
        int i3 = this.f;
        if (i3 != 1) {
            i2 = 2;
            if (!(i3 == 2 || i3 == 4)) {
                if (i3 == 16) {
                    return 4;
                }
                if (i3 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    public int c() {
        return this.b / this.g;
    }

    public final int d() {
        return (b() * this.d) + (b() << 1);
    }

    public final int e() {
        int i2 = this.f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f422a) {
            str = "Rectangular Symbol:";
        } else {
            str = "Square Symbol:";
        }
        sb.append(str);
        sb.append(" data region ");
        int i2 = this.d;
        sb.append(i2);
        sb.append('x');
        int i3 = this.e;
        sb.append(i3);
        sb.append(", symbol size ");
        sb.append(d());
        sb.append('x');
        sb.append((e() * i3) + (e() << 1));
        sb.append(", symbol data size ");
        sb.append(b() * i2);
        sb.append('x');
        sb.append(e() * i3);
        sb.append(", codewords ");
        sb.append(this.b);
        sb.append('+');
        sb.append(this.c);
        return sb.toString();
    }
}
