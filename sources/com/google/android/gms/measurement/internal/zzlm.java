package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

@WorkerThread
final class zzlm implements Runnable {
    final /* synthetic */ zzln zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzlk zzd;
    private final String zze;
    private final Map zzf;

    public zzlm(zzln zzln, String str, URL url, byte[] bArr, Map map, zzlk zzlk) {
        Objects.requireNonNull(zzln);
        this.zza = zzln;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzlk);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzlk;
        this.zze = str;
        this.zzf = map;
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map map) {
        this.zza.zzu.zzaW().zzj(new zzll(this, i, exc, bArr, map));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: java.io.OutputStream} */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: type inference failed for: r5v29 */
    /* JADX WARNING: type inference failed for: r5v30 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011c, code lost:
        r5 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005b A[Catch:{ IOException -> 0x00ba, all -> 0x005b, IOException -> 0x005e, all -> 0x005b }, ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0104 A[SYNTHETIC, Splitter:B:55:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0133 A[SYNTHETIC, Splitter:B:77:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x015b A[SYNTHETIC, Splitter:B:87:0x015b] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0177  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzln r1 = r11.zza
            r1.zzaX()
            r2 = 0
            r3 = 0
            java.net.URL r4 = r11.zzb     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            boolean r5 = r4 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            if (r5 == 0) goto L_0x0126
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            r4.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            com.google.android.gms.measurement.internal.zzib r1 = r1.zzu     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            r1.zzc()     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            r5 = 60000(0xea60, float:8.4078E-41)
            r4.setConnectTimeout(r5)     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            r1.zzc()     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            r5 = 61000(0xee48, float:8.5479E-41)
            r4.setReadTimeout(r5)     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            r4.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            r5 = 1
            r4.setDoInput(r5)     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            java.util.Map r6 = r11.zzf     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            if (r6 == 0) goto L_0x0061
            java.util.Set r6 = r6.entrySet()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
        L_0x003f:
            boolean r7 = r6.hasNext()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            if (r7 == 0) goto L_0x0061
            java.lang.Object r7 = r6.next()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.Object r8 = r7.getKey()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.Object r7 = r7.getValue()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.addRequestProperty(r8, r7)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            goto L_0x003f
        L_0x005b:
            r1 = move-exception
            goto L_0x011c
        L_0x005e:
            r1 = move-exception
            goto L_0x011f
        L_0x0061:
            byte[] r6 = r11.zzc     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            if (r6 == 0) goto L_0x00cd
            r1.zzaU()     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            r1.<init>()     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            java.util.zip.GZIPOutputStream r7 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            r7.<init>(r1)     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            r7.write(r6)     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            r7.close()     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            r1.close()     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            byte[] r1 = r1.toByteArray()     // Catch:{ IOException -> 0x00ba, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzln r6 = r11.zza     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzib r6 = r6.zzu     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzk()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r1.length     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r6.zzb(r7, r9)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.setDoOutput(r5)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r4.addRequestProperty(r5, r6)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.setFixedLengthStreamingMode(r8)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.connect()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r5.write(r1)     // Catch:{ IOException -> 0x00b2, all -> 0x00b0 }
            r5.close()     // Catch:{ IOException -> 0x00b2, all -> 0x00b0 }
            goto L_0x00cd
        L_0x00b0:
            r1 = move-exception
            goto L_0x00b4
        L_0x00b2:
            r1 = move-exception
            goto L_0x00b7
        L_0x00b4:
            r6 = r3
            goto L_0x0131
        L_0x00b7:
            r6 = r3
            goto L_0x0159
        L_0x00ba:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzln r5 = r11.zza     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzib r5 = r5.zzu     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.lang.String r6 = "Failed to gzip post request content"
            r5.zzb(r6, r1)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            throw r1     // Catch:{ IOException -> 0x005e, all -> 0x005b }
        L_0x00cd:
            int r1 = r4.getResponseCode()     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            java.util.Map r5 = r4.getHeaderFields()     // Catch:{ IOException -> 0x0118, all -> 0x0114 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0100 }
            r6.<init>()     // Catch:{ all -> 0x0100 }
            java.io.InputStream r7 = r4.getInputStream()     // Catch:{ all -> 0x0100 }
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch:{ all -> 0x00ec }
        L_0x00e2:
            int r9 = r7.read(r8)     // Catch:{ all -> 0x00ec }
            if (r9 <= 0) goto L_0x00ee
            r6.write(r8, r2, r9)     // Catch:{ all -> 0x00ec }
            goto L_0x00e2
        L_0x00ec:
            r2 = move-exception
            goto L_0x0102
        L_0x00ee:
            byte[] r2 = r6.toByteArray()     // Catch:{ all -> 0x00ec }
            r7.close()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
            r4.disconnect()
            r11.zzb(r1, r3, r2, r5)
            return
        L_0x00fc:
            r2 = move-exception
            goto L_0x0108
        L_0x00fe:
            r2 = move-exception
            goto L_0x010e
        L_0x0100:
            r2 = move-exception
            r7 = r3
        L_0x0102:
            if (r7 == 0) goto L_0x0107
            r7.close()     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
        L_0x0107:
            throw r2     // Catch:{ IOException -> 0x00fe, all -> 0x00fc }
        L_0x0108:
            r6 = r5
            r5 = r3
        L_0x010a:
            r10 = r2
            r2 = r1
            r1 = r10
            goto L_0x0131
        L_0x010e:
            r6 = r5
            r5 = r3
        L_0x0110:
            r10 = r2
            r2 = r1
            r1 = r10
            goto L_0x0159
        L_0x0114:
            r2 = move-exception
            r5 = r3
            r6 = r5
            goto L_0x010a
        L_0x0118:
            r2 = move-exception
            r5 = r3
            r6 = r5
            goto L_0x0110
        L_0x011c:
            r5 = r3
        L_0x011d:
            r6 = r5
            goto L_0x0131
        L_0x011f:
            r5 = r3
        L_0x0120:
            r6 = r5
            goto L_0x0159
        L_0x0122:
            r1 = move-exception
            goto L_0x012e
        L_0x0124:
            r1 = move-exception
            goto L_0x0156
        L_0x0126:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r1.<init>(r4)     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
            throw r1     // Catch:{ IOException -> 0x0124, all -> 0x0122 }
        L_0x012e:
            r4 = r3
            r5 = r4
            goto L_0x011d
        L_0x0131:
            if (r5 == 0) goto L_0x014d
            r5.close()     // Catch:{ IOException -> 0x0137 }
            goto L_0x014d
        L_0x0137:
            r5 = move-exception
            com.google.android.gms.measurement.internal.zzln r7 = r11.zza
            com.google.android.gms.measurement.internal.zzib r7 = r7.zzu
            com.google.android.gms.measurement.internal.zzgt r7 = r7.zzaV()
            com.google.android.gms.measurement.internal.zzgr r7 = r7.zzb()
            java.lang.String r8 = r11.zze
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r8)
            r7.zzc(r0, r8, r5)
        L_0x014d:
            if (r4 == 0) goto L_0x0152
            r4.disconnect()
        L_0x0152:
            r11.zzb(r2, r3, r3, r6)
            throw r1
        L_0x0156:
            r4 = r3
            r5 = r4
            goto L_0x0120
        L_0x0159:
            if (r5 == 0) goto L_0x0175
            r5.close()     // Catch:{ IOException -> 0x015f }
            goto L_0x0175
        L_0x015f:
            r5 = move-exception
            com.google.android.gms.measurement.internal.zzln r7 = r11.zza
            com.google.android.gms.measurement.internal.zzib r7 = r7.zzu
            com.google.android.gms.measurement.internal.zzgt r7 = r7.zzaV()
            com.google.android.gms.measurement.internal.zzgr r7 = r7.zzb()
            java.lang.String r8 = r11.zze
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r8)
            r7.zzc(r0, r8, r5)
        L_0x0175:
            if (r4 == 0) goto L_0x017a
            r4.disconnect()
        L_0x017a:
            r11.zzb(r2, r1, r3, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlm.run():void");
    }

    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzd.zza(this.zze, i, exc, bArr, map);
    }
}
