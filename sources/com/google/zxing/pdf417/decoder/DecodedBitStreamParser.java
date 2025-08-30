package com.google.zxing.pdf417.decoder;

import java.math.BigInteger;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

final class DecodedBitStreamParser {

    /* renamed from: a  reason: collision with root package name */
    public static final BigInteger[] f434a;

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f435a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0021 */
        static {
            /*
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode[] r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f435a = r0
                r1 = 1
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000d }
            L_0x000d:
                r0 = 2
                int[] r2 = f435a     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r1 = 3
                int[] r2 = f435a     // Catch:{ NoSuchFieldError -> 0x0017 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                r0 = 4
                int[] r2 = f435a     // Catch:{ NoSuchFieldError -> 0x001c }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 5
                int[] r2 = f435a     // Catch:{ NoSuchFieldError -> 0x0021 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r0 = f435a     // Catch:{ NoSuchFieldError -> 0x0026 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Mode {
    }

    static {
        ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
        "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
        Charset.forName(CharEncoding.ISO_8859_1);
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f434a = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        bigIntegerArr[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f434a;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }
}
