package com.google.zxing.datamatrix.encoder;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.Dimension;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

final class EncoderContext {

    /* renamed from: a  reason: collision with root package name */
    public final String f420a;
    public SymbolShapeHint b;
    public Dimension c;
    public Dimension d;
    public final StringBuilder e;
    public int f;
    public int g;
    public SymbolInfo h;
    public int i;

    public EncoderContext(String str) {
        byte[] bytes = str.getBytes(Charset.forName(CharEncoding.ISO_8859_1));
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i2 = 0;
        while (i2 < length) {
            char c2 = (char) (bytes[i2] & UnsignedBytes.MAX_VALUE);
            if (c2 != '?' || str.charAt(i2) == '?') {
                sb.append(c2);
                i2++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f420a = sb.toString();
        this.b = SymbolShapeHint.FORCE_NONE;
        this.e = new StringBuilder(str.length());
        this.g = -1;
    }

    public final char a() {
        return this.f420a.charAt(this.f);
    }

    public final boolean b() {
        if (this.f < this.f420a.length() - this.i) {
            return true;
        }
        return false;
    }

    public final void c(int i2) {
        SymbolInfo symbolInfo = this.h;
        if (symbolInfo == null || i2 > symbolInfo.b) {
            this.h = SymbolInfo.f(i2, this.b, this.c, this.d);
        }
    }

    public final void d(char c2) {
        this.e.append(c2);
    }
}
