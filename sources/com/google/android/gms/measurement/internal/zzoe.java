package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.measurement.zzko;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;

public final class zzoe {
    static final ImmutableList zza = ImmutableList.of("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    public static String zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static int zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzc(com.google.android.gms.internal.measurement.zzko r21, com.google.common.collect.ImmutableMap r22, com.google.common.collect.ImmutableMap r23, com.google.common.collect.ImmutableSet r24, char[] r25, int r26, int r27, int r28, int r29, int r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, boolean r34, boolean r35, boolean r36) {
        /*
            r15 = r21
            r14 = r22
            int r16 = zze(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            r13 = 50
            r12 = 1
            if (r16 <= 0) goto L_0x0025
            r0 = r28
            if (r0 != r12) goto L_0x001c
            r1 = r27
            if (r1 == r12) goto L_0x0017
            r0 = 1
            goto L_0x001e
        L_0x0017:
            r17 = 1
            r18 = 1
            goto L_0x002a
        L_0x001c:
            r1 = r27
        L_0x001e:
            r25[r16] = r13
        L_0x0020:
            r18 = r0
            r17 = r1
            goto L_0x002a
        L_0x0025:
            r1 = r27
            r0 = r28
            goto L_0x0020
        L_0x002a:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            com.google.android.gms.internal.measurement.zzkp r0 = zzi(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED
            if (r0 != r1) goto L_0x0056
            r0 = 51
            goto L_0x0213
        L_0x0056:
            com.google.android.gms.internal.measurement.zzko r0 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE
            r15 = r21
            if (r15 != r0) goto L_0x0082
            r0 = r30
            r1 = 1
            r14 = r24
            r13 = r31
            if (r0 != r1) goto L_0x007f
            boolean r0 = r14.contains(r13)
            if (r0 == 0) goto L_0x0078
            if (r16 <= 0) goto L_0x0077
            char r0 = r25[r16]
            r12 = 50
            if (r0 == r12) goto L_0x0077
            r0 = 49
            r25[r16] = r0
        L_0x0077:
            return r1
        L_0x0078:
            r12 = 50
            r11 = r22
            r19 = 1
            goto L_0x008e
        L_0x007f:
            r12 = 50
            goto L_0x008a
        L_0x0082:
            r14 = r24
            r0 = r30
            r13 = r31
            r1 = 1
            goto L_0x007f
        L_0x008a:
            r11 = r22
            r19 = r0
        L_0x008e:
            boolean r0 = r11.containsKey(r15)
            r2 = 48
            if (r0 != 0) goto L_0x009a
        L_0x0096:
            r0 = 48
            goto L_0x0213
        L_0x009a:
            java.lang.Object r0 = r11.get(r15)
            com.google.android.gms.measurement.internal.zzod r0 = (com.google.android.gms.measurement.internal.zzod) r0
            if (r0 != 0) goto L_0x00a3
            goto L_0x0096
        L_0x00a3:
            int r0 = r0.ordinal()
            r20 = 56
            if (r0 == 0) goto L_0x01ea
            if (r0 == r1) goto L_0x0198
            r1 = 2
            if (r0 == r1) goto L_0x0126
            r1 = 3
            if (r0 == r1) goto L_0x00b4
            goto L_0x0096
        L_0x00b4:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            com.google.android.gms.internal.measurement.zzkp r0 = zzi(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT
            if (r0 != r1) goto L_0x0101
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            boolean r0 = zzg(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        L_0x0101:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            boolean r0 = zzh(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        L_0x0126:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            com.google.android.gms.internal.measurement.zzkp r0 = zzi(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST
            if (r0 != r1) goto L_0x0173
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            boolean r0 = zzh(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        L_0x0173:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            boolean r0 = zzg(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        L_0x0198:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r15 = 50
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            com.google.android.gms.internal.measurement.zzkp r0 = zzi(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT
            if (r0 != r1) goto L_0x01c5
        L_0x01c2:
            r0 = 56
            goto L_0x0213
        L_0x01c5:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            boolean r0 = zzh(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        L_0x01ea:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            com.google.android.gms.internal.measurement.zzkp r0 = zzi(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.google.android.gms.internal.measurement.zzkp r1 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST
            if (r0 != r1) goto L_0x021f
            goto L_0x01c2
        L_0x0213:
            if (r16 <= 0) goto L_0x021d
            char r1 = r25[r16]
            r2 = 50
            if (r1 == r2) goto L_0x021d
            r25[r16] = r0
        L_0x021d:
            r0 = 0
            return r0
        L_0x021f:
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r17
            r7 = r18
            r8 = r29
            r9 = r19
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            boolean r0 = zzg(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzoe.zzc(com.google.android.gms.internal.measurement.zzko, com.google.common.collect.ImmutableMap, com.google.common.collect.ImmutableMap, com.google.common.collect.ImmutableSet, char[], int, int, int, int, int, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean):boolean");
    }

    public static final Map zzd(ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        int i6;
        int i7;
        int i8;
        int i9;
        ImmutableMap immutableMap3 = immutableMap2;
        if (((Boolean) zzfx.zzba.zzb((Object) null)).booleanValue() && !z3) {
            return ImmutableMap.of();
        }
        zzko zzko = zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        zzkp zzkp = (zzkp) immutableMap3.get(zzko);
        zzko zzko2 = zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        zzkp zzkp2 = (zzkp) immutableMap3.get(zzko2);
        zzko zzko3 = zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        zzkp zzkp3 = (zzkp) immutableMap3.get(zzko3);
        zzko zzko4 = zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        zzkp zzkp4 = (zzkp) immutableMap3.get(zzko4);
        ImmutableMap.Builder put = ImmutableMap.builder().put("Version", ExifInterface.GPS_MEASUREMENT_2D);
        String str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ImmutableMap.Builder put2 = put.put("VendorConsent", true != z ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_YES).put("VendorLegitimateInterest", true != z2 ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_YES).put("gdprApplies", i3 != 1 ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_YES).put("EnableAdvertiserConsentMode", i2 != 1 ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_YES).put("PolicyVersion", String.valueOf(i4)).put("CmpSdkID", String.valueOf(i)).put("PurposeOneTreatment", i5 != 1 ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_YES).put("PublisherCC", str);
        if (zzkp != null) {
            i6 = zzkp.zza();
        } else {
            i6 = zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put3 = put2.put("PublisherRestrictions1", String.valueOf(i6));
        if (zzkp2 != null) {
            i7 = zzkp2.zza();
        } else {
            i7 = zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put4 = put3.put("PublisherRestrictions3", String.valueOf(i7));
        if (zzkp3 != null) {
            i8 = zzkp3.zza();
        } else {
            i8 = zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put5 = put4.put("PublisherRestrictions4", String.valueOf(i8));
        if (zzkp4 != null) {
            i9 = zzkp4.zza();
        } else {
            i9 = zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put6 = put5.put("PublisherRestrictions7", String.valueOf(i9));
        zzko zzko5 = zzko;
        ImmutableMap immutableMap4 = immutableMap;
        ImmutableMap immutableMap5 = immutableMap2;
        ImmutableSet immutableSet2 = immutableSet;
        char[] cArr2 = cArr;
        ImmutableMap.Builder builder = put6;
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        String str5 = str;
        zzko zzko6 = zzko4;
        String str6 = str2;
        zzko zzko7 = zzko3;
        String str7 = str3;
        zzko zzko8 = zzko2;
        boolean z4 = z;
        zzko zzko9 = zzko;
        boolean z5 = z2;
        boolean z6 = z3;
        ImmutableMap.Builder putAll = builder.putAll(ImmutableMap.of("Purpose1", zzf(zzko5, immutableMap4, immutableMap5, immutableSet2, cArr2, i10, i11, i12, i13, i14, str5, str6, str7, z4, z5, z6), "Purpose3", zzf(zzko8, immutableMap4, immutableMap5, immutableSet2, cArr2, i10, i11, i12, i13, i14, str5, str6, str7, z4, z5, z6), "Purpose4", zzf(zzko7, immutableMap4, immutableMap5, immutableSet2, cArr2, i10, i11, i12, i13, i14, str5, str6, str7, z4, z5, z6), "Purpose7", zzf(zzko6, immutableMap4, immutableMap5, immutableSet2, cArr2, i10, i11, i12, i13, i14, str5, str6, str7, z4, z5, z6)));
        String str8 = true != zzc(zzko9, immutableMap, immutableMap5, immutableSet2, cArr2, i10, i11, i12, i13, i14, str5, str6, str7, z4, z5, z3) ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        String str9 = true != zzc(zzko8, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3) ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        String str10 = true != zzc(zzko7, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3) ? str4 : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        if (true == zzc(zzko6, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3)) {
            str4 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        return putAll.putAll(ImmutableMap.of("AuthorizePurpose1", str8, "AuthorizePurpose3", str9, "AuthorizePurpose4", str10, "AuthorizePurpose7", str4, "PurposeDiagnostics", new String(cArr))).buildOrThrow();
    }

    private static final int zze(zzko zzko, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (zzko == zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzko == zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzko == zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzko == zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final String zzf(zzko zzko, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        String str4;
        boolean isEmpty = TextUtils.isEmpty(str2);
        String str5 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (isEmpty || str2.length() < zzko.zza()) {
            str4 = str5;
        } else {
            str4 = String.valueOf(str2.charAt(zzko.zza() - 1));
        }
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzko.zza()) {
            str5 = String.valueOf(str3.charAt(zzko.zza() - 1));
        }
        return String.valueOf(str4).concat(String.valueOf(str5));
    }

    private static final boolean zzg(zzko zzko, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        char c;
        int zze = zze(zzko, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3);
        boolean z4 = false;
        if (!z) {
            c = '4';
        } else if (str2.length() < zzko.zza()) {
            c = '0';
        } else {
            char charAt = str2.charAt(zzko.zza() - 1);
            char c2 = '1';
            if (charAt == '1') {
                z4 = true;
            }
            if (zze > 0 && cArr[zze] != '2') {
                if (charAt != '1') {
                    c2 = '6';
                }
                cArr[zze] = c2;
            }
            return z4;
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c;
        }
        return false;
    }

    private static final boolean zzh(zzko zzko, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        char c;
        int zze = zze(zzko, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3);
        boolean z4 = false;
        if (!z2) {
            c = '5';
        } else if (str3.length() < zzko.zza()) {
            c = '0';
        } else {
            char charAt = str3.charAt(zzko.zza() - 1);
            char c2 = '1';
            if (charAt == '1') {
                z4 = true;
            }
            if (zze > 0 && cArr[zze] != '2') {
                if (charAt != '1') {
                    c2 = '7';
                }
                cArr[zze] = c2;
            }
            return z4;
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c;
        }
        return false;
    }

    private static final zzkp zzi(zzko zzko, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        return (zzkp) immutableMap2.getOrDefault(zzko, zzkp.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
