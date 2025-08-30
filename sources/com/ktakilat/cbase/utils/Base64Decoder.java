package com.ktakilat.cbase.utils;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class Base64Decoder extends FilterInputStream {
    public static final char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static final int[] f = new int[128];
    public int c;
    public int d;

    static {
        for (int i = 0; i < 64; i++) {
            f[e[i]] = i;
        }
    }

    public static String c() {
        if (TextUtils.isEmpty("QUl6YVN5Q1JDRXpYSWx4cGM5UHVuc25jd1lQbzVTMEJMYndrMWFR")) {
            return "";
        }
        byte[] bytes = "QUl6YVN5Q1JDRXpYSWx4cGM5UHVuc25jd1lQbzVTMEJMYndrMWFR".getBytes();
        FilterInputStream filterInputStream = new FilterInputStream(new ByteArrayInputStream(bytes));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (((double) bytes.length) * 0.75d));
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = filterInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        filterInputStream.close();
                        try {
                            byteArrayOutputStream.close();
                            return new String(byteArray);
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    } catch (IOException e3) {
                        throw new RuntimeException(e3);
                    }
                }
            }
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        } catch (Throwable th) {
            try {
                filterInputStream.close();
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            } catch (IOException e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    public final int read() {
        int read;
        do {
            read = this.in.read();
            if (read == -1) {
                return -1;
            }
        } while (Character.isWhitespace((char) read));
        int i = this.c;
        this.c = i + 1;
        if (read == 61) {
            return -1;
        }
        int i2 = f[read];
        int i3 = i % 4;
        if (i3 == 0) {
            this.d = i2 & 63;
            return read();
        } else if (i3 == 1) {
            int i4 = ((this.d << 2) + (i2 >> 4)) & 255;
            this.d = i2 & 15;
            return i4;
        } else if (i3 == 2) {
            int i5 = ((this.d << 4) + (i2 >> 2)) & 255;
            this.d = i2 & 3;
            return i5;
        } else if (i3 == 3) {
            return ((this.d << 6) + i2) & 255;
        } else {
            return -1;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (bArr.length >= (i2 + i) - 1) {
            int i3 = 0;
            while (i3 < i2) {
                int read = read();
                if (read == -1 && i3 == 0) {
                    return -1;
                }
                if (read == -1) {
                    break;
                }
                bArr[i + i3] = (byte) read;
                i3++;
            }
            return i3;
        }
        throw new IOException(ba.q(e.r(i2, "The input buffer is too small: ", i, " bytes requested starting at offset ", " while the buffer  is only "), " bytes long.", bArr.length));
    }
}
