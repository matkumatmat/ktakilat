package com.google.zxing.qrcode.encoder;

public final class Encoder {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f449a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f450a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.zxing.qrcode.decoder.Mode[] r0 = com.google.zxing.qrcode.decoder.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f450a = r0
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f450a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f450a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.BYTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f450a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.KANJI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: type inference failed for: r0v16, types: [com.google.zxing.qrcode.encoder.QRCode, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x058a, code lost:
        if (r1 != false) goto L_0x058c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x010a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00fb A[LOOP:2: B:60:0x00d0->B:73:0x00fb, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.qrcode.encoder.QRCode a(java.lang.String r23, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r24, java.util.EnumMap r25) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            com.google.zxing.EncodeHintType r3 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r4 = r2.containsKey(r3)
            java.lang.String r5 = "ISO-8859-1"
            if (r4 == 0) goto L_0x0019
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = r3.toString()
            goto L_0x001a
        L_0x0019:
            r3 = r5
        L_0x001a:
            java.lang.String r4 = "Shift_JIS"
            boolean r6 = r4.equals(r3)
            int[] r7 = f449a
            r8 = 96
            r9 = -1
            r11 = 1
            r12 = 48
            if (r6 == 0) goto L_0x0053
            byte[] r6 = r0.getBytes(r4)     // Catch:{ UnsupportedEncodingException -> 0x0052 }
            int r13 = r6.length
            int r14 = r13 % 2
            if (r14 == 0) goto L_0x0034
            goto L_0x0053
        L_0x0034:
            r14 = 0
        L_0x0035:
            if (r14 >= r13) goto L_0x004f
            byte r15 = r6[r14]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r10 = 129(0x81, float:1.81E-43)
            if (r15 < r10) goto L_0x0043
            r10 = 159(0x9f, float:2.23E-43)
            if (r15 <= r10) goto L_0x004c
        L_0x0043:
            r10 = 224(0xe0, float:3.14E-43)
            if (r15 < r10) goto L_0x0053
            r10 = 235(0xeb, float:3.3E-43)
            if (r15 <= r10) goto L_0x004c
            goto L_0x0053
        L_0x004c:
            int r14 = r14 + 2
            goto L_0x0035
        L_0x004f:
            com.google.zxing.qrcode.decoder.Mode r6 = com.google.zxing.qrcode.decoder.Mode.KANJI
            goto L_0x0083
        L_0x0052:
        L_0x0053:
            r6 = 0
            r10 = 0
            r13 = 0
        L_0x0056:
            int r14 = r23.length()
            if (r6 >= r14) goto L_0x0077
            char r14 = r0.charAt(r6)
            if (r14 < r12) goto L_0x0068
            r15 = 57
            if (r14 > r15) goto L_0x0068
            r13 = 1
            goto L_0x0071
        L_0x0068:
            if (r14 >= r8) goto L_0x006d
            r10 = r7[r14]
            goto L_0x006e
        L_0x006d:
            r10 = -1
        L_0x006e:
            if (r10 == r9) goto L_0x0074
            r10 = 1
        L_0x0071:
            int r6 = r6 + 1
            goto L_0x0056
        L_0x0074:
            com.google.zxing.qrcode.decoder.Mode r6 = com.google.zxing.qrcode.decoder.Mode.BYTE
            goto L_0x0083
        L_0x0077:
            if (r10 == 0) goto L_0x007c
            com.google.zxing.qrcode.decoder.Mode r6 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC
            goto L_0x0083
        L_0x007c:
            if (r13 == 0) goto L_0x0081
            com.google.zxing.qrcode.decoder.Mode r6 = com.google.zxing.qrcode.decoder.Mode.NUMERIC
            goto L_0x0083
        L_0x0081:
            com.google.zxing.qrcode.decoder.Mode r6 = com.google.zxing.qrcode.decoder.Mode.BYTE
        L_0x0083:
            com.google.zxing.common.BitArray r10 = new com.google.zxing.common.BitArray
            r10.<init>()
            com.google.zxing.qrcode.decoder.Mode r13 = com.google.zxing.qrcode.decoder.Mode.BYTE
            r14 = 4
            r15 = 8
            if (r6 != r13) goto L_0x00ab
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x00ab
            com.google.zxing.common.CharacterSetECI r5 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r3)
            if (r5 == 0) goto L_0x00ab
            com.google.zxing.qrcode.decoder.Mode r13 = com.google.zxing.qrcode.decoder.Mode.ECI
            int r13 = r13.getBits()
            r10.b(r13, r14)
            int r5 = r5.getValue()
            r10.b(r5, r15)
        L_0x00ab:
            int r5 = r6.getBits()
            r10.b(r5, r14)
            com.google.zxing.common.BitArray r5 = new com.google.zxing.common.BitArray
            r5.<init>()
            int[] r13 = com.google.zxing.qrcode.encoder.Encoder.AnonymousClass1.f450a
            int r16 = r6.ordinal()
            r13 = r13[r16]
            r12 = 7
            if (r13 == r11) goto L_0x0186
            r11 = 2
            if (r13 == r11) goto L_0x0146
            r7 = 3
            if (r13 == r7) goto L_0x012e
            if (r13 != r14) goto L_0x011a
            byte[] r3 = r0.getBytes(r4)     // Catch:{ UnsupportedEncodingException -> 0x0112 }
            int r4 = r3.length
            r7 = 0
        L_0x00d0:
            if (r7 >= r4) goto L_0x01cb
            byte r8 = r3[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r11 = r7 + 1
            byte r11 = r3[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r15
            r8 = r8 | r11
            r11 = 33088(0x8140, float:4.6366E-41)
            if (r8 < r11) goto L_0x00ea
            r13 = 40956(0x9ffc, float:5.7392E-41)
            if (r8 > r13) goto L_0x00ea
        L_0x00e8:
            int r8 = r8 - r11
            goto L_0x00f9
        L_0x00ea:
            r11 = 57408(0xe040, float:8.0446E-41)
            if (r8 < r11) goto L_0x00f8
            r11 = 60351(0xebbf, float:8.457E-41)
            if (r8 > r11) goto L_0x00f8
            r11 = 49472(0xc140, float:6.9325E-41)
            goto L_0x00e8
        L_0x00f8:
            r8 = -1
        L_0x00f9:
            if (r8 == r9) goto L_0x010a
            int r11 = r8 >> 8
            int r11 = r11 * 192
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r11 = r11 + r8
            r8 = 13
            r5.b(r11, r8)
            int r7 = r7 + 2
            goto L_0x00d0
        L_0x010a:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Invalid byte sequence"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0112:
            r0 = move-exception
            r1 = r0
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>((java.lang.Throwable) r1)
            throw r0
        L_0x011a:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid mode: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x012e:
            byte[] r3 = r0.getBytes(r3)     // Catch:{ UnsupportedEncodingException -> 0x013e }
            int r4 = r3.length
            r7 = 0
        L_0x0134:
            if (r7 >= r4) goto L_0x01cb
            byte r8 = r3[r7]
            r5.b(r8, r15)
            int r7 = r7 + 1
            goto L_0x0134
        L_0x013e:
            r0 = move-exception
            r1 = r0
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>((java.lang.Throwable) r1)
            throw r0
        L_0x0146:
            int r3 = r23.length()
            r4 = 0
        L_0x014b:
            if (r4 >= r3) goto L_0x01cb
            char r11 = r0.charAt(r4)
            if (r11 >= r8) goto L_0x0156
            r11 = r7[r11]
            goto L_0x0157
        L_0x0156:
            r11 = -1
        L_0x0157:
            if (r11 == r9) goto L_0x0180
            int r13 = r4 + 1
            if (r13 >= r3) goto L_0x017a
            char r13 = r0.charAt(r13)
            if (r13 >= r8) goto L_0x0166
            r13 = r7[r13]
            goto L_0x0167
        L_0x0166:
            r13 = -1
        L_0x0167:
            if (r13 == r9) goto L_0x0174
            int r11 = r11 * 45
            int r11 = r11 + r13
            r13 = 11
            r5.b(r11, r13)
            int r4 = r4 + 2
            goto L_0x014b
        L_0x0174:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>()
            throw r0
        L_0x017a:
            r4 = 6
            r5.b(r11, r4)
            r4 = r13
            goto L_0x014b
        L_0x0180:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>()
            throw r0
        L_0x0186:
            int r3 = r23.length()
            r4 = 0
        L_0x018b:
            if (r4 >= r3) goto L_0x01cb
            char r7 = r0.charAt(r4)
            r8 = 48
            int r7 = r7 - r8
            int r11 = r4 + 2
            if (r11 >= r3) goto L_0x01b2
            int r13 = r4 + 1
            char r13 = r0.charAt(r13)
            int r13 = r13 - r8
            char r11 = r0.charAt(r11)
            int r11 = r11 - r8
            int r7 = r7 * 100
            r8 = 10
            int r13 = r13 * 10
            int r13 = r13 + r7
            int r13 = r13 + r11
            r5.b(r13, r8)
            int r4 = r4 + 3
            goto L_0x018b
        L_0x01b2:
            int r4 = r4 + 1
            if (r4 >= r3) goto L_0x01c5
            char r4 = r0.charAt(r4)
            r8 = 48
            int r4 = r4 - r8
            int r7 = r7 * 10
            int r7 = r7 + r4
            r5.b(r7, r12)
            r4 = r11
            goto L_0x018b
        L_0x01c5:
            r8 = 48
            r5.b(r7, r14)
            goto L_0x018b
        L_0x01cb:
            com.google.zxing.EncodeHintType r3 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r4 = r2.containsKey(r3)
            if (r4 == 0) goto L_0x0222
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = r2.toString()
            int r2 = java.lang.Integer.parseInt(r2)
            com.google.zxing.qrcode.decoder.Version r2 = com.google.zxing.qrcode.decoder.Version.a(r2)
            int r3 = r10.d
            int r4 = r6.getCharacterCountBits(r2)
            int r4 = r4 + r3
            int r3 = r5.d
            int r4 = r4 + r3
            int r3 = r2.c
            com.google.zxing.qrcode.decoder.Version$ECBlocks[] r7 = r2.b
            int r8 = r24.ordinal()
            r7 = r7[r8]
            com.google.zxing.qrcode.decoder.Version$ECB[] r8 = r7.b
            int r11 = r8.length
            r13 = 0
            r16 = 0
        L_0x01fd:
            if (r13 >= r11) goto L_0x0209
            r9 = r8[r13]
            int r9 = r9.f445a
            int r16 = r16 + r9
            int r13 = r13 + 1
            r9 = -1
            goto L_0x01fd
        L_0x0209:
            int r7 = r7.f446a
            int r16 = r16 * r7
            int r3 = r3 - r16
            int r4 = r4 + r12
            int r4 = r4 / r15
            if (r3 < r4) goto L_0x0215
            r3 = 1
            goto L_0x0216
        L_0x0215:
            r3 = 0
        L_0x0216:
            if (r3 == 0) goto L_0x021a
            goto L_0x02a4
        L_0x021a:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Data too big for requested version"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0222:
            r2 = 1
            com.google.zxing.qrcode.decoder.Version r3 = com.google.zxing.qrcode.decoder.Version.a(r2)
            int r2 = r10.d
            int r3 = r6.getCharacterCountBits(r3)
            int r3 = r3 + r2
            int r2 = r5.d
            int r3 = r3 + r2
            r2 = 1
        L_0x0232:
            java.lang.String r4 = "Data too big"
            r7 = 40
            if (r2 > r7) goto L_0x06fc
            com.google.zxing.qrcode.decoder.Version r8 = com.google.zxing.qrcode.decoder.Version.a(r2)
            int r9 = r8.c
            com.google.zxing.qrcode.decoder.Version$ECBlocks[] r11 = r8.b
            int r13 = r24.ordinal()
            r11 = r11[r13]
            com.google.zxing.qrcode.decoder.Version$ECB[] r13 = r11.b
            int r14 = r13.length
            r7 = 0
            r19 = 0
        L_0x024c:
            if (r7 >= r14) goto L_0x0259
            r15 = r13[r7]
            int r15 = r15.f445a
            int r19 = r19 + r15
            int r7 = r7 + 1
            r15 = 8
            goto L_0x024c
        L_0x0259:
            int r7 = r11.f446a
            int r19 = r19 * r7
            int r9 = r9 - r19
            int r7 = r3 + 7
            r11 = 8
            int r7 = r7 / r11
            if (r9 < r7) goto L_0x06ed
            int r2 = r10.d
            int r3 = r6.getCharacterCountBits(r8)
            int r3 = r3 + r2
            int r2 = r5.d
            int r3 = r3 + r2
            r2 = 1
        L_0x0271:
            r7 = 40
            if (r2 > r7) goto L_0x06e7
            com.google.zxing.qrcode.decoder.Version r8 = com.google.zxing.qrcode.decoder.Version.a(r2)
            int r9 = r8.c
            com.google.zxing.qrcode.decoder.Version$ECBlocks[] r11 = r8.b
            int r13 = r24.ordinal()
            r11 = r11[r13]
            com.google.zxing.qrcode.decoder.Version$ECB[] r13 = r11.b
            int r14 = r13.length
            r15 = 0
            r19 = 0
        L_0x0289:
            if (r15 >= r14) goto L_0x0296
            r7 = r13[r15]
            int r7 = r7.f445a
            int r19 = r19 + r7
            int r15 = r15 + 1
            r7 = 40
            goto L_0x0289
        L_0x0296:
            int r7 = r11.f446a
            int r19 = r19 * r7
            int r9 = r9 - r19
            int r7 = r3 + 7
            r11 = 8
            int r7 = r7 / r11
            if (r9 < r7) goto L_0x06db
            r2 = r8
        L_0x02a4:
            com.google.zxing.common.BitArray r3 = new com.google.zxing.common.BitArray
            r3.<init>()
            int r4 = r10.d
            r3.c(r4)
            r7 = 0
        L_0x02af:
            if (r7 >= r4) goto L_0x02bb
            boolean r8 = r10.d(r7)
            r3.a(r8)
            int r7 = r7 + 1
            goto L_0x02af
        L_0x02bb:
            com.google.zxing.qrcode.decoder.Mode r4 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r6 != r4) goto L_0x02c4
            int r0 = r5.e()
            goto L_0x02c8
        L_0x02c4:
            int r0 = r23.length()
        L_0x02c8:
            int r4 = r6.getCharacterCountBits(r2)
            r7 = 1
            int r8 = r7 << r4
            if (r0 >= r8) goto L_0x06bf
            r3.b(r0, r4)
            int r0 = r5.d
            int r4 = r3.d
            int r4 = r4 + r0
            r3.c(r4)
            r4 = 0
        L_0x02dd:
            if (r4 >= r0) goto L_0x02e9
            boolean r7 = r5.d(r4)
            r3.a(r7)
            int r4 = r4 + 1
            goto L_0x02dd
        L_0x02e9:
            com.google.zxing.qrcode.decoder.Version$ECBlocks[] r0 = r2.b
            int r4 = r24.ordinal()
            r0 = r0[r4]
            com.google.zxing.qrcode.decoder.Version$ECB[] r4 = r0.b
            int r5 = r4.length
            r7 = 0
            r8 = 0
        L_0x02f6:
            if (r7 >= r5) goto L_0x0300
            r9 = r4[r7]
            int r9 = r9.f445a
            int r8 = r8 + r9
            int r7 = r7 + 1
            goto L_0x02f6
        L_0x0300:
            int r4 = r0.f446a
            int r8 = r8 * r4
            int r4 = r2.c
            int r5 = r4 - r8
            int r7 = r5 << 3
            int r8 = r3.d
            if (r8 > r7) goto L_0x06a1
            r8 = 0
        L_0x030f:
            r9 = 4
            if (r8 >= r9) goto L_0x031d
            int r9 = r3.d
            if (r9 >= r7) goto L_0x031d
            r9 = 0
            r3.a(r9)
            int r8 = r8 + 1
            goto L_0x030f
        L_0x031d:
            int r8 = r3.d
            r8 = r8 & r12
            if (r8 <= 0) goto L_0x032d
        L_0x0322:
            r9 = 8
            if (r8 >= r9) goto L_0x032d
            r9 = 0
            r3.a(r9)
            int r8 = r8 + 1
            goto L_0x0322
        L_0x032d:
            int r8 = r3.e()
            int r8 = r5 - r8
            r9 = 0
        L_0x0334:
            if (r9 >= r8) goto L_0x0348
            r11 = r9 & 1
            if (r11 != 0) goto L_0x033f
            r10 = 236(0xec, float:3.31E-43)
        L_0x033c:
            r11 = 8
            goto L_0x0342
        L_0x033f:
            r10 = 17
            goto L_0x033c
        L_0x0342:
            r3.b(r10, r11)
            int r9 = r9 + 1
            goto L_0x0334
        L_0x0348:
            int r8 = r3.d
            if (r8 != r7) goto L_0x0699
            com.google.zxing.qrcode.decoder.Version$ECB[] r0 = r0.b
            int r7 = r0.length
            r8 = 0
            r9 = 0
        L_0x0351:
            if (r8 >= r7) goto L_0x035b
            r11 = r0[r8]
            int r11 = r11.f445a
            int r9 = r9 + r11
            int r8 = r8 + 1
            goto L_0x0351
        L_0x035b:
            int r0 = r3.e()
            if (r0 != r5) goto L_0x0691
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r9)
            r7 = 0
            r8 = 0
            r11 = 0
            r12 = 0
        L_0x036a:
            if (r7 >= r9) goto L_0x044a
            r13 = 1
            int[] r14 = new int[r13]
            int[] r15 = new int[r13]
            if (r7 >= r9) goto L_0x0442
            int r13 = r4 % r9
            int r10 = r9 - r13
            int r19 = r4 / r9
            int r20 = r19 + 1
            int r21 = r5 / r9
            int r22 = r21 + 1
            r25 = r2
            int r2 = r19 - r21
            r19 = r6
            int r6 = r20 - r22
            if (r2 != r6) goto L_0x043a
            int r1 = r10 + r13
            if (r9 != r1) goto L_0x0432
            int r1 = r21 + r2
            int r1 = r1 * r10
            int r20 = r22 + r6
            int r20 = r20 * r13
            int r1 = r20 + r1
            if (r4 != r1) goto L_0x042a
            if (r7 >= r10) goto L_0x03a1
            r1 = 0
            r14[r1] = r21
            r15[r1] = r2
            goto L_0x03a6
        L_0x03a1:
            r1 = 0
            r14[r1] = r22
            r15[r1] = r6
        L_0x03a6:
            r2 = r14[r1]
            byte[] r1 = new byte[r2]
            int r6 = r8 << 3
            r10 = 0
        L_0x03ad:
            if (r10 >= r2) goto L_0x03d8
            r21 = r4
            r20 = r9
            r4 = 8
            r9 = 0
            r13 = 0
        L_0x03b7:
            if (r13 >= r4) goto L_0x03ce
            boolean r4 = r3.d(r6)
            if (r4 == 0) goto L_0x03c7
            int r4 = 7 - r13
            r17 = 1
            int r4 = r17 << r4
            r4 = r4 | r9
            r9 = r4
        L_0x03c7:
            int r6 = r6 + 1
            int r13 = r13 + 1
            r4 = 8
            goto L_0x03b7
        L_0x03ce:
            byte r4 = (byte) r9
            r1[r10] = r4
            int r10 = r10 + 1
            r9 = r20
            r4 = r21
            goto L_0x03ad
        L_0x03d8:
            r21 = r4
            r20 = r9
            r4 = 0
            r6 = r15[r4]
            int r4 = r2 + r6
            int[] r4 = new int[r4]
            r9 = 0
        L_0x03e4:
            if (r9 >= r2) goto L_0x03ef
            byte r10 = r1[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r4[r9] = r10
            int r9 = r9 + 1
            goto L_0x03e4
        L_0x03ef:
            com.google.zxing.common.reedsolomon.ReedSolomonEncoder r9 = new com.google.zxing.common.reedsolomon.ReedSolomonEncoder
            com.google.zxing.common.reedsolomon.GenericGF r10 = com.google.zxing.common.reedsolomon.GenericGF.k
            r9.<init>(r10)
            r9.a(r6, r4)
            byte[] r9 = new byte[r6]
            r10 = 0
        L_0x03fc:
            if (r10 >= r6) goto L_0x0408
            int r13 = r2 + r10
            r13 = r4[r13]
            byte r13 = (byte) r13
            r9[r10] = r13
            int r10 = r10 + 1
            goto L_0x03fc
        L_0x0408:
            com.google.zxing.qrcode.encoder.BlockPair r4 = new com.google.zxing.qrcode.encoder.BlockPair
            r4.<init>(r1, r9)
            r0.add(r4)
            int r11 = java.lang.Math.max(r11, r2)
            int r12 = java.lang.Math.max(r12, r6)
            r1 = 0
            r2 = r14[r1]
            int r8 = r8 + r2
            int r7 = r7 + 1
            r1 = r24
            r2 = r25
            r6 = r19
            r9 = r20
            r4 = r21
            goto L_0x036a
        L_0x042a:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Total bytes mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0432:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "RS blocks mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x043a:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "EC bytes mismatch"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0442:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Block ID too large"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x044a:
            r25 = r2
            r21 = r4
            r19 = r6
            if (r5 != r8) goto L_0x0689
            com.google.zxing.common.BitArray r1 = new com.google.zxing.common.BitArray
            r1.<init>()
            r2 = 0
        L_0x0458:
            if (r2 >= r11) goto L_0x047a
            java.util.Iterator r3 = r0.iterator()
        L_0x045e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0477
            java.lang.Object r4 = r3.next()
            com.google.zxing.qrcode.encoder.BlockPair r4 = (com.google.zxing.qrcode.encoder.BlockPair) r4
            byte[] r4 = r4.f447a
            int r5 = r4.length
            if (r2 >= r5) goto L_0x045e
            byte r4 = r4[r2]
            r5 = 8
            r1.b(r4, r5)
            goto L_0x045e
        L_0x0477:
            int r2 = r2 + 1
            goto L_0x0458
        L_0x047a:
            r2 = 0
        L_0x047b:
            if (r2 >= r12) goto L_0x049d
            java.util.Iterator r3 = r0.iterator()
        L_0x0481:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x049a
            java.lang.Object r4 = r3.next()
            com.google.zxing.qrcode.encoder.BlockPair r4 = (com.google.zxing.qrcode.encoder.BlockPair) r4
            byte[] r4 = r4.b
            int r5 = r4.length
            if (r2 >= r5) goto L_0x0481
            byte r4 = r4[r2]
            r5 = 8
            r1.b(r4, r5)
            goto L_0x0481
        L_0x049a:
            int r2 = r2 + 1
            goto L_0x047b
        L_0x049d:
            int r0 = r1.e()
            r2 = r21
            if (r2 != r0) goto L_0x066b
            com.google.zxing.qrcode.encoder.QRCode r0 = new com.google.zxing.qrcode.encoder.QRCode
            r0.<init>()
            r6 = -1
            r0.d = r6
            r7 = r24
            r0.b = r7
            r8 = r19
            r0.f452a = r8
            r2 = r25
            r0.c = r2
            int r3 = r2.f444a
            r9 = 4
            int r3 = r3 * 4
            r4 = 17
            int r3 = r3 + r4
            com.google.zxing.qrcode.encoder.ByteMatrix r4 = new com.google.zxing.qrcode.encoder.ByteMatrix
            r4.<init>(r3, r3)
            r3 = 2147483647(0x7fffffff, float:NaN)
            r9 = 0
        L_0x04ca:
            r11 = 8
            if (r9 >= r11) goto L_0x065b
            com.google.zxing.qrcode.encoder.MatrixUtil.a(r1, r7, r2, r9, r4)
            r5 = 1
            int r8 = com.google.zxing.qrcode.encoder.MaskUtil.a(r4, r5)
            r5 = 0
            int r10 = com.google.zxing.qrcode.encoder.MaskUtil.a(r4, r5)
            int r8 = r8 + r10
            r5 = 0
            r10 = 0
        L_0x04de:
            int r12 = r4.c
            int r13 = r12 + -1
            int r14 = r4.b
            byte[][] r15 = r4.f448a
            if (r5 >= r13) goto L_0x050f
            r12 = 0
        L_0x04e9:
            int r13 = r14 + -1
            if (r12 >= r13) goto L_0x050a
            r13 = r15[r5]
            byte r11 = r13[r12]
            int r16 = r12 + 1
            byte r13 = r13[r16]
            if (r11 != r13) goto L_0x0505
            int r13 = r5 + 1
            r13 = r15[r13]
            byte r12 = r13[r12]
            if (r11 != r12) goto L_0x0505
            byte r12 = r13[r16]
            if (r11 != r12) goto L_0x0505
            int r10 = r10 + 1
        L_0x0505:
            r12 = r16
            r11 = 8
            goto L_0x04e9
        L_0x050a:
            int r5 = r5 + 1
            r11 = 8
            goto L_0x04de
        L_0x050f:
            int r10 = r10 * 3
            int r10 = r10 + r8
            r5 = 0
            r8 = 0
        L_0x0514:
            if (r5 >= r12) goto L_0x061d
            r11 = 0
        L_0x0517:
            if (r11 >= r14) goto L_0x0613
            r13 = r15[r5]
            r23 = r1
            int r1 = r11 + 6
            r25 = r2
            if (r1 >= r14) goto L_0x058f
            byte r2 = r13[r11]
            r16 = r4
            r4 = 1
            if (r2 != r4) goto L_0x0591
            int r2 = r11 + 1
            byte r2 = r13[r2]
            if (r2 != 0) goto L_0x0591
            int r2 = r11 + 2
            byte r2 = r13[r2]
            if (r2 != r4) goto L_0x0591
            int r2 = r11 + 3
            byte r2 = r13[r2]
            if (r2 != r4) goto L_0x0591
            int r2 = r11 + 4
            byte r2 = r13[r2]
            if (r2 != r4) goto L_0x0591
            int r2 = r11 + 5
            byte r2 = r13[r2]
            if (r2 != 0) goto L_0x0591
            byte r1 = r13[r1]
            if (r1 != r4) goto L_0x0591
            int r1 = r11 + -4
            r2 = 0
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r13.length
            int r2 = java.lang.Math.min(r11, r2)
        L_0x0558:
            if (r1 >= r2) goto L_0x0568
            r18 = r2
            byte r2 = r13[r1]
            if (r2 != r4) goto L_0x0562
            r1 = 0
            goto L_0x0569
        L_0x0562:
            int r1 = r1 + 1
            r2 = r18
            r4 = 1
            goto L_0x0558
        L_0x0568:
            r1 = 1
        L_0x0569:
            if (r1 != 0) goto L_0x058c
            int r1 = r11 + 7
            int r2 = r11 + 11
            r4 = 0
            int r1 = java.lang.Math.max(r1, r4)
            int r4 = r13.length
            int r2 = java.lang.Math.min(r2, r4)
        L_0x0579:
            if (r1 >= r2) goto L_0x0589
            byte r4 = r13[r1]
            r18 = r2
            r2 = 1
            if (r4 != r2) goto L_0x0584
            r1 = 0
            goto L_0x058a
        L_0x0584:
            int r1 = r1 + 1
            r2 = r18
            goto L_0x0579
        L_0x0589:
            r1 = 1
        L_0x058a:
            if (r1 == 0) goto L_0x0591
        L_0x058c:
            int r8 = r8 + 1
            goto L_0x0591
        L_0x058f:
            r16 = r4
        L_0x0591:
            int r1 = r5 + 6
            if (r1 >= r12) goto L_0x0609
            r2 = r15[r5]
            byte r2 = r2[r11]
            r4 = 1
            if (r2 != r4) goto L_0x0609
            int r2 = r5 + 1
            r2 = r15[r2]
            byte r2 = r2[r11]
            if (r2 != 0) goto L_0x0609
            int r2 = r5 + 2
            r2 = r15[r2]
            byte r2 = r2[r11]
            if (r2 != r4) goto L_0x0609
            int r2 = r5 + 3
            r2 = r15[r2]
            byte r2 = r2[r11]
            if (r2 != r4) goto L_0x0609
            int r2 = r5 + 4
            r2 = r15[r2]
            byte r2 = r2[r11]
            if (r2 != r4) goto L_0x0609
            int r2 = r5 + 5
            r2 = r15[r2]
            byte r2 = r2[r11]
            if (r2 != 0) goto L_0x0609
            r1 = r15[r1]
            byte r1 = r1[r11]
            if (r1 != r4) goto L_0x0609
            int r1 = r5 + -4
            r2 = 0
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r15.length
            int r2 = java.lang.Math.min(r5, r2)
        L_0x05d6:
            if (r1 >= r2) goto L_0x05e4
            r13 = r15[r1]
            byte r13 = r13[r11]
            if (r13 != r4) goto L_0x05e0
            r1 = 0
            goto L_0x05e5
        L_0x05e0:
            int r1 = r1 + 1
            r4 = 1
            goto L_0x05d6
        L_0x05e4:
            r1 = 1
        L_0x05e5:
            if (r1 != 0) goto L_0x0607
            int r1 = r5 + 7
            int r2 = r5 + 11
            r13 = 0
            int r1 = java.lang.Math.max(r1, r13)
            int r4 = r15.length
            int r2 = java.lang.Math.min(r2, r4)
        L_0x05f5:
            if (r1 >= r2) goto L_0x0604
            r4 = r15[r1]
            byte r4 = r4[r11]
            r13 = 1
            if (r4 != r13) goto L_0x0600
            r1 = 0
            goto L_0x0605
        L_0x0600:
            int r1 = r1 + 1
            r13 = 0
            goto L_0x05f5
        L_0x0604:
            r1 = 1
        L_0x0605:
            if (r1 == 0) goto L_0x0609
        L_0x0607:
            int r8 = r8 + 1
        L_0x0609:
            int r11 = r11 + 1
            r1 = r23
            r2 = r25
            r4 = r16
            goto L_0x0517
        L_0x0613:
            r23 = r1
            r25 = r2
            r16 = r4
            int r5 = r5 + 1
            goto L_0x0514
        L_0x061d:
            r23 = r1
            r25 = r2
            r16 = r4
            int r8 = r8 * 40
            int r8 = r8 + r10
            r1 = 0
            r2 = 0
        L_0x0628:
            if (r1 >= r12) goto L_0x063c
            r4 = r15[r1]
            r5 = 0
        L_0x062d:
            if (r5 >= r14) goto L_0x0639
            byte r10 = r4[r5]
            r11 = 1
            if (r10 != r11) goto L_0x0636
            int r2 = r2 + 1
        L_0x0636:
            int r5 = r5 + 1
            goto L_0x062d
        L_0x0639:
            int r1 = r1 + 1
            goto L_0x0628
        L_0x063c:
            int r12 = r12 * r14
            int r1 = r2 << 1
            int r1 = r1 - r12
            int r1 = java.lang.Math.abs(r1)
            r11 = 10
            int r1 = r1 * 10
            int r1 = r1 / r12
            int r1 = r1 * 10
            int r1 = r1 + r8
            if (r1 >= r3) goto L_0x0651
            r3 = r1
            r6 = r9
        L_0x0651:
            int r9 = r9 + 1
            r1 = r23
            r2 = r25
            r4 = r16
            goto L_0x04ca
        L_0x065b:
            r23 = r1
            r25 = r2
            r16 = r4
            r0.d = r6
            r3 = r16
            com.google.zxing.qrcode.encoder.MatrixUtil.a(r1, r7, r2, r6, r3)
            r0.e = r3
            return r0
        L_0x066b:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r3 = "Interleaving error: "
            java.lang.String r4 = " and "
            java.lang.StringBuilder r2 = defpackage.ba.t(r2, r3, r4)
            int r1 = r1.e()
            r2.append(r1)
            java.lang.String r1 = " differ."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0689:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Data bytes does not match offset"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0691:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Number of bits and data bytes does not match"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0699:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.String r1 = "Bits size does not equal capacity"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x06a1:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "data bits cannot fit in the QR Code"
            r1.<init>(r2)
            int r2 = r3.d
            r1.append(r2)
            java.lang.String r2 = " > "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x06bf:
            com.google.zxing.WriterException r1 = new com.google.zxing.WriterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " is bigger than "
            r2.append(r0)
            r13 = 1
            int r8 = r8 - r13
            r2.append(r8)
            java.lang.String r0 = r2.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x06db:
            r7 = r1
            r8 = r6
            r6 = -1
            r9 = 4
            r11 = 10
            r13 = 1
            int r2 = r2 + 1
            r6 = r8
            goto L_0x0271
        L_0x06e7:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>((java.lang.String) r4)
            throw r0
        L_0x06ed:
            r7 = r1
            r8 = r6
            r6 = -1
            r9 = 4
            r11 = 10
            r13 = 1
            int r2 = r2 + 1
            r6 = r8
            r14 = 4
            r15 = 8
            goto L_0x0232
        L_0x06fc:
            com.google.zxing.WriterException r0 = new com.google.zxing.WriterException
            r0.<init>((java.lang.String) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.a(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.EnumMap):com.google.zxing.qrcode.encoder.QRCode");
    }
}
