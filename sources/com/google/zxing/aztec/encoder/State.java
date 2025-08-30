package com.google.zxing.aztec.encoder;

final class State {
    public static final State e = new State(Token.b, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f410a;
    public final Token b;
    public final int c;
    public final int d;

    public State(Token token, int i, int i2, int i3) {
        this.b = token;
        this.f410a = i;
        this.c = i2;
        this.d = i3;
    }

    public final State a(int i) {
        int i2;
        Token token = this.b;
        int i3 = this.f410a;
        int i4 = this.d;
        if (i3 == 4 || i3 == 2) {
            int[] iArr = HighLevelEncoder.c[i3];
            i3 = 0;
            int i5 = iArr[0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            token.getClass();
            i4 += i7;
            token = new SimpleToken(token, i6, i7);
        }
        int i8 = this.c;
        if (i8 == 0 || i8 == 31) {
            i2 = 18;
        } else if (i8 == 62) {
            i2 = 9;
        } else {
            i2 = 8;
        }
        int i9 = i8 + 1;
        State state = new State(token, i3, i9, i4 + i2);
        if (i9 == 2078) {
            return state.b(i + 1);
        }
        return state;
    }

    public final State b(int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return this;
        }
        Token token = this.b;
        token.getClass();
        return new State(new BinaryShiftToken(token, i - i2, i2), this.f410a, 0, this.d);
    }

    public final boolean c(State state) {
        int i;
        int i2 = this.d + (HighLevelEncoder.c[this.f410a][state.f410a] >> 16);
        int i3 = state.c;
        if (i3 > 0 && ((i = this.c) == 0 || i > i3)) {
            i2 += 10;
        }
        if (i2 <= state.d) {
            return true;
        }
        return false;
    }

    public final State d(int i, int i2) {
        int i3;
        int i4 = this.d;
        Token token = this.b;
        int i5 = this.f410a;
        if (i != i5) {
            int i6 = HighLevelEncoder.c[i5][i];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            token.getClass();
            i4 += i8;
            token = new SimpleToken(token, i7, i8);
        }
        if (i == 2) {
            i3 = 4;
        } else {
            i3 = 5;
        }
        token.getClass();
        return new State(new SimpleToken(token, i2, i3), i, 0, i4 + i3);
    }

    public final State e(int i, int i2) {
        int i3;
        int i4 = this.f410a;
        if (i4 == 2) {
            i3 = 4;
        } else {
            i3 = 5;
        }
        int i5 = HighLevelEncoder.e[i4][i];
        Token token = this.b;
        token.getClass();
        return new State(new SimpleToken(new SimpleToken(token, i5, i3), i2, 5), i4, 0, this.d + i3 + 5);
    }

    public final String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{HighLevelEncoder.b[this.f410a], Integer.valueOf(this.d), Integer.valueOf(this.c)});
    }
}
