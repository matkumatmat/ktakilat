package com.appsflyer.internal;

import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nStringExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExtensions.kt\ncom/appsflyer/internal/components/monitorsdk/helpers/StringExtensionsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,102:1\n13004#2,3:103\n*S KotlinDebug\n*F\n+ 1 StringExtensions.kt\ncom/appsflyer/internal/components/monitorsdk/helpers/StringExtensionsKt\n*L\n44#1:103,3\n*E\n"})
public final class AFd1rSDK {
    @NotNull
    public static final String AFAdRevenueData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return "[Exception Manager]: " + str;
    }

    public static final String getCurrencyIso4217Code(String str, String str2) {
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

    @Nullable
    public static final Pair<Integer, Integer> getMediationNetwork(@NotNull String str) {
        Integer num;
        Integer num2;
        Integer num3;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(str, "");
        MatchResult matchEntire = new Regex("^(\\d+).(\\+)$|^(\\d+).(\\d+).(\\+)$").matchEntire(str);
        if (matchEntire != null) {
            MatchGroup a2 = matchEntire.a().a(1);
            if (a2 == null || (str4 = a2.f750a) == null) {
                num = null;
            } else {
                num = StringsKt.toIntOrNull(str4);
            }
            MatchGroup a3 = matchEntire.a().a(3);
            if (a3 == null || (str3 = a3.f750a) == null) {
                num2 = null;
            } else {
                num2 = StringsKt.toIntOrNull(str3);
            }
            MatchGroup a4 = matchEntire.a().a(4);
            if (a4 == null || (str2 = a4.f750a) == null) {
                num3 = null;
            } else {
                num3 = StringsKt.toIntOrNull(str2);
            }
            if (num != null) {
                return new Pair<>(Integer.valueOf(num.intValue() * 1000000), Integer.valueOf(((num.intValue() + 1) * 1000000) - 1));
            }
            if (!(num2 == null || num3 == null)) {
                return new Pair<>(Integer.valueOf((num3.intValue() * 1000) + (num2.intValue() * 1000000)), Integer.valueOf((((num3.intValue() + 1) * 1000) + (num2.intValue() * 1000000)) - 1));
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0023, code lost:
        r7 = r7.f750a;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair<java.lang.Integer, java.lang.Integer> getRevenue(@org.jetbrains.annotations.NotNull java.lang.String r13) {
        /*
            r0 = 6
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r6 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r6)
            kotlin.text.Regex r6 = new kotlin.text.Regex
            java.lang.String r7 = "(\\d+).(\\d+).(\\d+)-(\\d+).(\\d+).(\\d+)"
            r6.<init>((java.lang.String) r7)
            kotlin.text.MatchResult r13 = r6.matchEntire(r13)
            r6 = 0
            if (r13 == 0) goto L_0x00ed
            kotlin.text.MatcherMatchResult$groups$1 r7 = r13.a()
            kotlin.text.MatchGroup r7 = r7.a(r5)
            if (r7 == 0) goto L_0x002c
            java.lang.String r7 = r7.f750a
            if (r7 == 0) goto L_0x002c
            java.lang.Integer r7 = kotlin.text.StringsKt.toIntOrNull(r7)
            goto L_0x002d
        L_0x002c:
            r7 = r6
        L_0x002d:
            kotlin.text.MatcherMatchResult$groups$1 r8 = r13.a()
            kotlin.text.MatchGroup r8 = r8.a(r4)
            if (r8 == 0) goto L_0x0040
            java.lang.String r8 = r8.f750a
            if (r8 == 0) goto L_0x0040
            java.lang.Integer r8 = kotlin.text.StringsKt.toIntOrNull(r8)
            goto L_0x0041
        L_0x0040:
            r8 = r6
        L_0x0041:
            kotlin.text.MatcherMatchResult$groups$1 r9 = r13.a()
            kotlin.text.MatchGroup r9 = r9.a(r3)
            if (r9 == 0) goto L_0x0054
            java.lang.String r9 = r9.f750a
            if (r9 == 0) goto L_0x0054
            java.lang.Integer r9 = kotlin.text.StringsKt.toIntOrNull(r9)
            goto L_0x0055
        L_0x0054:
            r9 = r6
        L_0x0055:
            kotlin.text.MatcherMatchResult$groups$1 r10 = r13.a()
            kotlin.text.MatchGroup r10 = r10.a(r2)
            if (r10 == 0) goto L_0x0068
            java.lang.String r10 = r10.f750a
            if (r10 == 0) goto L_0x0068
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            goto L_0x0069
        L_0x0068:
            r10 = r6
        L_0x0069:
            kotlin.text.MatcherMatchResult$groups$1 r11 = r13.a()
            kotlin.text.MatchGroup r11 = r11.a(r1)
            if (r11 == 0) goto L_0x007c
            java.lang.String r11 = r11.f750a
            if (r11 == 0) goto L_0x007c
            java.lang.Integer r11 = kotlin.text.StringsKt.toIntOrNull(r11)
            goto L_0x007d
        L_0x007c:
            r11 = r6
        L_0x007d:
            kotlin.text.MatcherMatchResult$groups$1 r13 = r13.a()
            kotlin.text.MatchGroup r13 = r13.a(r0)
            if (r13 == 0) goto L_0x0090
            java.lang.String r13 = r13.f750a
            if (r13 == 0) goto L_0x0090
            java.lang.Integer r13 = kotlin.text.StringsKt.toIntOrNull(r13)
            goto L_0x0091
        L_0x0090:
            r13 = r6
        L_0x0091:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r12 = 0
            r0[r12] = r7
            r0[r5] = r8
            r0[r4] = r9
            r0[r3] = r10
            r0[r2] = r11
            r0[r1] = r13
            boolean r0 = getRevenue((java.lang.Object[]) r0)
            if (r0 == 0) goto L_0x00ed
            kotlin.jvm.internal.Intrinsics.c(r7)
            int r0 = r7.intValue()
            r1 = 1000000(0xf4240, float:1.401298E-39)
            int r0 = r0 * r1
            kotlin.jvm.internal.Intrinsics.c(r8)
            int r2 = r8.intValue()
            int r2 = r2 * 1000
            int r2 = r2 + r0
            kotlin.jvm.internal.Intrinsics.c(r9)
            int r0 = r9.intValue()
            int r0 = r0 + r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            kotlin.jvm.internal.Intrinsics.c(r10)
            int r2 = r10.intValue()
            int r2 = r2 * r1
            kotlin.jvm.internal.Intrinsics.c(r11)
            int r1 = r11.intValue()
            int r1 = r1 * 1000
            int r1 = r1 + r2
            kotlin.jvm.internal.Intrinsics.c(r13)
            int r13 = r13.intValue()
            int r13 = r13 + r1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            kotlin.Pair r1 = new kotlin.Pair
            r1.<init>(r0, r13)
            return r1
        L_0x00ed:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1rSDK.getRevenue(java.lang.String):kotlin.Pair");
    }

    private static boolean getRevenue(@NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "");
        return !ArraysKt.h(objArr, (Object) null);
    }
}
