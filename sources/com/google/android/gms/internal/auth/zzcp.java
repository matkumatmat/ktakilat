package com.google.android.gms.internal.auth;

public final class zzcp {
    private static volatile zzdh zza;

    private zzcp() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:74|75) */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        throw r14;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x0168 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.auth.zzdh zza(android.content.Context r14) {
        /*
            r0 = 1
            r1 = 0
            java.lang.Class<com.google.android.gms.internal.auth.zzcp> r2 = com.google.android.gms.internal.auth.zzcp.class
            monitor-enter(r2)
            com.google.android.gms.internal.auth.zzdh r3 = zza     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x017f
            java.lang.String r3 = android.os.Build.TYPE     // Catch:{ all -> 0x001e }
            java.lang.String r4 = android.os.Build.TAGS     // Catch:{ all -> 0x001e }
            java.lang.String r5 = "eng"
            boolean r5 = r3.equals(r5)     // Catch:{ all -> 0x001e }
            if (r5 != 0) goto L_0x0021
            java.lang.String r5 = "userdebug"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x0032
            goto L_0x0021
        L_0x001e:
            r14 = move-exception
            goto L_0x0181
        L_0x0021:
            java.lang.String r3 = "dev-keys"
            boolean r3 = r4.contains(r3)     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0039
            java.lang.String r3 = "test-keys"
            boolean r3 = r4.contains(r3)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x0032
            goto L_0x0039
        L_0x0032:
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x001e }
        L_0x0036:
            r3 = r14
            goto L_0x0178
        L_0x0039:
            boolean r3 = com.google.android.gms.internal.auth.zzcc.zzb()     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x0049
            boolean r3 = r14.isDeviceProtectedStorage()     // Catch:{ all -> 0x001e }
            if (r3 != 0) goto L_0x0049
            android.content.Context r14 = r14.createDeviceProtectedStorageContext()     // Catch:{ all -> 0x001e }
        L_0x0049:
            android.os.StrictMode$ThreadPolicy r3 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ all -> 0x001e }
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0068 }
            java.io.File r4 = new java.io.File     // Catch:{ RuntimeException -> 0x0070 }
            java.lang.String r5 = "phenotype_hermetic"
            java.io.File r5 = r14.getDir(r5, r1)     // Catch:{ RuntimeException -> 0x0070 }
            java.lang.String r6 = "overrides.txt"
            r4.<init>(r5, r6)     // Catch:{ RuntimeException -> 0x0070 }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x0068 }
            if (r5 == 0) goto L_0x006b
            com.google.android.gms.internal.auth.zzdh r4 = com.google.android.gms.internal.auth.zzdh.zzd(r4)     // Catch:{ all -> 0x0068 }
            goto L_0x007c
        L_0x0068:
            r14 = move-exception
            goto L_0x017b
        L_0x006b:
            com.google.android.gms.internal.auth.zzdh r4 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0068 }
            goto L_0x007c
        L_0x0070:
            r4 = move-exception
            java.lang.String r5 = "HermeticFileOverrides"
            java.lang.String r6 = "no data dir"
            android.util.Log.e(r5, r6, r4)     // Catch:{ all -> 0x0068 }
            com.google.android.gms.internal.auth.zzdh r4 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0068 }
        L_0x007c:
            boolean r5 = r4.zzb()     // Catch:{ all -> 0x0068 }
            if (r5 == 0) goto L_0x016f
            java.lang.Object r4 = r4.zza()     // Catch:{ all -> 0x0068 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x014c }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x014c }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x014c }
            r8 = r4
            java.io.File r8 = (java.io.File) r8     // Catch:{ IOException -> 0x014c }
            r7.<init>(r8)     // Catch:{ IOException -> 0x014c }
            r6.<init>(r7)     // Catch:{ IOException -> 0x014c }
            r5.<init>(r6)     // Catch:{ IOException -> 0x014c }
            androidx.collection.SimpleArrayMap r6 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x00c9 }
            r6.<init>()     // Catch:{ all -> 0x00c9 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x00c9 }
            r7.<init>()     // Catch:{ all -> 0x00c9 }
        L_0x00a2:
            java.lang.String r8 = r5.readLine()     // Catch:{ all -> 0x00c9 }
            if (r8 == 0) goto L_0x0119
            java.lang.String r9 = " "
            r10 = 3
            java.lang.String[] r9 = r8.split(r9, r10)     // Catch:{ all -> 0x00c9 }
            int r11 = r9.length     // Catch:{ all -> 0x00c9 }
            if (r11 == r10) goto L_0x00cc
            java.lang.String r9 = "HermeticFileOverrides"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c9 }
            r10.<init>()     // Catch:{ all -> 0x00c9 }
            java.lang.String r11 = "Invalid: "
            r10.append(r11)     // Catch:{ all -> 0x00c9 }
            r10.append(r8)     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x00c9 }
            android.util.Log.e(r9, r8)     // Catch:{ all -> 0x00c9 }
            goto L_0x00a2
        L_0x00c9:
            r14 = move-exception
            goto L_0x014e
        L_0x00cc:
            r8 = r9[r1]     // Catch:{ all -> 0x00c9 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00c9 }
            r10.<init>(r8)     // Catch:{ all -> 0x00c9 }
            r8 = r9[r0]     // Catch:{ all -> 0x00c9 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00c9 }
            r11.<init>(r8)     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x00c9 }
            r11 = 2
            r12 = r9[r11]     // Catch:{ all -> 0x00c9 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ all -> 0x00c9 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x00c9 }
            if (r12 != 0) goto L_0x0101
            r9 = r9[r11]     // Catch:{ all -> 0x00c9 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00c9 }
            r11.<init>(r9)     // Catch:{ all -> 0x00c9 }
            java.lang.String r12 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x00c9 }
            int r9 = r12.length()     // Catch:{ all -> 0x00c9 }
            r13 = 1024(0x400, float:1.435E-42)
            if (r9 < r13) goto L_0x00fe
            if (r12 != r11) goto L_0x0101
        L_0x00fe:
            r7.put(r11, r12)     // Catch:{ all -> 0x00c9 }
        L_0x0101:
            boolean r9 = r6.containsKey(r10)     // Catch:{ all -> 0x00c9 }
            if (r9 != 0) goto L_0x010f
            androidx.collection.SimpleArrayMap r9 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x00c9 }
            r9.<init>()     // Catch:{ all -> 0x00c9 }
            r6.put(r10, r9)     // Catch:{ all -> 0x00c9 }
        L_0x010f:
            java.lang.Object r9 = r6.get(r10)     // Catch:{ all -> 0x00c9 }
            androidx.collection.SimpleArrayMap r9 = (androidx.collection.SimpleArrayMap) r9     // Catch:{ all -> 0x00c9 }
            r9.put(r8, r12)     // Catch:{ all -> 0x00c9 }
            goto L_0x00a2
        L_0x0119:
            java.lang.String r7 = "HermeticFileOverrides"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00c9 }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ all -> 0x00c9 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c9 }
            r8.<init>()     // Catch:{ all -> 0x00c9 }
            java.lang.String r9 = "Parsed "
            r8.append(r9)     // Catch:{ all -> 0x00c9 }
            r8.append(r4)     // Catch:{ all -> 0x00c9 }
            java.lang.String r4 = " for Android package "
            r8.append(r4)     // Catch:{ all -> 0x00c9 }
            r8.append(r14)     // Catch:{ all -> 0x00c9 }
            java.lang.String r14 = r8.toString()     // Catch:{ all -> 0x00c9 }
            android.util.Log.w(r7, r14)     // Catch:{ all -> 0x00c9 }
            com.google.android.gms.internal.auth.zzci r14 = new com.google.android.gms.internal.auth.zzci     // Catch:{ all -> 0x00c9 }
            r14.<init>(r6)     // Catch:{ all -> 0x00c9 }
            r5.close()     // Catch:{ IOException -> 0x014c }
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzd(r14)     // Catch:{ all -> 0x0068 }
            goto L_0x0173
        L_0x014c:
            r14 = move-exception
            goto L_0x0169
        L_0x014e:
            r5.close()     // Catch:{ all -> 0x0152 }
            goto L_0x0168
        L_0x0152:
            r4 = move-exception
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            java.lang.String r6 = "addSuppressed"
            java.lang.Class[] r7 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0168 }
            java.lang.Class<java.lang.Throwable> r8 = java.lang.Throwable.class
            r7[r1] = r8     // Catch:{ Exception -> 0x0168 }
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch:{ Exception -> 0x0168 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0168 }
            r0[r1] = r4     // Catch:{ Exception -> 0x0168 }
            r5.invoke(r14, r0)     // Catch:{ Exception -> 0x0168 }
        L_0x0168:
            throw r14     // Catch:{ IOException -> 0x014c }
        L_0x0169:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0068 }
            r0.<init>(r14)     // Catch:{ all -> 0x0068 }
            throw r0     // Catch:{ all -> 0x0068 }
        L_0x016f:
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0068 }
        L_0x0173:
            android.os.StrictMode.setThreadPolicy(r3)     // Catch:{ all -> 0x001e }
            goto L_0x0036
        L_0x0178:
            zza = r3     // Catch:{ all -> 0x001e }
            goto L_0x017f
        L_0x017b:
            android.os.StrictMode.setThreadPolicy(r3)     // Catch:{ all -> 0x001e }
            throw r14     // Catch:{ all -> 0x001e }
        L_0x017f:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            return r3
        L_0x0181:
            monitor-exit(r2)     // Catch:{ all -> 0x001e }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzcp.zza(android.content.Context):com.google.android.gms.internal.auth.zzdh");
    }
}
