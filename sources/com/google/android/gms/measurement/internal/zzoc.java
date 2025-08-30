package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class zzoc {
    private final Map zza;

    public zzoc(Map map) {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        hashMap.putAll(map);
    }

    private final Bundle zzf() {
        int zzg;
        String str;
        String str2;
        Map map = this.zza;
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("GoogleConsent")) && (zzg = zzg()) >= 0) {
            String str3 = (String) map.get("PurposeConsents");
            if (!TextUtils.isEmpty(str3)) {
                Bundle bundle = new Bundle();
                String str4 = "denied";
                if (str3.length() > 0) {
                    String str5 = zzjj.AD_STORAGE.zze;
                    if (str3.charAt(0) == '1') {
                        str2 = "granted";
                    } else {
                        str2 = str4;
                    }
                    bundle.putString(str5, str2);
                }
                if (str3.length() > 3) {
                    String str6 = zzjj.AD_PERSONALIZATION.zze;
                    if (str3.charAt(2) == '1' && str3.charAt(3) == '1') {
                        str = "granted";
                    } else {
                        str = str4;
                    }
                    bundle.putString(str6, str);
                }
                if (str3.length() > 6 && zzg >= 4) {
                    String str7 = zzjj.AD_USER_DATA.zze;
                    if (str3.charAt(0) == '1' && str3.charAt(6) == '1') {
                        str4 = "granted";
                    }
                    bundle.putString(str7, str4);
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    private final int zzg() {
        try {
            String str = (String) this.zza.get("PolicyVersion");
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoc)) {
            return false;
        }
        return zza().equalsIgnoreCase(((zzoc) obj).zza());
    }

    public final int hashCode() {
        return zza().hashCode();
    }

    public final String toString() {
        return zza();
    }

    public final String zza() {
        StringBuilder sb = new StringBuilder();
        ImmutableList immutableList = zzoe.zza;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            Map map = this.zza;
            if (map.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) map.get(str));
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if (com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(r2.get("EnableAdvertiserConsentMode")) != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0029, code lost:
        if (com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(r2.get("EnableAdvertiserConsentMode")) != false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzb() {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzfw r0 = com.google.android.gms.measurement.internal.zzfx.zzaZ
            r1 = 0
            java.lang.Object r2 = r0.zzb(r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.String r3 = "EnableAdvertiserConsentMode"
            java.lang.String r4 = "gdprApplies"
            java.lang.String r5 = "1"
            if (r2 == 0) goto L_0x002c
            java.util.Map r2 = r9.zza
            java.lang.Object r4 = r2.get(r4)
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00df
            java.lang.Object r2 = r2.get(r3)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00df
            goto L_0x004e
        L_0x002c:
            java.util.Map r2 = r9.zza
            java.lang.String r6 = "GoogleConsent"
            java.lang.Object r6 = r2.get(r6)
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x00df
            java.lang.Object r4 = r2.get(r4)
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00df
            java.lang.Object r2 = r2.get(r3)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00df
        L_0x004e:
            java.lang.Object r0 = r0.zzb(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00da
            java.util.Map r0 = r9.zza
            java.lang.String r1 = "Version"
            java.lang.Object r1 = r0.get(r1)
            if (r1 != 0) goto L_0x0069
            android.os.Bundle r0 = r9.zzf()
            return r0
        L_0x0069:
            int r1 = r9.zzg()
            if (r1 >= 0) goto L_0x0071
            goto L_0x00df
        L_0x0071:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            com.google.android.gms.measurement.internal.zzjj r2 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE
            java.lang.String r2 = r2.zze
            java.lang.String r3 = "AuthorizePurpose1"
            java.lang.Object r4 = r0.get(r3)
            boolean r4 = java.util.Objects.equals(r4, r5)
            java.lang.String r6 = "granted"
            java.lang.String r7 = "denied"
            r8 = 1
            if (r8 == r4) goto L_0x008d
            r4 = r7
            goto L_0x008e
        L_0x008d:
            r4 = r6
        L_0x008e:
            r1.putString(r2, r4)
            com.google.android.gms.measurement.internal.zzjj r2 = com.google.android.gms.measurement.internal.zzjj.AD_PERSONALIZATION
            java.lang.String r2 = r2.zze
            java.lang.String r4 = "AuthorizePurpose3"
            java.lang.Object r4 = r0.get(r4)
            boolean r4 = java.util.Objects.equals(r4, r5)
            if (r4 == 0) goto L_0x00af
            java.lang.String r4 = "AuthorizePurpose4"
            java.lang.Object r4 = r0.get(r4)
            boolean r4 = java.util.Objects.equals(r4, r5)
            if (r4 == 0) goto L_0x00af
            r4 = r6
            goto L_0x00b0
        L_0x00af:
            r4 = r7
        L_0x00b0:
            r1.putString(r2, r4)
            int r2 = r9.zzg()
            r4 = 4
            if (r2 < r4) goto L_0x00d9
            com.google.android.gms.measurement.internal.zzjj r2 = com.google.android.gms.measurement.internal.zzjj.AD_USER_DATA
            java.lang.String r2 = r2.zze
            java.lang.Object r3 = r0.get(r3)
            boolean r3 = java.util.Objects.equals(r3, r5)
            if (r3 == 0) goto L_0x00d5
            java.lang.String r3 = "AuthorizePurpose7"
            java.lang.Object r0 = r0.get(r3)
            boolean r0 = java.util.Objects.equals(r0, r5)
            if (r0 == 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r6 = r7
        L_0x00d6:
            r1.putString(r2, r6)
        L_0x00d9:
            return r1
        L_0x00da:
            android.os.Bundle r0 = r9.zzf()
            return r0
        L_0x00df:
            android.os.Bundle r0 = android.os.Bundle.EMPTY
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzoc.zzb():android.os.Bundle");
    }

    public final String zzc() {
        String str = (String) this.zza.get("PurposeDiagnostics");
        if (TextUtils.isEmpty(str)) {
            return "200000";
        }
        return str;
    }

    public final String zzd(zzoc zzoc) {
        Map map = zzoc.zza;
        boolean isEmpty = map.isEmpty();
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        String str2 = (isEmpty || ((String) map.get("Version")) != null) ? str : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        Bundle zzb = zzb();
        Bundle zzb2 = zzoc.zzb();
        if (zzb.size() != zzb2.size() || !Objects.equals(zzb.getString("ad_storage"), zzb2.getString("ad_storage")) || !Objects.equals(zzb.getString("ad_personalization"), zzb2.getString("ad_personalization")) || !Objects.equals(zzb.getString("ad_user_data"), zzb2.getString("ad_user_data"))) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        return str2.concat(str);
    }

    public final String zze() {
        int i;
        StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        int i2 = -1;
        try {
            String str = (String) this.zza.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i2 = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i2 < 0 || i2 > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i2 >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i2 & 63));
        }
        int zzg = zzg();
        if (zzg < 0 || zzg > 63) {
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(zzg));
        }
        Preconditions.checkArgument(true);
        Map map = this.zza;
        if (true != AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("gdprApplies"))) {
            i = 0;
        } else {
            i = 2;
        }
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("EnableAdvertiserConsentMode"));
        int i3 = i | 4;
        if (equals) {
            i3 = i | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3));
        return sb.toString();
    }
}
