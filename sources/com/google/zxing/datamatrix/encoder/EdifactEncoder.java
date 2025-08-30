package com.google.zxing.datamatrix.encoder;

final class EdifactEncoder implements Encoder {
    public static String b(StringBuilder sb) {
        char c;
        char c2;
        int length = sb.length();
        if (length != 0) {
            char c3 = 0;
            char charAt = sb.charAt(0);
            if (length >= 2) {
                c = sb.charAt(1);
            } else {
                c = 0;
            }
            if (length >= 3) {
                c2 = sb.charAt(2);
            } else {
                c2 = 0;
            }
            if (length >= 4) {
                c3 = sb.charAt(3);
            }
            int i = (charAt << 18) + (c << 12) + (c2 << 6) + c3;
            char c4 = (char) ((i >> 8) & 255);
            char c5 = (char) (i & 255);
            StringBuilder sb2 = new StringBuilder(3);
            sb2.append((char) ((i >> 16) & 255));
            if (length >= 2) {
                sb2.append(c4);
            }
            if (length >= 3) {
                sb2.append(c5);
            }
            return sb2.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        if (r9 <= 2) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.zxing.datamatrix.encoder.EncoderContext r12) {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            boolean r1 = r12.b()
            r2 = 0
            java.lang.String r3 = r12.f420a
            java.lang.StringBuilder r4 = r12.e
            r5 = 1
            r6 = 0
            r7 = 4
            if (r1 == 0) goto L_0x0055
            char r1 = r12.a()
            r8 = 32
            if (r1 < r8) goto L_0x0023
            r8 = 63
            if (r1 > r8) goto L_0x0023
            r0.append(r1)
            goto L_0x0031
        L_0x0023:
            r8 = 64
            if (r1 < r8) goto L_0x0051
            r8 = 94
            if (r1 > r8) goto L_0x0051
            int r1 = r1 + -64
            char r1 = (char) r1
            r0.append(r1)
        L_0x0031:
            int r1 = r12.f
            int r1 = r1 + r5
            r12.f = r1
            int r1 = r0.length()
            if (r1 < r7) goto L_0x0005
            java.lang.String r1 = b(r0)
            r4.append(r1)
            r0.delete(r6, r7)
            int r1 = r12.f
            int r1 = com.google.zxing.datamatrix.encoder.HighLevelEncoder.g(r3, r1, r7)
            if (r1 == r7) goto L_0x0005
            r12.g = r6
            goto L_0x0055
        L_0x0051:
            com.google.zxing.datamatrix.encoder.HighLevelEncoder.c(r1)
            throw r2
        L_0x0055:
            r1 = 31
            r0.append(r1)
            int r1 = r0.length()     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x0064
            r12.g = r6
            goto L_0x00cd
        L_0x0064:
            r8 = 2
            if (r1 != r5) goto L_0x0088
            int r9 = r4.length()     // Catch:{ all -> 0x00bd }
            r12.c(r9)     // Catch:{ all -> 0x00bd }
            com.google.zxing.datamatrix.encoder.SymbolInfo r9 = r12.h     // Catch:{ all -> 0x00bd }
            int r9 = r9.b     // Catch:{ all -> 0x00bd }
            int r10 = r4.length()     // Catch:{ all -> 0x00bd }
            int r9 = r9 - r10
            int r3 = r3.length()     // Catch:{ all -> 0x00bd }
            int r10 = r12.i     // Catch:{ all -> 0x00bd }
            int r3 = r3 - r10
            int r10 = r12.f     // Catch:{ all -> 0x00bd }
            int r3 = r3 - r10
            if (r3 != 0) goto L_0x0088
            if (r9 > r8) goto L_0x0088
        L_0x0085:
            r12.g = r6
            goto L_0x00cd
        L_0x0088:
            if (r1 > r7) goto L_0x00ce
            int r1 = r1 - r5
            java.lang.String r0 = b(r0)     // Catch:{ all -> 0x00bd }
            boolean r3 = r12.b()     // Catch:{ all -> 0x00bd }
            if (r3 != 0) goto L_0x0098
            if (r1 > r8) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r5 = 0
        L_0x0099:
            if (r1 > r8) goto L_0x00bf
            int r3 = r4.length()     // Catch:{ all -> 0x00bd }
            int r3 = r3 + r1
            r12.c(r3)     // Catch:{ all -> 0x00bd }
            com.google.zxing.datamatrix.encoder.SymbolInfo r3 = r12.h     // Catch:{ all -> 0x00bd }
            int r3 = r3.b     // Catch:{ all -> 0x00bd }
            int r7 = r4.length()     // Catch:{ all -> 0x00bd }
            int r3 = r3 - r7
            r7 = 3
            if (r3 < r7) goto L_0x00bf
            int r3 = r4.length()     // Catch:{ all -> 0x00bd }
            int r5 = r0.length()     // Catch:{ all -> 0x00bd }
            int r3 = r3 + r5
            r12.c(r3)     // Catch:{ all -> 0x00bd }
            r5 = 0
            goto L_0x00bf
        L_0x00bd:
            r0 = move-exception
            goto L_0x00d6
        L_0x00bf:
            if (r5 == 0) goto L_0x00c9
            r12.h = r2     // Catch:{ all -> 0x00bd }
            int r0 = r12.f     // Catch:{ all -> 0x00bd }
            int r0 = r0 - r1
            r12.f = r0     // Catch:{ all -> 0x00bd }
            goto L_0x0085
        L_0x00c9:
            r4.append(r0)     // Catch:{ all -> 0x00bd }
            goto L_0x0085
        L_0x00cd:
            return
        L_0x00ce:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "Count must not exceed 4"
            r0.<init>(r1)     // Catch:{ all -> 0x00bd }
            throw r0     // Catch:{ all -> 0x00bd }
        L_0x00d6:
            r12.g = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.EdifactEncoder.a(com.google.zxing.datamatrix.encoder.EncoderContext):void");
    }
}
