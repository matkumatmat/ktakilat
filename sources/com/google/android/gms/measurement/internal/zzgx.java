package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

@WorkerThread
final class zzgx implements Runnable {
    final /* synthetic */ zzgy zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzgv zzd;
    private final String zze;
    private final Map zzf;

    public zzgx(zzgy zzgy, String str, URL url, byte[] bArr, Map map, zzgv zzgv) {
        Objects.requireNonNull(zzgy);
        this.zza = zzgy;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzgv);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzgv;
        this.zze = str;
        this.zzf = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f6 A[SYNTHETIC, Splitter:B:52:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0120 A[SYNTHETIC, Splitter:B:71:0x0120] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x015f A[SYNTHETIC, Splitter:B:81:0x015f] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x017b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzgy r1 = r13.zza
            r1.zzaX()
            r2 = 0
            r3 = 0
            java.net.URL r4 = r13.zzb     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            boolean r5 = r4 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            if (r5 == 0) goto L_0x0113
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r4.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            com.google.android.gms.measurement.internal.zzib r5 = r1.zzu     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r5.zzc()     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r6 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r6)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r5.zzc()     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r6 = 61000(0xee48, float:8.5479E-41)
            r4.setReadTimeout(r6)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r4.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            r6 = 1
            r4.setDoInput(r6)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            java.util.Map r7 = r13.zzf     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            if (r7 == 0) goto L_0x0061
            java.util.Set r7 = r7.entrySet()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
        L_0x003f:
            boolean r8 = r7.hasNext()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            if (r8 == 0) goto L_0x0061
            java.lang.Object r8 = r7.next()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.Object r9 = r8.getKey()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.Object r8 = r8.getValue()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.addRequestProperty(r9, r8)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            goto L_0x003f
        L_0x005b:
            r1 = move-exception
            goto L_0x010a
        L_0x005e:
            r1 = move-exception
            goto L_0x010c
        L_0x0061:
            byte[] r7 = r13.zzc     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            if (r7 == 0) goto L_0x00ab
            com.google.android.gms.measurement.internal.zzpf r1 = r1.zzg     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzpj r1 = r1.zzp()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            byte[] r1 = r1.zzv(r7)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzk()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r1.length     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r5.zzb(r7, r9)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.setDoOutput(r6)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r4.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.setFixedLengthStreamingMode(r8)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.connect()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r5.write(r1)     // Catch:{ IOException -> 0x009e, all -> 0x009c }
            r5.close()     // Catch:{ IOException -> 0x009e, all -> 0x009c }
            goto L_0x00ab
        L_0x009c:
            r1 = move-exception
            goto L_0x00a0
        L_0x009e:
            r1 = move-exception
            goto L_0x00a5
        L_0x00a0:
            r8 = r3
            r3 = r5
        L_0x00a2:
            r5 = 0
            goto L_0x011e
        L_0x00a5:
            r8 = r1
            r10 = r3
            r3 = r5
        L_0x00a8:
            r7 = 0
            goto L_0x015d
        L_0x00ab:
            int r8 = r4.getResponseCode()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.util.Map r11 = r4.getHeaderFields()     // Catch:{ IOException -> 0x0106, all -> 0x0102 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00f2 }
            r1.<init>()     // Catch:{ all -> 0x00f2 }
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ all -> 0x00f2 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x00ca }
        L_0x00c0:
            int r7 = r5.read(r6)     // Catch:{ all -> 0x00ca }
            if (r7 <= 0) goto L_0x00cc
            r1.write(r6, r2, r7)     // Catch:{ all -> 0x00ca }
            goto L_0x00c0
        L_0x00ca:
            r1 = move-exception
            goto L_0x00f4
        L_0x00cc:
            byte[] r10 = r1.toByteArray()     // Catch:{ all -> 0x00ca }
            r5.close()     // Catch:{ IOException -> 0x00f0, all -> 0x00ee }
            r4.disconnect()
            com.google.android.gms.measurement.internal.zzgy r0 = r13.zza
            java.lang.String r6 = r13.zze
            com.google.android.gms.measurement.internal.zzgv r7 = r13.zzd
            com.google.android.gms.measurement.internal.zzib r0 = r0.zzu
            com.google.android.gms.measurement.internal.zzhy r0 = r0.zzaW()
            com.google.android.gms.measurement.internal.zzgw r1 = new com.google.android.gms.measurement.internal.zzgw
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
        L_0x00ea:
            r0.zzj(r1)
            return
        L_0x00ee:
            r1 = move-exception
            goto L_0x00fa
        L_0x00f0:
            r1 = move-exception
            goto L_0x00fd
        L_0x00f2:
            r1 = move-exception
            r5 = r3
        L_0x00f4:
            if (r5 == 0) goto L_0x00f9
            r5.close()     // Catch:{ IOException -> 0x00f0, all -> 0x00ee }
        L_0x00f9:
            throw r1     // Catch:{ IOException -> 0x00f0, all -> 0x00ee }
        L_0x00fa:
            r5 = r8
            r8 = r11
            goto L_0x011e
        L_0x00fd:
            r7 = r8
            r10 = r11
        L_0x00ff:
            r8 = r1
            goto L_0x015d
        L_0x0102:
            r1 = move-exception
            r5 = r8
            r8 = r3
            goto L_0x011e
        L_0x0106:
            r1 = move-exception
            r10 = r3
            r7 = r8
            goto L_0x00ff
        L_0x010a:
            r8 = r3
            goto L_0x00a2
        L_0x010c:
            r8 = r1
            r10 = r3
            goto L_0x00a8
        L_0x010f:
            r1 = move-exception
            goto L_0x011b
        L_0x0111:
            r1 = move-exception
            goto L_0x0158
        L_0x0113:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r1.<init>(r4)     // Catch:{ IOException -> 0x0111, all -> 0x010f }
            throw r1     // Catch:{ IOException -> 0x0111, all -> 0x010f }
        L_0x011b:
            r4 = r3
            r8 = r4
            goto L_0x00a2
        L_0x011e:
            if (r3 == 0) goto L_0x013a
            r3.close()     // Catch:{ IOException -> 0x0124 }
            goto L_0x013a
        L_0x0124:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgy r3 = r13.zza
            com.google.android.gms.measurement.internal.zzib r3 = r3.zzu
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()
            java.lang.String r6 = r13.zze
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgt.zzl(r6)
            r3.zzc(r0, r6, r2)
        L_0x013a:
            if (r4 == 0) goto L_0x013f
            r4.disconnect()
        L_0x013f:
            com.google.android.gms.measurement.internal.zzgy r0 = r13.zza
            java.lang.String r3 = r13.zze
            com.google.android.gms.measurement.internal.zzgv r4 = r13.zzd
            com.google.android.gms.measurement.internal.zzib r0 = r0.zzu
            com.google.android.gms.measurement.internal.zzhy r0 = r0.zzaW()
            com.google.android.gms.measurement.internal.zzgw r10 = new com.google.android.gms.measurement.internal.zzgw
            r7 = 0
            r9 = 0
            r6 = 0
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r0.zzj(r10)
            throw r1
        L_0x0158:
            r8 = r1
            r4 = r3
            r10 = r4
            goto L_0x00a8
        L_0x015d:
            if (r3 == 0) goto L_0x0179
            r3.close()     // Catch:{ IOException -> 0x0163 }
            goto L_0x0179
        L_0x0163:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzgy r2 = r13.zza
            com.google.android.gms.measurement.internal.zzib r2 = r2.zzu
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()
            java.lang.String r3 = r13.zze
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)
            r2.zzc(r0, r3, r1)
        L_0x0179:
            if (r4 == 0) goto L_0x017e
            r4.disconnect()
        L_0x017e:
            com.google.android.gms.measurement.internal.zzgy r0 = r13.zza
            java.lang.String r5 = r13.zze
            com.google.android.gms.measurement.internal.zzgv r6 = r13.zzd
            com.google.android.gms.measurement.internal.zzib r0 = r0.zzu
            com.google.android.gms.measurement.internal.zzhy r0 = r0.zzaW()
            com.google.android.gms.measurement.internal.zzgw r1 = new com.google.android.gms.measurement.internal.zzgw
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            goto L_0x00ea
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgx.run():void");
    }
}
