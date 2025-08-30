package com.ktakilat.cbase.utils;

import java.io.FilterOutputStream;

public class Base64Encoder extends FilterOutputStream {
    public static final char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public int c;
    public int d;

    public final void close() {
        int i = this.c;
        int i2 = i % 3;
        char[] cArr = e;
        if (i2 == 1) {
            this.out.write(cArr[(this.d << 4) & 63]);
            this.out.write(61);
            this.out.write(61);
        } else if (i % 3 == 2) {
            this.out.write(cArr[(this.d << 2) & 63]);
            this.out.write(61);
        }
        super.close();
    }

    public final void write(int i) {
        if (i < 0) {
            i += 256;
        }
        int i2 = this.c;
        int i3 = i2 % 3;
        char[] cArr = e;
        if (i3 == 0) {
            this.d = i & 3;
            this.out.write(cArr[i >> 2]);
        } else if (i2 % 3 == 1) {
            this.d = i & 15;
            this.out.write(cArr[((this.d << 4) + (i >> 4)) & 63]);
        } else if (i2 % 3 == 2) {
            this.out.write(cArr[((this.d << 2) + (i >> 6)) & 63]);
            this.out.write(cArr[i & 63]);
            this.d = 0;
        }
        this.c++;
    }

    public final void write(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }
}
