package com.appsflyer.internal;

import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

@SourceDebugExtension({"SMAP\nStringExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExtensions.kt\ncom/appsflyer/internal/util/StringExtensionsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,126:1\n13004#2,3:127\n*S KotlinDebug\n*F\n+ 1 StringExtensions.kt\ncom/appsflyer/internal/util/StringExtensionsKt\n*L\n54#1:127,3\n*E\n"})
public final class AFj1aSDK {
    public static final String getMonetizationNetwork(String str, String str2) {
        MessageDigest instance = MessageDigest.getInstance(str2);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "");
        int length = digest.length;
        String str3 = "";
        for (int i = 0; i < length; i++) {
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(digest[i])}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            str3 = e.l(str3, format);
        }
        return str3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        r0 = kotlin.text.StringsKt.toIntOrNull((r0 = r0.f750a));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getMonetizationNetwork(@org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.text.Regex r0 = new kotlin.text.Regex
            java.lang.String r1 = "(\\d+).(\\d+).(\\d+).*"
            r0.<init>((java.lang.String) r1)
            kotlin.text.MatchResult r4 = r0.matchEntire(r4)
            if (r4 == 0) goto L_0x006c
            kotlin.text.MatcherMatchResult$groups$1 r0 = r4.a()
            r1 = 1
            kotlin.text.MatchGroup r0 = r0.a(r1)
            r1 = 0
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r0.f750a
            if (r0 == 0) goto L_0x002d
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L_0x002d
            int r0 = r0.intValue()
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            r2 = 1000000(0xf4240, float:1.401298E-39)
            int r0 = r0 * r2
            kotlin.text.MatcherMatchResult$groups$1 r2 = r4.a()
            r3 = 2
            kotlin.text.MatchGroup r2 = r2.a(r3)
            if (r2 == 0) goto L_0x004d
            java.lang.String r2 = r2.f750a
            if (r2 == 0) goto L_0x004d
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto L_0x004d
            int r2 = r2.intValue()
            goto L_0x004e
        L_0x004d:
            r2 = 0
        L_0x004e:
            int r2 = r2 * 1000
            int r2 = r2 + r0
            kotlin.text.MatcherMatchResult$groups$1 r4 = r4.a()
            r0 = 3
            kotlin.text.MatchGroup r4 = r4.a(r0)
            if (r4 == 0) goto L_0x006a
            java.lang.String r4 = r4.f750a
            if (r4 == 0) goto L_0x006a
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)
            if (r4 == 0) goto L_0x006a
            int r1 = r4.intValue()
        L_0x006a:
            int r2 = r2 + r1
            return r2
        L_0x006c:
            r4 = -1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFj1aSDK.getMonetizationNetwork(java.lang.String):int");
    }
}
