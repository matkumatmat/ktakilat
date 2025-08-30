package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzql;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzhc {
    final /* synthetic */ zzhg zza;
    private final String zzb;
    private final Bundle zzc = new Bundle();
    private Bundle zzd;

    public zzhc(zzhg zzhg, String str, Bundle bundle) {
        Objects.requireNonNull(zzhg);
        this.zza = zzhg;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:59|60|71) */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r15.zza.zzu.zzaV().zzb().zza("Error reading value from SharedPreferences. Value dropped");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0124 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011c A[Catch:{ NumberFormatException | JSONException -> 0x0124 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza() {
        /*
            r15 = this;
            android.os.Bundle r0 = r15.zzd
            if (r0 == 0) goto L_0x0006
            goto L_0x014d
        L_0x0006:
            com.google.android.gms.measurement.internal.zzhg r0 = r15.zza
            java.lang.String r1 = r15.zzb
            android.content.SharedPreferences r2 = r0.zzd()
            r3 = 0
            java.lang.String r1 = r2.getString(r1, r3)
            if (r1 == 0) goto L_0x0145
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ JSONException -> 0x013c }
            r2.<init>()     // Catch:{ JSONException -> 0x013c }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x013c }
            r4.<init>(r1)     // Catch:{ JSONException -> 0x013c }
            r1 = 0
            r5 = 0
        L_0x0021:
            int r6 = r4.length()     // Catch:{ JSONException -> 0x013c }
            if (r5 >= r6) goto L_0x0139
            org.json.JSONObject r6 = r4.getJSONObject(r5)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r7 = "n"
            java.lang.String r7 = r6.getString(r7)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r8 = "t"
            java.lang.String r8 = r6.getString(r8)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r9 = r8.hashCode()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r10 = 100
            r11 = 2
            r12 = 3
            r13 = 4
            r14 = 1
            if (r9 == r10) goto L_0x007c
            r10 = 108(0x6c, float:1.51E-43)
            if (r9 == r10) goto L_0x0072
            r10 = 115(0x73, float:1.61E-43)
            if (r9 == r10) goto L_0x0068
            r10 = 3352(0xd18, float:4.697E-42)
            if (r9 == r10) goto L_0x005e
            r10 = 3445(0xd75, float:4.827E-42)
            if (r9 == r10) goto L_0x0054
            goto L_0x0086
        L_0x0054:
            java.lang.String r9 = "la"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = 4
            goto L_0x0087
        L_0x005e:
            java.lang.String r9 = "ia"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = 3
            goto L_0x0087
        L_0x0068:
            java.lang.String r9 = "s"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = 0
            goto L_0x0087
        L_0x0072:
            java.lang.String r9 = "l"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = 2
            goto L_0x0087
        L_0x007c:
            java.lang.String r9 = "d"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0086
            r9 = 1
            goto L_0x0087
        L_0x0086:
            r9 = -1
        L_0x0087:
            java.lang.String r10 = "v"
            if (r9 == 0) goto L_0x011c
            if (r9 == r14) goto L_0x0110
            if (r9 == r11) goto L_0x0104
            if (r9 == r12) goto L_0x00d4
            if (r9 == r13) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzib r6 = r0.zzu     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzb()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r7 = "Unrecognized persisted bundle type. Type"
            r6.zzb(r7, r8)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x00a4:
            com.google.android.gms.internal.measurement.zzql.zza()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.zzib r8 = r0.zzu     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.zzal r8 = r8.zzc()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.zzfw r9 = com.google.android.gms.measurement.internal.zzfx.zzaQ     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            boolean r8 = r8.zzp(r3, r9)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            if (r8 == 0) goto L_0x0135
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r8.<init>(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r6 = r8.length()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            long[] r9 = new long[r6]     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r10 = 0
        L_0x00c5:
            if (r10 >= r6) goto L_0x00d0
            long r11 = r8.optLong(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r9[r10] = r11     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r10 = r10 + 1
            goto L_0x00c5
        L_0x00d0:
            r2.putLongArray(r7, r9)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x00d4:
            com.google.android.gms.internal.measurement.zzql.zza()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.zzib r8 = r0.zzu     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.zzal r8 = r8.zzc()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            com.google.android.gms.measurement.internal.zzfw r9 = com.google.android.gms.measurement.internal.zzfx.zzaQ     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            boolean r8 = r8.zzp(r3, r9)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            if (r8 == 0) goto L_0x0135
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r8.<init>(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r6 = r8.length()     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int[] r9 = new int[r6]     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r10 = 0
        L_0x00f5:
            if (r10 >= r6) goto L_0x0100
            int r11 = r8.optInt(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r9[r10] = r11     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            int r10 = r10 + 1
            goto L_0x00f5
        L_0x0100:
            r2.putIntArray(r7, r9)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x0104:
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            long r8 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r2.putLong(r7, r8)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x0110:
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            double r8 = java.lang.Double.parseDouble(r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r2.putDouble(r7, r8)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x011c:
            java.lang.String r6 = r6.getString(r10)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            r2.putString(r7, r6)     // Catch:{ NumberFormatException | JSONException -> 0x0124 }
            goto L_0x0135
        L_0x0124:
            com.google.android.gms.measurement.internal.zzhg r6 = r15.zza     // Catch:{ JSONException -> 0x013c }
            com.google.android.gms.measurement.internal.zzib r6 = r6.zzu     // Catch:{ JSONException -> 0x013c }
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()     // Catch:{ JSONException -> 0x013c }
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzb()     // Catch:{ JSONException -> 0x013c }
            java.lang.String r7 = "Error reading value from SharedPreferences. Value dropped"
            r6.zza(r7)     // Catch:{ JSONException -> 0x013c }
        L_0x0135:
            int r5 = r5 + 1
            goto L_0x0021
        L_0x0139:
            r15.zzd = r2     // Catch:{ JSONException -> 0x013c }
            goto L_0x0145
        L_0x013c:
            com.google.android.gms.measurement.internal.zzhg r0 = r15.zza
            com.google.android.gms.measurement.internal.zzib r0 = r0.zzu
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            defpackage.e.w(r0, r1)
        L_0x0145:
            android.os.Bundle r0 = r15.zzd
            if (r0 != 0) goto L_0x014d
            android.os.Bundle r0 = r15.zzc
            r15.zzd = r0
        L_0x014d:
            android.os.Bundle r0 = new android.os.Bundle
            android.os.Bundle r1 = r15.zzd
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhc.zza():android.os.Bundle");
    }

    @WorkerThread
    public final void zzb(Bundle bundle) {
        Bundle bundle2;
        zzhg zzhg;
        Bundle bundle3 = bundle;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle3);
        }
        zzhg zzhg2 = this.zza;
        SharedPreferences.Editor edit = zzhg2.zzd().edit();
        if (bundle2.size() == 0) {
            edit.remove(this.zzb);
        } else {
            String str = this.zzb;
            JSONArray jSONArray = new JSONArray();
            for (String next : bundle2.keySet()) {
                Object obj = bundle2.get(next);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", next);
                        zzql.zza();
                        zzib zzib = zzhg2.zzu;
                        zzhg = zzhg2;
                        if (zzib.zzc().zzp((String) null, zzfx.zzaQ)) {
                            try {
                                if (obj instanceof String) {
                                    jSONObject.put("v", obj.toString());
                                    jSONObject.put("t", "s");
                                } else if (obj instanceof Long) {
                                    jSONObject.put("v", obj.toString());
                                    jSONObject.put("t", "l");
                                } else if (obj instanceof int[]) {
                                    jSONObject.put("v", Arrays.toString((int[]) obj));
                                    jSONObject.put("t", "ia");
                                } else if (obj instanceof long[]) {
                                    jSONObject.put("v", Arrays.toString((long[]) obj));
                                    jSONObject.put("t", "la");
                                } else if (obj instanceof Double) {
                                    jSONObject.put("v", obj.toString());
                                    jSONObject.put("t", "d");
                                } else {
                                    zzib.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                                    zzhg2 = zzhg;
                                }
                            } catch (JSONException e) {
                                e = e;
                                this.zza.zzu.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences", e);
                                zzhg2 = zzhg;
                            }
                        } else {
                            jSONObject.put("v", obj.toString());
                            if (obj instanceof String) {
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("t", "l");
                            } else if (obj instanceof Double) {
                                jSONObject.put("t", "d");
                            } else {
                                zzib.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                                zzhg2 = zzhg;
                            }
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e = e2;
                        zzhg = zzhg2;
                        this.zza.zzu.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences", e);
                        zzhg2 = zzhg;
                    }
                    zzhg2 = zzhg;
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.zzd = bundle2;
    }
}
