package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DebugKt {
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r0.equals(org.apache.commons.lang3.BooleanUtils.ON) != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r0.equals("") != false) goto L_0x003f;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.c(r0)
            if (r0 == 0) goto L_0x006b
            int r1 = r0.hashCode()
            if (r1 == 0) goto L_0x0037
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L_0x002e
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 == r2) goto L_0x0025
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 != r2) goto L_0x004e
            java.lang.String r1 = "auto"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            goto L_0x006b
        L_0x0025:
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            goto L_0x006b
        L_0x002e:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
            goto L_0x003f
        L_0x0037:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x004e
        L_0x003f:
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.c(r0)
            if (r0 == 0) goto L_0x004c
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            goto L_0x006b
        L_0x004c:
            r0 = 1
            goto L_0x006b
        L_0x004e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.<init>(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x006b:
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugKt.<clinit>():void");
    }
}
