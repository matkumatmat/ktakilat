package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

abstract class Token {
    public static final SimpleToken b = new SimpleToken((Token) null, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final Token f411a;

    public Token(Token token) {
        this.f411a = token;
    }

    public abstract void a(BitArray bitArray, byte[] bArr);
}
